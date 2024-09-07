package org.example.coffee.controller;

import org.example.coffee.model.dto.ProductDTO;
import org.example.coffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProductLlist() throws SQLException {
        List<ProductDTO> products = productService.getProductList();
        return ResponseEntity.ok(products);
    }

}
