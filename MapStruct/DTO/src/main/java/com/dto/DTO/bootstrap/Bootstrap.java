package com.dto.DTO.bootstrap;

import com.dto.DTO.domain.Category;
import com.dto.DTO.domain.Customer;
import com.dto.DTO.repository.CategoryRepository;
import com.dto.DTO.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        this.categoryRepository.save(fruits);
        this.categoryRepository.save(dried);
        this.categoryRepository.save(fresh);
        this.categoryRepository.save(exotic);
        this.categoryRepository.save(nuts);

        Customer george = new Customer();
        george.setFirstName("George");
        george.setLastName("Margaritis");
        george.setId(1L);

        Customer anthi = new Customer();
        anthi.setId(2L);
        anthi.setLastName("Molozi");
        anthi.setFirstName("Anthi");

        Customer me = new Customer();
        me.setFirstName("Anastasios");
        me.setLastName("Margaritis");

        this.customerRepository.save(george);
        this.customerRepository.save(anthi);
        this.customerRepository.save(me);

        System.out.println("Tis manas sou to mouni toses fores: " +
                this.categoryRepository.count());


    }
}
