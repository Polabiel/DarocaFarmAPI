package com.daroca.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ProductId;
    @Column(length = 50, nullable = false)
    private String name;

    public ProductCategory(Integer id, String name) {
        this.ProductId = id;
        this.name = name;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductCategory that)) return false;
        return Objects.equals(getProductId(), that.getProductId()) && Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName());
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "ProductId=" + ProductId +
                ", name='" + name + '\'' +
                '}';
    }
}
