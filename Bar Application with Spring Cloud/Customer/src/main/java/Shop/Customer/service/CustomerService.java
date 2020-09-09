package Shop.Customer.service;

import Shop.Customer.domain.Customer;
import Shop.Customer.domain.Order;

import java.math.BigDecimal;

public interface CustomerService {

    Customer newCustomer(Customer customer);

    BigDecimal getFinalBill(Long id);

    BigDecimal order(Long id, Order order);

    void deleteCustomer(Long id);
}
