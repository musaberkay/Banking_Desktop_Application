package com.cs320_mts.GUI;

import ch.qos.logback.core.joran.spi.ActionException;
import com.cs320_mts.model.User;

import javax.swing.*;
import java.awt.*;

public class TransferOwnAccount extends JPanel {
    private User user;
    private final JLabel accountSender;
    private final JLabel accountReceiver;
    private final JLabel amount;
    private final JList accountsList1;
    private final JList accountsList2;
    private final JTextField amountText;
    private final JButton confirm;
    private final JButton back;
    private final TransferOwnAccount currentPanel;
    public TransferOwnAccount(Dimension size){
        currentPanel            = this;
        accountSender           = new JLabel("Choose Sender Account");
        accountReceiver         = new JLabel("Choose Receiver Account");
        amount                  = new JLabel("Amount");

        DefaultListModel listModel;
        listModel = new DefaultListModel();


        // ************ MODEL ACTION NECESSARY ************

        listModel.addElement("3123125555555"); // Example adding to list
        listModel.addElement("32322");
        listModel.addElement("323232");
        accountsList1   = new JList(listModel);
        accountsList2   = new JList(listModel);
        // ADD ACCOUNTS WITH USING USER OBJECT
        // MODEL ACTION HERE
        // **********************************************************************


        // ************ DON'T TOUCH ************
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
        GridBagConstraints c7 = new GridBagConstraints();
        GridBagConstraints c8 = new GridBagConstraints();

        c1.gridy = 0;
        c2.gridy = 1;
        c7.gridy = 2;
        c8.gridy = 3;
        c3.gridy = 4;
        c4.gridy = 5;
        c5.gridy = 6;
        c6.gridy = 7;

        c4.ipady = 20;
        c4.ipadx = 220;

        c7.insets = new Insets(20,0,0,0);
        c3.insets = new Insets(20,0,0,0);
        c5.insets = new Insets(20,0,20,0);

        amount.setFont(new Font("Arial",Font.ITALIC,40));
        amountText.setFont(new Font("Arial",Font.ITALIC,30));
        accountSender.setFont(new Font("Arial", Font.ITALIC ,40));
        accountsList1.setFont(new Font("Arial", Font.ITALIC ,30));
        accountReceiver.setFont(new Font("Arial", Font.ITALIC ,40));
        accountsList2.setFont(new Font("Arial", Font.ITALIC ,30));
        confirm.setFont(new Font("Arial",Font.ITALIC,30));
        back.setFont(new Font("Arial",Font.ITALIC,30));


        this.setSize(size);
        this.add(accountSender,c1);
        this.add(accountsList1,c2);
        this.add(accountReceiver,c7);
        this.add(accountsList2,c8);
        this.add(amount,c3);
        this.add(amountText,c4);
        amountText.setHorizontalAlignment(JTextField.CENTER);
        this.add(confirm,c5);
        this.add(back,c6);
    }
    // ************ DATA HAS RECEIVED. DATABASE ACTION NECESSARY ************
    public void setConfirmButton(MainMenu mainMenu){
        confirm.addActionListener(e -> {
            try {
                    if(accountsList1.isSelectionEmpty()) {
                        throw new Exception("Please choose sender account!");
                    }
                    if(accountsList2.isSelectionEmpty()) {
                        throw new Exception("Please choose receiver account!");
                    }


                int selectedSenderAccountId = Integer.parseInt(String.valueOf(accountsList1.getSelectedValue()));
                int selectedReceiverAccountId = Integer.parseInt(String.valueOf(accountsList2.getSelectedValue()));
                double amount = Double.parseDouble(amountText.getText());


                // DATABASE ACTION HERE
                // Check necessary constraint using User class object (user: User)
                // Update Both database and User object if it is valid transfer


                // ************ DON'T TOUCH ************
                mainMenu.setUser(user);
                mainMenu.setVisible(true);
                currentPanel.setVisible(false);
            }catch (NumberFormatException es1){
                JOptionPane.showMessageDialog(new JFrame(), "Amount must be valid! ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception es2){
                JOptionPane.showMessageDialog(new JFrame(),es2.getMessage()  , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

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
