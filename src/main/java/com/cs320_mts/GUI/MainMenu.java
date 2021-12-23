package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private User user;
    private final JButton createAccount;
    private final JButton checkBalance;
    private final JButton transferOwnAccount;
    private final JButton transferOthersAccount;
    private final JButton viewTransactionHistory;
    private final JButton changePassword;
    private final JButton exit;

    private final MainMenu currentPanel;

    public MainMenu(Dimension size) {
        currentPanel = this;

        createAccount 			= new JButton("Create Account");
        checkBalance			= new JButton("Check Balance");
        transferOwnAccount		= new JButton("Transfer Own Account");
        transferOthersAccount	= new JButton("Transfer Others Account");
        viewTransactionHistory  = new JButton("View Transaction History");
        changePassword			= new JButton("Change Password");
        exit					= new JButton("Exit");

        //LAYOUT
        this.setSize(size);
        this.setLayout(new GridLayout(7, 1));

        this.add(createAccount);
        this.add(checkBalance);
        this.add(transferOwnAccount);
        this.add(transferOthersAccount);
        this.add(viewTransactionHistory);
        this.add(changePassword);
        this.add(exit);
    }
    //  ************ DATABASE ACTION NECESSARY ************
    //new account must be added to DB
    public void setCreateAccount(){
        createAccount.addActionListener(e -> {
        //DATABASE ACTIONS HERE

        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setCheckBalance(CheckBalance nextPanel){
        checkBalance.addActionListener(e -> {
            nextPanel.setUser(user);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setTransferOwnAccount(TransferOwnAccount nextPanel){
        transferOwnAccount.addActionListener(e -> {
            nextPanel.setUser(user);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setTransferOthersAccount(TransferOthersAccount nextPanel){
        transferOthersAccount.addActionListener(e -> {
            nextPanel.setUser(user);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setViewTransactionHist(ViewTransactionHist nextPanel){
        viewTransactionHistory.addActionListener(e -> {
            nextPanel.setUser(user);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setChangePassword(ChangePassword nextPanel){
        changePassword.addActionListener(e -> {
            nextPanel.setUser(user);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    // DO NOT TOUCH THIS METHOD
    public void setExit(){
        exit.addActionListener(e -> {
            System.exit(0);
        });
    }

    public void setUser(User user) {
        this.user = user;
    }

}
