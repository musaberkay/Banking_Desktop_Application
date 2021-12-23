package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import java.awt.*;

public class TransferOthersAccount extends JPanel {
    private User user;
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
        this.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        GridBagConstraints c3 = new GridBagConstraints();
        GridBagConstraints c4 = new GridBagConstraints();
        GridBagConstraints c5 = new GridBagConstraints();
        GridBagConstraints c6 = new GridBagConstraints();
        GridBagConstraints c7 = new GridBagConstraints();
        GridBagConstraints c8 = new GridBagConstraints();

        c1.gridy = 0;
        c2.gridy = 1;
        c3.gridy = 2;
        c4.gridy = 3;
        c5.gridy = 4;
        c6.gridy = 5;
        c7.gridy = 6;
        c8.gridy = 7;

        c2.ipady = 20;
        c2.ipadx = 180;
        c4.ipady = 20;
        c4.ipadx = 180;
        c6.ipady = 20;
        c6.ipadx = 180;

        accountID.setFont(new Font("Arial",Font.BOLD,20));
        accountIDText.setFont(new Font("Arial",Font.BOLD,20));
        amount.setFont(new Font("Arial",Font.BOLD,20));
        amountText.setFont(new Font("Arial",Font.BOLD,20));
        name.setFont(new Font("Arial", Font.BOLD ,20));
        nameText.setFont(new Font("Arial", Font.BOLD ,20));
        confirm.setFont(new Font("Arial",Font.BOLD,20));
        back.setFont(new Font("Arial",Font.BOLD,20));

        this.setSize(size);
        this.add(accountID,c1);
        this.add(accountIDText,c2);
        this.add(amount,c3);
        this.add(amountText,c4);
        this.add(name,c5);
        this.add(nameText,c6);
        this.add(confirm,c7);
        this.add(back,c8);
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

    public void setUser(User user) {
        this.user = user;
    }
}

