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


        this.setSize(size);
        this.add(login);
        this.add(register);


    }
    public void setLoginButton(Login loginPanel){
        login.addActionListener(e -> {
            loginPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    public void setRegisterButton(Register registerPanel){
        register.addActionListener(e -> {
            registerPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

}
