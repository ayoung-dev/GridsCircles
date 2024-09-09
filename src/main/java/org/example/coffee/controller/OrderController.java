package org.example.coffee.controller;

import org.example.coffee.model.dto.OrderDTO;
import org.example.coffee.model.dto.OrderItemDTO;
import org.example.coffee.model.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

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

    /**
     * 주문자 정보 수정하는 메서드
     * @param orderId 수정할 주문 아이디
     */
    @PutMapping("/info/{orderId}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable String orderId, @RequestBody OrderDTO orderDTO) throws SQLException {
        orderDTO.setOrderId(orderId);
        orderService.updateInfo(orderDTO);
        return ResponseEntity.ok(orderDTO);
    }

    /**
     * 이메일로 주문 조회하는 메서드
     * @param email 조회할 주문 이메일
     */
    @GetMapping("/{email}")
    public ResponseEntity<List<List<OrderItemDTO>>> getOrderByEmail(@PathVariable String email) throws SQLException {
        return ResponseEntity.ok(orderService.getItemsByEmailList(email));
    }
}
