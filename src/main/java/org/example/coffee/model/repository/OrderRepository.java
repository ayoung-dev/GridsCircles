package org.example.coffee.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.coffee.model.dto.OrderDTO;

import java.sql.SQLException;

@Mapper
public interface OrderRepository {
    int insertOrder(OrderDTO orderDTO) throws SQLException;
}
