package Shop.Customer.controller;

import Shop.Customer.domain.Customer;
import Shop.Customer.domain.Order;
import Shop.Customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/customer/")
@RequiredArgsConstructor
public class CustomerController {


    private final CustomerService customerService;


    @PostMapping
    @RequestMapping("new")
    public ResponseEntity<Customer> newCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.newCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("pay")
    public ResponseEntity<BigDecimal> pay(@PathVariable Long id){
        return new ResponseEntity<>(customerService.getFinalBill(id), HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping("order/{id}")
    public ResponseEntity<BigDecimal> order(@RequestBody Order order, @PathVariable Long id){
        return new ResponseEntity<>(customerService.order(id, order), HttpStatus.CREATED);
    }
}
