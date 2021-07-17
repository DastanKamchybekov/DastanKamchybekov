package com.telegramBot.telegramBot.Entity;

import javax.persistence.*;

@Entity
public class OrderProduct {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private ClientOrder order;
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Integer countProduct;

    public ClientOrder getOrder() {
        return order;
    }

    public void setOrder(ClientOrder order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCountProduct() {
        return countProduct;
    }

    public void setCountProduct(Integer countProduct) {
        this.countProduct = countProduct;
    }
}
