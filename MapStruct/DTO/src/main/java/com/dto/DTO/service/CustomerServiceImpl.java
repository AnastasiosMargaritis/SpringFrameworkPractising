package com.dto.DTO.service;

import com.dto.DTO.domain.Customer;
import com.dto.DTO.mapper.CustomerMapper;
import com.dto.DTO.model.CustomerDTO;
import com.dto.DTO.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return this.customerRepository
                .findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByLastName(String name) {
        return this.customerMapper
                .customerToCustomerDTO(
                        this.customerRepository.findByLastName(name)
                );
    }

    @Override
    public CustomerDTO createNewCustomer(CustomerDTO customerDTO) {

        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);

        Customer savedCustomer = customerRepository.save(customer);

        CustomerDTO returnedCustomer = customerMapper.customerToCustomerDTO(savedCustomer);

        return  returnedCustomer;
    }


    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        return this.customerRepository.findById(id)
                .map(customer -> {
                    customer = customerMapper.customerDTOToCustomer(customerDTO);
                    customerRepository.save(customer);

                    return customerMapper.customerToCustomerDTO(customer);
                })
                .orElseGet(() -> {
                    Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
                    customerRepository.save(customer);
                    return customerMapper.customerToCustomerDTO(customer);
                });
    }

    @Override
    public void deleteCustomerById(Long id) {
        this.customerRepository.deleteById(id);
    }
}
