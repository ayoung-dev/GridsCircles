package org.example.coffee.model.repository;

import org.apache.ibatis.annotations.Mapper;
import org.example.coffee.model.dto.ProductDTO;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface ProductRepository {
    List<ProductDTO> findAll() throws SQLException;
    List<String> findAllCategory() throws SQLException;
    List<ProductDTO> findByCategory(String category) throws SQLException;
}
