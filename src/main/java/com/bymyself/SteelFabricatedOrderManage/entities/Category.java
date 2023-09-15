package com.bymyself.SteelFabricatedOrderManage.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "cat_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String details;

    @Column(name = "created_timestamp", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTimeStamp;

    @OneToMany(mappedBy = "catId" , cascade = CascadeType.REMOVE)
    private List<Product> productList;

    public Category() {
        this.productList = new ArrayList<Product>();
    }

    public Category(int id, String name, String details, Date createdTimeStamp, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.createdTimeStamp = createdTimeStamp;
        this.productList = productList;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public Date getCreatedTimeStamp() {
        return createdTimeStamp;
    }
    public void setCreatedTimeStamp(Date createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }
    public List<Product> getProductList() {
        return productList;
    }
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", details=" + details + ", createdTimeStamp="
                + createdTimeStamp + ", productLsit=" + productList + "]";
    }
}
