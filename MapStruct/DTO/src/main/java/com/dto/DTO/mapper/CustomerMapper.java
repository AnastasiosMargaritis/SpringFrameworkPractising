package com.dto.DTO.mapper;

import com.dto.DTO.domain.Category;
import com.dto.DTO.domain.Customer;
import com.dto.DTO.model.CategoryDTO;
import com.dto.DTO.model.CustomerDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.annotation.Generated;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    @Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2020-06-10T00:12:53+0300",
        comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
    )
    class CustomerMapperImpl implements CustomerMapper {

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

        @Override
        public Customer customerDTOToCustomer(CustomerDTO customerDTO) {
            if ( customerDTO == null ) {
                return null;
            }

            Customer customer = new Customer();

            customer.setId( customerDTO.getId() );
            customer.setFirstName( customerDTO.getFirstName() );
            customer.setLastName( customerDTO.getLastName() );

            return customer;
        }
    }

    @Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2020-06-10T00:11:48+0300",
        comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_231 (Oracle Corporation)"
    )
    class CategoryMapperImpl implements CategoryMapper {

        @Override
        public CategoryDTO categoryToCategoryDTO(Category category) {
            if ( category == null ) {
                return null;
            }

            CategoryDTO categoryDTO = new CategoryDTO();

            categoryDTO.setId( category.getId() );
            categoryDTO.setName( category.getName() );

            return categoryDTO;
        }
    }
}
