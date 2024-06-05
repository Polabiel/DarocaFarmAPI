package com.daroca.models;

import jakarta.persistence.*;
import org.springframework.objenesis.SpringObjenesis;

import java.util.Objects;

@Entity
@Table
public class SalesOrderItem {

    @EmbeddedId
    private SalesOrderItemKey salesOrderItemKey;
    @ManyToOne // cardinalidade da relação
    @MapsId("salesOrderId")
    @JoinColumn(name = "sales_order_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_SalesOrder"))
    private SalesOrder salesOrder;
    @ManyToOne // cardinalidade da relação
    @MapsId("productId")
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "FK_SalesOrderItem_Product"))
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrderItem that)) return false;
        return Objects.equals(salesOrderItemKey, that.salesOrderItemKey) && Objects.equals(salesOrder, that.salesOrder) && Objects.equals(product, that.product) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesOrderItemKey, salesOrder, product, quantity);
    }

    @Column(nullable = false)
    private Integer quantity;

}
