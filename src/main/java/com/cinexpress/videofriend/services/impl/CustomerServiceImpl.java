package com.cinexpress.videofriend.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinexpress.videofriend.models.Company;
import com.cinexpress.videofriend.models.Customer;
import com.cinexpress.videofriend.models.Movie;
import com.cinexpress.videofriend.models.PremiumSubscription;
import com.cinexpress.videofriend.repository.CompanyRepository;
import com.cinexpress.videofriend.repository.CustomerRepository;
import com.cinexpress.videofriend.repository.MovieRepository;
import com.cinexpress.videofriend.repository.PremiumSubscriptionRepository;
import com.cinexpress.videofriend.services.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    PremiumSubscriptionRepository premiumSubscriptionRepository;

    @Override
    public void addClientToCompany(Long customerId, Long companyId) {
        Customer customer = customerRepository.findById(customerId).get();
        Optional<Company> company = companyRepository.findById(companyId);
        if(!company.isEmpty()){
            Company updateCompany = company.get();
            updateCompany.getCustomers().add(customer);
            companyRepository.save(updateCompany);
        } else {
            throw new IllegalArgumentException("Customer or Company not found.");
        }
    }

    @Override
    public boolean hasPremiumSubscription(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            PremiumSubscription premium = customer.get().getPremiumSubscription();
            return premium != null && premium.getExclusiveCatalog();
        }
        throw new IllegalArgumentException("Customer not found");
    }

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findById(customer.getId());
        if (existingCustomer.isPresent()) {
            return customerRepository.save(customer);
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> existingCustomer = customerRepository.findById(customerId);
        if (existingCustomer.isPresent()) {
            customerRepository.delete(existingCustomer.get());
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
    }

    @Override
    public void addMovieToCostumer(Long customerId, Movie movie) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            movie.setCustomer(customer.get());
        } else {
            throw new IllegalArgumentException("Customer not found");
        } 
    }

    @Override
    public void activatePremiumSubscription(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            PremiumSubscription premium = customer.get().getPremiumSubscription();
            if (premium == null) {
                premium = new PremiumSubscription();
            }
            premium.setExclusiveCatalog(true);
            premium.setDiscounts(true);
            premium.setPreReleases(true);
            premium.setCustomer(customer.get());
            premiumSubscriptionRepository.save(premium);
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public void addLoyaltyPoints(Long customerId, int points) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.save(customer.get());
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public int getLoyaltyPoints(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            return customer.get().getLoyaltyPoints();
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public void removeLoyaltyPoints(Long customerId, int points) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.save(customer.get());
        } else {
            throw new IllegalArgumentException("Customer not found");
        }
    }

    @Override
    public List<Customer> getCustomersByType(String type) {
        return customerRepository.findByType(type);
    }

    @Override
    public List<Customer> searchCustomerByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()) {
            customerRepository.delete(customer.get());
        } else {
            throw new IllegalArgumentException("Customer with id " + customerId + " not found");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
