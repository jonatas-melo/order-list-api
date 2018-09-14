package com.jonatasmelo.orderlistapi.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jonatasmelo.orderlistapi.entities.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderResponse {
    private Long number;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime requiredDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime shippedDate;
    private List<OrderDetailResponse> detailList;

    public OrderResponse() {
    }

    public OrderResponse(Long number, LocalDateTime date, LocalDateTime requiredDate, LocalDateTime shippedDate) {
        this.number = number;
        this.date = date;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
    }

    public static OrderResponse parse(Order order) {
        OrderResponse obj = new OrderResponse(order.getNumber(), order.getDate(), order.getRequiredDate(), order.getShippedDate());
        obj.setDetailList(new ArrayList<>());
        return obj;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDateTime requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDateTime getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }

    public List<OrderDetailResponse> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetailResponse> detailList) {
        this.detailList = detailList;
    }
}
