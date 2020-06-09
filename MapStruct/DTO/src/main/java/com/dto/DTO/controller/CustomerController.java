package com.dto.DTO.controller;

import com.dto.DTO.model.CustomerDTO;
import com.dto.DTO.model.CustomerListDTO;
import com.dto.DTO.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers(){
        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(this.customerService.getAllCustomers()),
                HttpStatus.OK
        );
    }

    @GetMapping
    @RequestMapping("/{name}")
    public ResponseEntity<CustomerDTO> getCustomerByName(@PathVariable String name){
        return new ResponseEntity<CustomerDTO>(
                this.customerService.getCustomerByLastName(name),
                HttpStatus.OK
        );
    }
}
