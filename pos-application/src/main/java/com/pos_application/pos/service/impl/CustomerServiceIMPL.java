package com.pos_application.pos.service.impl;

import com.pos_application.pos.dto.CustomerDTO;
import com.pos_application.pos.dto.request.CustomerUpdateDTO;
import com.pos_application.pos.entity.Customer;
import com.pos_application.pos.exception.NotFoundException;
import com.pos_application.pos.repo.CustomerRepo;
import com.pos_application.pos.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerRepo.findById(customerDTO.getCustomerId())
                .orElse(new Customer(
                        customerDTO.getCustomerId(),
                        customerDTO.getCustomerName(),
                        customerDTO.getCustomerAddress(),
                        customerDTO.getCustomerSalary(),
                        customerDTO.getContactNo(),
                        customerDTO.getNic(),
                        customerDTO.isActive()
                ));
        customerRepo.save(customer);
        return customerDTO.getCustomerName();
    }

    @Override
    public String UpdateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if (customerRepo.existsById(customerUpdateDTO.getCustomerId())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerId());
            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());
            customerRepo.save(customer);
            return customerUpdateDTO.getCustomerName() + " Updated Successfully";
        } else {
            throw new NotFoundException("Customer Not Found");
        }
        // return null;
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        if (customerRepo.existsById(customerId)) {
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerId(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getCustomerSalary(),
                    customer.getContactNo(),
                    customer.getNic(),
                    customer.isActive()
            );
            return customerDTO;

        } else {
            throw new NotFoundException("Customer Not Found");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> getAllCustomers = customerRepo.findAll();
        List<CustomerDTO> customerDTOList = new ArrayList<>();
        if (getAllCustomers.size() > 0) {
            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getContactNo(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        } else {
            throw new NotFoundException("Customer Not Found");
        }


    }

    @Override
    public String deleteCustomer(int customerId) {
        if (customerRepo.existsById(customerId)) {
            customerRepo.deleteById(customerId);
            return "Customer Deleted Successfully " + " " + customerId;
        } else {
            throw new RuntimeException("No Customer Data Found in that Id");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomersByActiveState(boolean activeState) {
        List<Customer> getAllCustomers = customerRepo.findAllByActiveEquals(activeState);
        List<CustomerDTO> customerDTOList = new ArrayList<>();

        if (getAllCustomers.size() > 0) {
            for (Customer customer : getAllCustomers) {
                CustomerDTO customerDTO = new CustomerDTO(
                        customer.getCustomerId(),
                        customer.getCustomerName(),
                        customer.getCustomerAddress(),
                        customer.getCustomerSalary(),
                        customer.getContactNo(),
                        customer.getNic(),
                        customer.isActive()
                );
                customerDTOList.add(customerDTO);
            }
            return customerDTOList;
        } else throw new NotFoundException("Customer Not Found");
    }


}
