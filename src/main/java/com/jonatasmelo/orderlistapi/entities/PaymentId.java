package com.jonatasmelo.orderlistapi.entities;

import java.io.Serializable;
import java.util.Objects;

public class PaymentId implements Serializable {
    private Long customerNumber;
    private String checkNumber;

    public PaymentId() {
    }

    public PaymentId(Long customerNumber, String checkNumber) {
        this.customerNumber = customerNumber;
        this.checkNumber = checkNumber;
    }

    public Long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentId paymentId = (PaymentId) o;
        return Objects.equals(customerNumber, paymentId.customerNumber) &&
                Objects.equals(checkNumber, paymentId.checkNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, checkNumber);
    }
}
