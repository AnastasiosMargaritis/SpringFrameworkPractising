package com.dto.DTO.mapper;

import com.dto.DTO.domain.Customer;
import com.dto.DTO.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setFirstName( customer.getFirstName() );
        customerDTO.setLastName( customer.getLastName() );

        return customerDTO;
    }
}
