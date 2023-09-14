package com.bymyself.SteelFabricatedOrderManage.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private int id;

    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    private String state;
    private String city;
    private String landmark;
    private String pin;
    private String phone;
    private String mail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date bod;
    private String password;

    @Column(name = "walletbalance")
    private double walletBalance;

    @Column(name = "created_timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimesTamp;

    @OneToMany(mappedBy = "cId", fetch = FetchType.EAGER)
    @Fetch(value= FetchMode.SUBSELECT)
    private List<Order> orders;
    @OneToMany(mappedBy = "cId", fetch = FetchType.EAGER)
    @Fetch(value=FetchMode.SUBSELECT)
    private List<Review> reviews;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getBod() {
        return bod;
    }

    public void setBod(Date bod) {
        this.bod = bod;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Date getCreatedTimesTamp() {
        return createdTimesTamp;
    }

    public void setCreatedTimesTamp(Date createdTimesTamp) {
        this.createdTimesTamp = createdTimesTamp;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Customer(int id, String first_name, String last_name, String state, String city, String landmark, String pin,
                    String phone, String mail, Date bod, String password, double walletBalance) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.state = state;
        this.city = city;
        this.landmark = landmark;
        this.pin = pin;
        this.phone = phone;
        this.mail = mail;
        this.bod = bod;
        this.password = password;
        this.walletBalance = walletBalance;
        this.orders= new ArrayList<Order>();
        this.reviews= new ArrayList<Review>();
    }

    public Customer()
    {
        this.orders = new ArrayList<Order>();
        this.reviews=new ArrayList<Review>();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", landmark='" + landmark + '\'' +
                ", pin='" + pin + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", bod=" + bod +
                ", password='" + password + '\'' +
                ", walletBalance=" + walletBalance +
                ", createdTimesTamp=" + createdTimesTamp +
                ", orders=" + orders +
                ", reviews=" + reviews +
                '}';
    }
}
