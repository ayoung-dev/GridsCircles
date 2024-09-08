package org.example.coffee.controller;

import org.example.coffee.model.dto.OrderDTO;
import org.example.coffee.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

/**
 * 주문 Controller 클래스
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 주문을 추가하는 메서드
     * @param order 추가할 주문 객체
     */
    @PostMapping("/add")
    public ResponseEntity<OrderDTO> addOrder(@RequestBody OrderDTO order) throws SQLException {
        orderService.addOrder(order);
        return ResponseEntity.ok(order);
    }

    /**
     * 주문을 취소하는 메서드
     * @param orderId 취소할 주문 아이디
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable String orderId) throws SQLException {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok(orderId + " has been deleted");
    }
}
