package com.pos_application.pos.service.impl;


import com.pos_application.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.pos_application.pos.dto.query.OrderDetailInterface;
import com.pos_application.pos.dto.request.RequestOrderSaveDTO;
import com.pos_application.pos.dto.response.ResponseOrderDetailsDTO;
import com.pos_application.pos.entity.Order;
import com.pos_application.pos.entity.OrderDetails;
import com.pos_application.pos.repo.CustomerRepo;
import com.pos_application.pos.repo.OrderDetailsRepo;
import com.pos_application.pos.repo.OrderRepo;
import com.pos_application.pos.repo.itemRepo;
import com.pos_application.pos.service.OrderService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private OrderDetailsRepo orderDetailsRepo;

    @Autowired
    itemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Order order = new Order(
                customerRepo.getReferenceById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getOrderDate(), requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if (orderRepo.existsById(order.getOrderId())) {
            List<OrderDetails> orderDetails = modelMapper.map(requestOrderSaveDTO.getOrdersDetails(),
                    new TypeToken<List<OrderDetails>>() {
                    }.getType());
            for (int i =0; i < orderDetails.size(); i++) {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItem(itemRepo.getReferenceById(requestOrderSaveDTO.getOrdersDetails().get(i).getItem()));
            }
            if (orderDetails.size() > 0) {
                orderDetailsRepo.saveAll(orderDetails);
            }
            return "Saved";
        }
        return "Not Saved";

    }

    @Override
    public PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size) {
        List<OrderDetailInterface> orderDetails = orderRepo.getAllOrderDetails(status, PageRequest.of(page,size));

        List<ResponseOrderDetailsDTO> list = new ArrayList<>();
        for (OrderDetailInterface orderDetail : orderDetails) {
            ResponseOrderDetailsDTO dto = new ResponseOrderDetailsDTO(
                    orderDetail.getCustomerName(),
                    orderDetail.getCustomerAddress(),
                    orderDetail.getContactNo(),
                    orderDetail.getOrderDate(),
                    orderDetail.getTotal()

            );
            list.add(dto);
        }

        PaginatedResponseOrderDetails prod = new PaginatedResponseOrderDetails(
                list,
                5
        );
        return prod;

    }

}
