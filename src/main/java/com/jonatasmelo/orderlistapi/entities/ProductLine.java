package com.jonatasmelo.orderlistapi.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "productlines")
public class ProductLine {
    @Id
    @Column(name = "productline")
    private String productLine;
    @Column(name = "textdescription")
    private String textDescription;

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLine that = (ProductLine) o;
        return Objects.equals(productLine, that.productLine);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productLine);
    }
}
