package org.example.coffee.controller;

import org.example.coffee.model.dto.ProductDTO;
import org.example.coffee.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    /**
     * 상품을 등록하는 메서드
     * @param product 등록할 상품 객체
     */
    @PostMapping("/add")
    public ResponseEntity<Void> addProduct(@RequestBody ProductDTO product) throws SQLException {
        productService.addProduct(product);
        return ResponseEntity.ok().build();
    }

    /**
     * 상품을 수정하는 메서드
     * @param productId 수정할 상품 아이디
     * @param product 수정할 상품 객체
     */
    @PutMapping("/{productId}")
    public ResponseEntity<Void> updateProduct(@PathVariable("productId") String productId, @RequestBody ProductDTO product) throws SQLException {
        product.setProductId(productId);
        productService.updateProduct(product);
        return ResponseEntity.ok().build();
    }

    /**
     * 상품을 삭제하는 메서드
     * @param productId 삭제할 상품 아이디
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") String productId) throws SQLException {
        productService.deleteProduct(productId);
        return ResponseEntity.ok().build();
    }
}
