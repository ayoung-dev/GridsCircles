package org.example.coffee.model.service;

import org.example.coffee.model.dto.OrderDTO;
import org.example.coffee.model.dto.OrderItemDTO;
import org.example.coffee.model.repository.OrderItemRepository;
import org.example.coffee.model.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

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

    public List<List<OrderItemDTO>> getItemsByEmailList(String email) throws SQLException {
        List<List<OrderItemDTO>> orderItemList = new java.util.ArrayList<>(List.of());

        //order 테이블에서 주문 조회
        List<String> orders = orderRepo.findByEmail(email);
        for(String order : orders) {
            List<OrderItemDTO> orderItemDTOList = orderItemRepo.findByOrderId(order);
            orderItemList.add(orderItemDTOList);
        }

        return orderItemList;
    }

    public int updateOrderItem(int seq, int quantity) throws SQLException {
        return orderItemRepo.updateOrderItem(seq, quantity);
    }

    public int deleteOrderItem(int seq) throws SQLException {
        return orderItemRepo.deleteOrderItem(seq);
    }

    public int addOrderItem(OrderItemDTO orderItemDTO) throws SQLException {
        return orderItemRepo.insertOrderItem(orderItemDTO);
    }
}
