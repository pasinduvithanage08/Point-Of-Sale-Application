package com.pos_application.pos.controller;

import com.pos_application.pos.dto.CustomerDTO;
import com.pos_application.pos.dto.request.CustomerUpdateDTO;
import com.pos_application.pos.service.CustomerService;
import com.pos_application.pos.service.impl.CustomerServiceIMPL;
import com.pos_application.pos.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @PostMapping("/save")
    public ResponseEntity <StandardResponse>saveCustomer(@RequestBody CustomerDTO customerDTO) {
       String Message = customerService.saveCustomer( customerDTO );
       ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(new StandardResponse(
               201,"Customer Saved Successfully",Message), HttpStatus.CREATED);
        return response;

    }
    @PutMapping("/update")
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerUpdateDTO customerUpdateDTO) {
    String Message =customerService.UpdateCustomer(customerUpdateDTO);
    ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
            new StandardResponse(201,"Customer Updated Successfully",Message), HttpStatus.CREATED);
    return response;

    }

    @GetMapping(
            path ="/get-by-id",
            params = "id"
    )
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int customerId) {
        CustomerDTO customerDTO = customerService.getCustomerById(customerId);
        return customerDTO;
    }



    @GetMapping(
            path = "/get-all-customers"
    )
    public ResponseEntity<StandardResponse> getAllCustomers() {
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success",allCustomers), HttpStatus.OK);
        return response;

    }

    @DeleteMapping(
            path = "delete-customer/{id}"
    )
    public String deleteCustomer(@PathVariable(value ="id") int CustomerId) {
        String Delete = customerService.deleteCustomer(CustomerId);
        return Delete;
    }

    @GetMapping(
            path = "/get-all-customers-by-active-state{states}"
    )
    public List<CustomerDTO> getAllCustomersByActiveState(@PathVariable(value = "states")boolean activeState) {
        List<CustomerDTO> allCustomers = customerService.getAllCustomersByActiveState(activeState);
        return allCustomers;

    }



}
