package com.senlainc.training.backend.services;

import com.senlainc.training.backend.domain.Order;
import com.senlainc.training.backend.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl {

    @Autowired
    private IOrderRepository orderRepository;

    public void save(Order order) {
        this.orderRepository.save(order);
    }

    public List<Order> findAll() {
        return (List<Order>) this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        Order order = null;
        Optional<Order> optionalOrder = this.orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            order = optionalOrder.get();
        }
        return order;
    }

    public void deleteById(Long id) {
        this.orderRepository.deleteById(id);
    }

}
