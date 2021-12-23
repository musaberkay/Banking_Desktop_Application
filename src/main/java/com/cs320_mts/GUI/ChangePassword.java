package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import java.awt.*;

public class ChangePassword  extends JPanel {
    private User user;
    private JLabel oldPassword;
    private JLabel newPassword;
    private JPasswordField oldPasswordField;
    private JPasswordField newPasswordField;
    private JButton confirm;
    private JButton back;

    private final ChangePassword currentPanel;

    public ChangePassword(Dimension size){
        currentPanel = this;

        oldPassword 			= new JLabel("Old Password");
        newPassword 			= new JLabel("New Password");
        oldPasswordField 		= new JPasswordField();
        newPasswordField		= new JPasswordField();
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

        c1.gridy = 0;
        c2.gridy = 1;
        c3.gridy = 2;
        c4.gridy = 3;
        c5.gridy = 4;
        c6.gridy = 5;

        c2.ipady = 20;
        c2.ipadx = 180;
        c4.ipady = 20;
        c4.ipadx = 180;

        oldPassword.setFont(new Font("Arial",Font.BOLD,20));
        oldPasswordField.setFont(new Font("Arial",Font.BOLD,20));
        newPassword.setFont(new Font("Arial",Font.BOLD,20));
        newPasswordField.setFont(new Font("Arial",Font.BOLD,20));
        confirm.setFont(new Font("Arial", Font.BOLD ,20));
        back.setFont(new Font("Arial", Font.BOLD ,20));

        this.setSize(size);
        this.add(oldPassword,c1);
        this.add(oldPasswordField,c2);
        oldPasswordField.setHorizontalAlignment(JTextField.CENTER);
        this.add(newPassword,c3);
        this.add(newPasswordField,c4);
        newPasswordField.setHorizontalAlignment(JTextField.CENTER);
        this.add(confirm,c5);
        this.add(back,c6);

    }
    //DATABASE ACTION: PASSWORD NEEDS TO BE CHANGED !!!
    public void setConfirmButton(MainMenu backPanel){
        confirm.addActionListener(e -> {
            String oldPasswordText = oldPasswordField.getPassword().toString();
            String newPasswordText = newPasswordField.getPassword().toString();

            //DATABASE Actions need to be triggered here

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
