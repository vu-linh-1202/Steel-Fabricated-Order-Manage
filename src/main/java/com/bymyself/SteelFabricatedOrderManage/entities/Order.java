package com.bymyself.SteelFabricatedOrderManage.entities;


import java.util.Date;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "o_id")
    @GeneratedValue
    private int oId;

    @OneToOne(orphanRemoval = false)
    @JoinColumn(name = "p_id")
    private Product product;

    @Column(name = "c_id")
    private int cId;

    @Column(name = "p_qty")
    private int qty;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "o_date")
    private Date oDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "d_date")
    private Date ddate;

    @Column(name = "status")
    private String status;

    @Column(name="staff_id")
    private int staffId;

    @Column(name = "paymentmode")
    private String paymentmode;

    public Order(int oId, Product product, int cId, int qty, Date oDate, Date ddate, String status, int staffId,
                 String paymentmode) {

        this.oId = oId;
        this.product = product;
        this.cId = cId;
        this.qty = qty;
        this.oDate = oDate;
        this.ddate = ddate;
        this.status = status;
        this.staffId = staffId;
        this.paymentmode = paymentmode;
    }
    public Order() {
    }

    public Order(int oId, int cId, int qty, Date oDate, Date ddate, String status, int staffId) {
        this.oId = oId;
        this.cId = cId;
        this.qty = qty;
        this.oDate = oDate;
        this.ddate = ddate;
        this.status = status;
        this.staffId=staffId;
    }
    public Order(int oId, Product product, int cId, int qty, Date oDate, Date ddate, String status) {
        this.oId = oId;
        this.product = product;
        this.cId = cId;
        this.qty = qty;
        this.oDate = oDate;
        this.ddate = ddate;
        this.status = status;
    }

    public String getPaymentmode() {
        return paymentmode;
    }

    public void setPaymentmode(String paymentmode) {
        this.paymentmode = paymentmode;
    }

    public int getstaffId() {
        return staffId;
    }

    public void setstaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getoDate() {
        return oDate;
    }

    public void setoDate(Date oDate) {
        this.oDate = oDate;
    }

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Order [oId=" + oId + ", product=" + product + ", cId=" + cId + ", qty=" + qty + ", oDate=" + oDate
                + ", ddate=" + ddate + ", status=" + status + ", staffId=" + staffId + "]";
    }
}

