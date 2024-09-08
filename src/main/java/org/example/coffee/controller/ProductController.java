package org.example.coffee.controller;

import org.example.coffee.model.dto.ProductDTO;
import org.example.coffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * 상품 Controller 클래스
 */

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 모든 상품을 조회하는 메서드
     * @return 등록된 상품 객체 리스트
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProductDTO>> getProductLlist() throws SQLException {
        List<ProductDTO> products = productService.getProductList();
        return ResponseEntity.ok(products);
    }

    /**
     * 모든 카테고리를 조회하는 메서드
     * @return 등록된 카테고리명 리스트
     */
    @GetMapping("/category")
    public ResponseEntity<List<String>> getCategoryList() throws SQLException {
        List<String> categories = productService.getCategoryList();
        return ResponseEntity.ok(categories);
    }

    /**
     * 카테고리별 상품을 조회하는 메서드
     * @param category 조회할 카테고리
     * @return 카테고리에 해당하는 상품 객체 리스트
     */
    @GetMapping("category/{cat}")
    public ResponseEntity<List<ProductDTO>> getProductByCategoryList(@PathVariable("cat") String category) throws SQLException {
        List<ProductDTO> products = productService.getProductByCategoryList(category);
        return ResponseEntity.ok(products);
    }
}
