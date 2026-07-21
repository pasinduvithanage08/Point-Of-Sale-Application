package com.pos_application.pos.service;

import com.pos_application.pos.dto.paginated.PaginatedResponseOrderDetails;
import com.pos_application.pos.dto.request.RequestOrderSaveDTO;
import jakarta.validation.constraints.Max;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, @Max(50) int size);
}
