package com.bymyself.SteelFabricatedOrderManage.entities;

import javax.persistence.*;

@Entity
@Table(name = "customised_product")
public class CustomisedProduct {

    @Id
    @Column(name = "pid")
    private int id;
    private double price;
    private double budget;
    private String thumbnail;

    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_id")
    private Customer cust;

    public CustomisedProduct(int id, double price, double budget, String thumbnail, String description) {
        super();
        this.id = id;
        this.price = price;
        this.budget = budget;
        this.thumbnail = thumbnail;
        this.description = description;
    }

    public CustomisedProduct()
    {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }


    @Override
    public String toString() {
        return "CustomisedProduct [id=" + id + ", price=" + price + ", budget=" + budget + ", thumbnail=" + thumbnail
                + ", description=" + description + "]";
    }

}
