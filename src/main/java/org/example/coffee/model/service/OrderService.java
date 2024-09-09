package org.example.coffee.model.service;

import org.example.coffee.model.dto.OrderDTO;
import org.example.coffee.model.dto.OrderItemDTO;
import org.example.coffee.model.repository.OrderItemRepository;
import org.example.coffee.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Transactional
    public void addOrder(OrderDTO orderDTO) throws SQLException {
        //order 테이블 추가
        orderRepo.insertOrder(orderDTO);

        //order_items 테이블 추가
        for(OrderItemDTO orderItemDTO : orderDTO.getOrderItemDTOList()) {
            orderItemRepo.insertOrderItem(orderItemDTO);
        }
    }

    public int deleteOrder(String orderId) throws SQLException {
        return orderRepo.deleteOrder(orderId);
    }

    public int updateInfo(OrderDTO orderDTO) throws SQLException {
        return orderRepo.updateOrder(orderDTO);
    }
}
