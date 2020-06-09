package com.dto.DTO.mapper;

import com.dto.DTO.domain.Customer;
import com.dto.DTO.model.CustomerDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerMapperTest {

    CustomerMapper customerMapper = CustomerMapper.INSTANCE;

    @Test
    void customerToCustomerDTO() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Anastasios");
        customer.setLastName("Margaritis");

        //when
        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        //then
        assertEquals(Long.valueOf(1L), customerDTO.getId());
        assertEquals("Anastasios", customerDTO.getFirstName());
        assertEquals("Margaritis", customerDTO.getLastName());
    }
}