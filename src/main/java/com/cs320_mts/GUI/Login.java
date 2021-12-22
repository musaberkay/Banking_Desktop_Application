package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class Login extends JPanel {
    private int userId;
    private final JLabel identificationNumber;
    private final JLabel password;
    private final JTextField identificationNumberText;
    private final JPasswordField passwordText;
    private final JButton login;
    private final JButton back;
    private final Login currentPanel;
    private final JLabel space;


    public Login(Dimension size){
        currentPanel = this;

        identificationNumber 		= new JLabel("Identification Number");
        password 					= new JLabel("Password");
        identificationNumberText 	= new JTextField();
        passwordText 				= new JPasswordField();
        login 						= new JButton("Login");
        back 						= new JButton("Back");
        space                       = new JLabel("");
        //LAYOUT
        this.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        GridBagConstraints c3 = new GridBagConstraints();
        GridBagConstraints c4 = new GridBagConstraints();
        GridBagConstraints c5 = new GridBagConstraints();
        GridBagConstraints c6 = new GridBagConstraints();
        c2.ipady = 20;
        c2.ipadx = 180;
        c4.ipady = 20;
        c4.ipadx = 90;
        c1.gridy = 0;
        c2.gridy = 1;
        c3.gridy = 2;
        c4.gridy = 3;
        c5.gridy = 5;
        c6.gridy = 6;
        c5.ipady = 20;
        c5.ipadx = 20;
        c6.ipady = 20;
        c6.ipadx = 20;

        identificationNumber.setFont(new Font("Arial",Font.BOLD,20));
        password.setFont(new Font("Arial",Font.BOLD,20));
        login.setFont(new Font("Arial",Font.BOLD,15));
        back.setFont(new Font("Arial",Font.BOLD,15));
        identificationNumberText.setFont(new Font("Arial", Font.BOLD ,18));
        passwordText.setFont(new Font("Arial", Font.BOLD ,28));

        this.setSize(size);
        this.add(identificationNumber,c1);
        this.add(identificationNumberText,c2);
        identificationNumberText.setHorizontalAlignment(JTextField.CENTER);
        this.add(password,c3);
        this.add(passwordText,c4);
        passwordText.setHorizontalAlignment(JTextField.CENTER);
        this.add(login,c5);
        this.add(back,c6);

    }

    //// ** DATA HAS RECEIVED. DATABASE ACTION NECESSARY **
    public void setLoginButton(MainMenu loginPanel){
        login.addActionListener(e -> {
            String identificationNumberInput = identificationNumberText.getText();

            String myPass=String.valueOf(passwordText.getPassword());
            int passwordInput = Integer.parseInt(myPass);

            //userId = GET User ID FROM DATABASE !!!
            loginPanel.setUserId(userId);
            loginPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    // DO NOT TOUCH THIS METHOD
    public void setBackButton(Welcome backPanel){
        back.addActionListener(e -> {
            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
}
