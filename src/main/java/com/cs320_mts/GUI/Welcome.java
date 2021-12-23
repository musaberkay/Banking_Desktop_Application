package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class Welcome extends JPanel {
    private final JButton login;
    private final JButton register;
    private final Welcome currentPanel;
    public Welcome(Dimension size){
        currentPanel = this;
        login        = new JButton("Login");
        register     = new JButton("Register");

        // LAYOUT

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.weightx = 0.05;
        c.ipady = 40;
        c.ipadx = 150;
        login.setFont(new Font("Arial",Font.ITALIC,20));
        register.setFont(new Font("Arial",Font.ITALIC,20));
        this.setSize(size);
        this.add(login,c);
        this.add(register,c);


    }
    // ************ DON'T TOUCH ************
    public void setLoginButton(Login loginPanel){
        login.addActionListener(e -> {
            loginPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    // ************ DON'T TOUCH ************
    public void setRegisterButton(Register registerPanel){
        register.addActionListener(e -> {
            registerPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

}
