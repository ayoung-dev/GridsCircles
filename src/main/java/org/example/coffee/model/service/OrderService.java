package org.example.coffee.model.service;

import org.example.coffee.model.dto.OrderDTO;
import org.example.coffee.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;

    public int addOrder(OrderDTO orderDTO) throws SQLException {
        return repo.insertOrder(orderDTO);
    }

    public int deleteOrder(String orderId) throws SQLException {
        return repo.deleteOrder(orderId);
    }
}
