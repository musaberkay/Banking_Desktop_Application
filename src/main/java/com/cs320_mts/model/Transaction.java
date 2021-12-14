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
    private int senderAccountId;
    @Column(length = 11, nullable = false)
    private int receiverAccountId;

    public Transaction(){}

    public Transaction(Date date, double amount, int senderAccountId, int receiverAccountId) {
        this.date = date;
        this.amount = amount;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
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

    public int getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(int senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public int getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(int receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }
}
