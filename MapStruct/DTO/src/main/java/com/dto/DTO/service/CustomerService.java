package com.dto.DTO.service;

import com.dto.DTO.model.CustomerDTO;

import java.util.List;


public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByLastName(String name);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
