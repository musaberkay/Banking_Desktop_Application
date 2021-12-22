package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class TransferOwnAccount extends JPanel {
    private int userId;
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

        this.setSize(size);
        this.add(accounts);
        this.add(amount);
        this.add(accountsList);
        this.add(amountText);
        this.add(confirm);
        this.add(back);
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
    public void setUserId(int id){
        userId = id;
    }

}
