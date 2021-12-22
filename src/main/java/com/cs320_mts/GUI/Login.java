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

    public Login(Dimension size){
        currentPanel = this;

        identificationNumber 		= new JLabel("IdentificationNumber");
        password 					= new JLabel("Password");
        identificationNumberText 	= new JTextField();
        passwordText 				= new JPasswordField();
        login 						= new JButton("Login");
        back 						= new JButton("Back");

        //LAYOUT

        this.setSize(size);
        this.add(identificationNumber);
        this.add(password);
        this.add(identificationNumberText);
        this.add(passwordText);
        this.add(login);
        this.add(back);

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
