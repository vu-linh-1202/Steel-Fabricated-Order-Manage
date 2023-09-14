package com.bymyself.SteelFabricatedOrderManage.model;

public class Transaction {

    private int cid;
    private int amount;

    public Transaction(){}

    public Transaction(int cid, int amount)
    {
        this.cid=cid;
        this.amount=amount;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "cid=" + cid +
                ", amount=" + amount +
                '}';
    }
}
