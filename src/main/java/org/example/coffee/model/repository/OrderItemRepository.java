package org.example.coffee.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.coffee.model.dto.OrderItemDTO;

import java.sql.SQLException;

@Mapper
public interface OrderItemRepository {
    void insertOrderItem(OrderItemDTO orderItemDTO) throws SQLException;
}
