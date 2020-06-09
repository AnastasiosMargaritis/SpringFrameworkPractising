package com.dto.DTO.service;

import com.dto.DTO.domain.Customer;
import com.dto.DTO.mapper.CustomerMapper;
import com.dto.DTO.model.CustomerDTO;
import com.dto.DTO.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerServiceImplTest {

    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception{

        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    void getAllCustomers() {

        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());

        when(customerRepository.findAll()).thenReturn(customers);

        //when
        List<CustomerDTO> customerDTOS = customerService.getAllCustomers();

        //then
        assertEquals(3, customerDTOS.size());
    }

    @Test
    void getCustomerByLastName() {

        Customer customer =  new Customer();
        customer.setLastName("Margaritis");
        customer.setFirstName("Anastasios");
        customer.setId(1L);

        when(customerRepository.findByLastName(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByLastName("Margaritis");

        //then
        assertEquals("Margaritis", customerDTO.getLastName());
    }
}