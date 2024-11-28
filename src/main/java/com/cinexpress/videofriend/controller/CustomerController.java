package com.cinexpress.videofriend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.services.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

     @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

        @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return customers.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long customerId, @RequestBody Customer customer) {
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return updatedCustomer != null ? new ResponseEntity<>(updatedCustomer, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

      @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        try {
            customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{customerId}/activatePremium")
    public ResponseEntity<Void> activatePremium(@PathVariable Long customerId) {
        customerService.activatePremiumSubscription(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{customerId}/loyalty")
    public ResponseEntity<Void> addLoyaltyPoints(@PathVariable Long customerId, @RequestBody int points) {
        customerService.addLoyaltyPoints(customerId, points);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{customerId}/loyalty")
    public ResponseEntity<Integer> getLoyaltyPoints(@PathVariable Long customerId) {
        int points = customerService.getLoyaltyPoints(customerId);
        return new ResponseEntity<>(points, HttpStatus.OK);
    }

    @PutMapping("/{customerId}/removeLoyalty")
    public ResponseEntity<Void> removeLoyaltyPoints(@PathVariable Long customerId, @RequestBody int points) {
        customerService.removeLoyaltyPoints(customerId, points);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
