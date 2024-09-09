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
    public ResponseEntity<Void> addOrder(@RequestBody OrderDTO order) throws SQLException {
        orderService.addOrder(order);
        return ResponseEntity.ok().build();
    }

    /**
     * 주문을 취소하는 메서드
     * @param orderId 취소할 주문 아이디
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable String orderId) throws SQLException {
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }

    /**
     * 주문자 정보 수정하는 메서드
     * @param orderId 수정할 주문 아이디
     */
    @PutMapping("/info/{orderId}")
    public ResponseEntity<Void> getOrder(@PathVariable String orderId, @RequestBody OrderDTO orderDTO) throws SQLException {
        orderDTO.setOrderId(orderId);
        orderService.updateInfo(orderDTO);
        return ResponseEntity.ok().build();
    }

    /**
     * 이메일로 주문 조회하는 메서드
     * @param email 조회할 주문 이메일
     */
    @GetMapping("/{email}")
    public ResponseEntity<List<List<OrderItemDTO>>> getOrderByEmail(@PathVariable String email) throws SQLException {
        return ResponseEntity.ok(orderService.getItemsByEmailList(email));
    }

    /**
     * 주문 수량 수정하는 메서드
     * @param seq 수정할 주문 번호
     * @param orderItemDTO 수정할 주문 객체
     */
    @PutMapping("/item/{seq}")
    public ResponseEntity<Void> updateOrderItem(@PathVariable int seq, @RequestBody OrderItemDTO orderItemDTO) throws SQLException {
        int quantity = orderItemDTO.getQuantity();
        orderService.updateOrderItem(seq, quantity);
        return ResponseEntity.ok().build();
    }

    /**
     * 주문 상품 삭제하는 메서드
     * @param seq 삭제 주문 번호
     */
    @DeleteMapping("/item/{seq}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable int seq) throws SQLException {
        orderService.deleteOrderItem(seq);
        return ResponseEntity.ok().build();
    }

    /**
     * 주문 상품 추가하는 메서드
     * @param orderItemDTO 추가할 상품 메서드
     */
    @PostMapping("/item/{orderId}")
    public ResponseEntity<Void> addOrderItem(@PathVariable String orderId, @RequestBody OrderItemDTO orderItemDTO) throws SQLException {
        orderItemDTO.setOrderId(orderId);
        orderService.addOrderItem(orderItemDTO);
        return ResponseEntity.ok().build();
    }
}
