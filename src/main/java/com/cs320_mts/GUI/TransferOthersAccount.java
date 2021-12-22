package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class TransferOthersAccount extends JPanel {
    private int userId;
    private final JLabel accountID;
    private final JLabel amount;
    private final JLabel name;
    private final JTextField accountIDText;
    private final JTextField amountText;
    private final JTextField nameText;
    private final JButton confirm;
    private final JButton back;
    private final TransferOthersAccount currentPanel;


    public TransferOthersAccount(Dimension size){
        currentPanel = this;

        accountID 		= new JLabel("Account ID");
        amount 			= new JLabel("Amount");
        name 			= new JLabel("User Name");
        accountIDText	= new JTextField();
        amountText		= new JTextField();
        nameText 		= new JTextField();
        confirm			= new JButton("Confirm");
        back			= new JButton("Back");

        //LAYOUT

        this.setSize(size);
        this.add(accountID);
        this.add(amount);
        this.add(name);
        this.add(accountIDText);
        this.add(amountText);
        this.add(nameText);
        this.add(confirm);
        this.add(back);
    }

    //MONEY TRANSFER NEEDS TO BE DONE !!!
    public void setConfirmButton(MainMenu backPanel){
        confirm.addActionListener(e -> {

            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    // DO NOT TOUCH THIS METHOD
    public void setBackButton(MainMenu backPanel){
        back.addActionListener(e -> {
            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}

