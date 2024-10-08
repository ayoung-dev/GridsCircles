package org.example.coffee.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.coffee.model.dto.OrderItemDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderItemRepository {
    int insertOrderItem(OrderItemDTO orderItemDTO) throws SQLException;
    List<OrderItemDTO> findByOrderId(String orderId) throws SQLException;
    int updateOrderItem(int seq, int quantity) throws SQLException;
    int deleteOrderItem(int seq) throws SQLException;
}
