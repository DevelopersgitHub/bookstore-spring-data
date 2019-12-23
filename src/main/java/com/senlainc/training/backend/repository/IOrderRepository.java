package com.senlainc.training.backend.repository;

import com.senlainc.training.backend.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface IOrderRepository extends CrudRepository<Order, Long> {

}
