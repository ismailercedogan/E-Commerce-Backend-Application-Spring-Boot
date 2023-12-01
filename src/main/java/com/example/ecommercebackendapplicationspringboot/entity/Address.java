package com.example.ecommercebackendapplicationspringboot.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String city;

    private String state;

    private String Zip;

    @OneToMany(mappedBy = "address")
    private List<OrderEntity> orderEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public List<OrderEntity> getOrders() {
        return orderEntities;
    }

    public void setOrders(List<OrderEntity> orderEntities) {
        this.orderEntities = orderEntities;
    }
}


