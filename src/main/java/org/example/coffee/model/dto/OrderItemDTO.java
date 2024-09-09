package org.example.coffee.model.dto;

import java.time.LocalDateTime;

public class OrderItemDTO {
    private int seq;
    private String orderId;
    private String productId;
    private String category;
    private int price;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderItemDTO() {}

    public OrderItemDTO(String orderId, String productId, String category, int price, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
