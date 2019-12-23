package com.senlainc.training.backend.services;

import com.senlainc.training.backend.domain.Customer;
import com.senlainc.training.backend.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl {

    @Autowired
    private ICustomerRepository customerRepository;

    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    public List<Customer> findAll() {
        return (List<Customer>) this.customerRepository.findAll();
    }

    public Customer findById(Long id) {
        Customer customer = null;
        Optional<Customer> optionalCustomer = this.customerRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            customer = optionalCustomer.get();
        }
        return customer;
    }

    public void deleteById(Long id) {
        this.customerRepository.deleteById(id);
    }
}
