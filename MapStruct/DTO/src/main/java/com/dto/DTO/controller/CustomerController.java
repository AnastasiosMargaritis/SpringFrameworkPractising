package com.dto.DTO.controller;

import com.dto.DTO.model.CustomerDTO;
import com.dto.DTO.model.CustomerListDTO;
import com.dto.DTO.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<CustomerDTO> createNewCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>(
                customerService.createNewCustomer(customerDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO, @PathVariable Long id){
        return new ResponseEntity<CustomerDTO>(
                this.customerService.updateCustomer(id, customerDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){

        this.customerService.deleteCustomerById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
