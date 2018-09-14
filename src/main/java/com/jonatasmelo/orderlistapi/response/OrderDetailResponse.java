package com.jonatasmelo.orderlistapi.response;

import com.jonatasmelo.orderlistapi.entities.OrderDetails;

import java.math.BigDecimal;

public class OrderDetailResponse {
    private String productCode;
    private String productName;
    private Integer quantityOrdered;
    private BigDecimal priceEach;

    public OrderDetailResponse() {
    }

    public OrderDetailResponse(String productCode, String productName, Integer quantityOrdered, BigDecimal priceEach) {
        this.productCode = productCode;
        this.productName = productName;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
    }

    public static OrderDetailResponse parse(OrderDetails orderDetails) {
        OrderDetailResponse obj = new OrderDetailResponse();
        obj.setProductCode(orderDetails.getProduct().getProductCode());
        obj.setProductName(orderDetails.getProduct().getProductName());
        obj.setQuantityOrdered(orderDetails.getQuantityOrdered());
        obj.setPriceEach(orderDetails.getPriceEach());

        return obj;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(Integer quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public BigDecimal getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(BigDecimal priceEach) {
        this.priceEach = priceEach;
    }
}
