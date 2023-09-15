package com.bymyself.SteelFabricatedOrderManage.dto;

public class ProductUpdateDto {
    private int qty;
    private double price;

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
