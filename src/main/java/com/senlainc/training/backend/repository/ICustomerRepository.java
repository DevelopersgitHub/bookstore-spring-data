package com.senlainc.training.backend.repository;

import com.senlainc.training.backend.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface ICustomerRepository extends CrudRepository<Customer, Long> {

}
