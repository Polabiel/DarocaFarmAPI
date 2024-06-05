package com.daroca.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class SalesOrderItemKey {
    @Column(name = "sales_order_id")
    private Integer salesOrderId;
    @Column(name = "product_id")
    private Integer productId;

    @Override
    public String toString() {
        return "SalesOrderItemKey{" +
                "salesOrderId=" + salesOrderId +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrderItemKey that)) return false;
        return Objects.equals(salesOrderId, that.salesOrderId) && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesOrderId, productId);
    }

    public SalesOrderItemKey(Integer salesOrderId, Integer productId) {
        this.productId = productId;
        this.salesOrderId = salesOrderId;
    }
}
