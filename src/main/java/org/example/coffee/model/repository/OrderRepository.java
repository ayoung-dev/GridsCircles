package org.example.coffee.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.coffee.model.dto.OrderDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface OrderRepository {
    int insertOrder(OrderDTO orderDTO) throws SQLException;
    int deleteOrder(String orderId) throws SQLException;
    int updateOrder(OrderDTO orderDTO) throws SQLException;
    List<String> findByEmail(String email) throws SQLException;
}
