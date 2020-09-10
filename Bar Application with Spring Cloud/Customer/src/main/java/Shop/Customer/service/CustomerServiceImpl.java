package Shop.Customer.service;

import Shop.Customer.domain.Customer;
import Shop.Customer.domain.Order;
import Shop.Customer.repository.CustomerRepository;
import Shop.Customer.service.bar.BarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final BarService barService;

    @Override
    public Customer newCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public BigDecimal getFinalBill(Long id) {

        Customer customer = customerRepository.findById(id).get();

        this.deleteCustomer(id);

        return customer.getBill();
    }

    @Override
    public BigDecimal order(Long id, Order order) {

        Customer customer = customerRepository.findById(id).get();

        customer.setBill(customer.getBill().add(barService.order(order.getDrinkType())));

        customerRepository.save(customer);

        return customer.getBill();
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
