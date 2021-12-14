package com.cs320_mts.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_ACCOUNT")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int AccountId;
    
    @Column(length = 25, nullable = false)
    private double balance;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ACCOUNT_ID")
    private List<Transaction> transactions = new ArrayList<>();

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        AccountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
