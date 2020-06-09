package com.dto.DTO.controller;

import com.dto.DTO.model.CustomerDTO;
import com.dto.DTO.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static com.dto.DTO.controller.AbstractRestControllerTest.asJsonString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class CustomerControllerTest {

    @Mock
    CustomerService customerService;

    @InjectMocks
    CustomerController customerController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception{

        MockitoAnnotations.initMocks(this);

        mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    void getAllCustomers() throws Exception {

        CustomerDTO customer1 = new CustomerDTO();
        customer1.setLastName("Margaritis");
        customer1.setFirstName("Anastasios");
        customer1.setId(1L);

        CustomerDTO customer2 = new CustomerDTO();
        customer2.setId(2L);
        customer2.setFirstName("George");
        customer2.setLastName("Margaritis");

        CustomerDTO customer3 = new CustomerDTO();
        customer3.setLastName("Molozi");
        customer3.setFirstName("Anthi");
        customer3.setId(3L);

        List<CustomerDTO> customers = Arrays.asList(customer1, customer2, customer3);

        when(customerService.getAllCustomers()).thenReturn(customers);

        mockMvc.perform(get("/customers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customers", hasSize(3)));

    }

    @Test
    void getCustomerByName() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setLastName("Margaritis");
        customerDTO.setFirstName("Anastasios");
        customerDTO.setId(1L);

        when(customerService.getCustomerByLastName("Margaritis")).thenReturn(customerDTO);

        mockMvc.perform(get("/customers/Margaritis")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName", equalTo("Margaritis")));
    }

    @Test
    void createNewCustomer() throws Exception {

        //given
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Anastasios");
        customerDTO.setLastName("Margaritis");

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstName(customerDTO.getFirstName());
        returnDTO.setLastName(customerDTO.getLastName());
        returnDTO.setId(customerDTO.getId());

        when(customerService.createNewCustomer(customerDTO)).thenReturn(returnDTO);

        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", equalTo("Anastasios")));
    }

    @Test
    void updateCustomer() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Anastasios");
        customerDTO.setLastName("Margaritis");
        customerDTO.setId(1L);

        CustomerDTO returnDTO = new CustomerDTO();
        returnDTO.setFirstName(customerDTO.getFirstName());
        returnDTO.setLastName(customerDTO.getLastName());
        returnDTO.setId(customerDTO.getId());

        when(customerService.updateCustomer(customerDTO.getId(), customerDTO)).thenReturn(returnDTO);


        mockMvc.perform(put("/customers/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(customerDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", equalTo("Anastasios")))
                .andExpect(jsonPath("$.lastName", equalTo("Margaritis")));
    }

    @Test
    void deleteCustomer() throws Exception{

        mockMvc.perform(delete("/customers/1")
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());

        verify(customerService).deleteCustomerById(anyLong());
    }
}