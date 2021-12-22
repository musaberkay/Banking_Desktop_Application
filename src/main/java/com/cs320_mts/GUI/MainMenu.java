package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {
    private int userId;
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
        exit					= new JButton("Create Account");

        //LAYOUT

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


        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setCheckBalance(CheckBalance nextPanel){
        checkBalance.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setTransferOwnAccount(TransferOwnAccount nextPanel){
        transferOwnAccount.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setTransferOthersAccount(TransferOthersAccount nextPanel){
        transferOthersAccount.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setViewTransactionHist(ViewTransactionHist nextPanel){
        viewTransactionHistory.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setChangePassword(ChangePassword nextPanel){
        changePassword.addActionListener(e -> {
            nextPanel.setUserId(userId);
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

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
