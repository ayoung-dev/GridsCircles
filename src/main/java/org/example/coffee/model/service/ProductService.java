package org.example.coffee.model.service;

import org.example.coffee.model.dto.ProductDTO;
import org.example.coffee.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<ProductDTO> getProductList() throws SQLException {
        return repo.findAll();
    }

    public List<String> getCategoryList() throws SQLException {
        return repo.findAllCategory();
    }
}
