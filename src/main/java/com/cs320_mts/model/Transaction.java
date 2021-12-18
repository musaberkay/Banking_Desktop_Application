package com.cs320_mts.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="T_TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transactionId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date(System.currentTimeMillis());

    @Column(length = 10, nullable = false)
    private double amount;

    @Column(length = 11, nullable = false)
    private int recipientAccountId;

    public Transaction(){}

    public Transaction(double amount, int recipientAccountId) {
        this.amount = amount;
        this.recipientAccountId = recipientAccountId;
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

    public int getRecipientAccId() {
        return recipientAccountId;
    }

    public void setReceiverAccId(int receiverAccountId) {
        this.recipientAccountId = receiverAccountId;
    }
}
