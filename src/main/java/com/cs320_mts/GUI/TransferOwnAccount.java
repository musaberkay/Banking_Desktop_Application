package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import java.awt.*;

public class TransferOwnAccount extends JPanel {
    private User user;
    private final JLabel accounts;
    private final JLabel amount;
    private final JList accountsList;
    private final JTextField amountText;
    private final JButton confirm;
    private final JButton back;
    private final TransferOwnAccount currentPanel;
    public TransferOwnAccount(Dimension size){
        currentPanel    = this;
        accounts        = new JLabel("Accounts");
        amount          = new JLabel("Amount");

        // ************ DATABASE ACTION NECESSARY ************
        accountsList   = new JList(); // Add accounts to List, add id of account for each
        // DATABASE ACTION HERE
        // **********************************************************************

        amountText      = new JTextField();
        confirm         = new JButton("Confirm");
        back            = new JButton("Back");

        //LAYOUT
        this.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        GridBagConstraints c3 = new GridBagConstraints();
        GridBagConstraints c4 = new GridBagConstraints();
        GridBagConstraints c5 = new GridBagConstraints();
        GridBagConstraints c6 = new GridBagConstraints();

        c1.gridy = 0;
        c2.gridy = 1;
        c3.gridy = 2;
        c4.gridy = 3;
        c5.gridy = 4;
        c6.gridy = 5;

        c4.ipady = 20;
        c4.ipadx = 180;

        amount.setFont(new Font("Arial",Font.BOLD,20));
        amountText.setFont(new Font("Arial",Font.BOLD,20));
        accounts.setFont(new Font("Arial", Font.BOLD ,20));
        accountsList.setFont(new Font("Arial", Font.BOLD ,20));
        confirm.setFont(new Font("Arial",Font.BOLD,20));
        back.setFont(new Font("Arial",Font.BOLD,20));


        this.setSize(size);
        this.add(accounts,c1);
        this.add(accountsList,c2);
        this.add(amount,c3);
        this.add(amountText,c4);
        amountText.setHorizontalAlignment(JTextField.CENTER);
        this.add(confirm,c5);
        this.add(back,c6);
    }
    // ************ DATA HAS RECEIVED. DATABASE ACTION NECESSARY ************
    public void setConfirmButton(MainMenu mainMenu){
        confirm.addActionListener(e -> {
            int selectedAccountId = Integer.parseInt(accountsList.getSelectedValue().toString());
            double amount = Double.parseDouble(amountText.getText());
            // DATABASE ACTION HERE

            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    // ************ DON'T TOUCH ************
    public void setBackButton(MainMenu mainMenu){
        back.addActionListener(e -> {
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    public void setUser(User user){
        user = user;
    }

}
