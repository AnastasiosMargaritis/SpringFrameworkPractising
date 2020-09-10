package Shop.Customer.bootstrap;

import Shop.Customer.domain.Customer;
import Shop.Customer.domain.Drink;
import Shop.Customer.repository.CustomerRepository;
import Shop.Customer.repository.DrinkRepository;
import Shop.Customer.service.bar.BarService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Bootstrap implements CommandLineRunner {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BarService barService;

    @Autowired
    private DrinkRepository drinkRepository;

    @Autowired
    private ObjectMapper mapper;

    @Override
    public void run(String... args) throws Exception {

        List<Customer> customers = new ArrayList<>();

        Customer customer = new Customer().builder()
                            .id(1L)
                            .firstName("Anastasios")
                            .lastName("Margaritis")
                            .bill(new BigDecimal("50.00"))
                            .build();

        Customer customer1 = new Customer().builder()
                            .id(2L)
                            .firstName("Kostas")
                            .lastName("Xatzistavros")
                            .bill(new BigDecimal("48.00"))
                            .build();

        Customer customer2 = new Customer().builder()
                            .id(3L)
                            .firstName("Argyris")
                            .lastName("Ketsetsis")
                            .bill(new BigDecimal("68.80"))
                            .build();

        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);

        List<Drink> drinks = mapper.convertValue(
                barService.getAllDrinks(),
                new TypeReference<List<Drink>>() {
                }
        );


        drinkRepository.saveAll(drinks);
        customerRepository.saveAll(customers);
    }
}
