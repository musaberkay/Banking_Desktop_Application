package com.cs320_mts.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="T_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(length = 10, nullable = false)
    private double amount;
    @Column(length = 11, nullable = false)
    private int receiverAccId;

    public Transaction(){}

    public Transaction(Date date, double amount, int receiverAccountId) {
        this.date = date;
        this.amount = amount;
        this.receiverAccId = receiverAccountId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getReceiverAccId() {
        return receiverAccId;
    }

    public void setReceiverAccId(int receiverAccountId) {
        this.receiverAccId = receiverAccountId;
    }
}
