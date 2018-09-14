package com.jonatasmelo.orderlistapi.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
@IdClass(OrderDetailsId.class)
public class OrderDetails {
    @Id
    @Column(name = "ordernumber")
    private Long orderNumber;
    @Id
    @Column(name = "productcode")
    private String productCode;

    @Column(name = "quantityordered")
    private Integer quantityOrdered;
    @Column(name = "priceeach")
    private BigDecimal priceEach;
    @Column(name = "orderlinenumber")
    private Integer orderLineNumber;

    @JoinColumn(name = "productcode", insertable = false, updatable = false)
    @ManyToOne
    private Product product;

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
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

    public Integer getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(Integer orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(orderNumber, that.orderNumber) &&
                Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderNumber, productCode);
    }
}

