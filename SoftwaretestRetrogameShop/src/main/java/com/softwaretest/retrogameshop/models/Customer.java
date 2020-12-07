package com.softwaretest.retrogameshop.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    @ManyToMany
    private List<Game> purchases;

    public Customer(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Game> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Game> purchases) {
        this.purchases = purchases;
    }
}
