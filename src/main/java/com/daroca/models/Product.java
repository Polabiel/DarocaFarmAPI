package com.daroca.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ProductId;
    @Column(length = 50, nullable = false)
    private String name;
    @Column(nullable = false)
    private Double unitPrice;

    @OneToMany
    @JoinColumn(name = "product_category_id", foreignKey = @ForeignKey(name = "FK_ProductCategory"))
    private ProductCategory productCategory;

    public Product(Integer id, String name, String email, Double latitude, Double longitude) {
        this.ProductId = id;
        this.name = name;
        this.unitPrice = longitude;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getUnitPrice(), product.getUnitPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getName(), getUnitPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "ProductId=" + ProductId +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
