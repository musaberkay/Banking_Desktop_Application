package com.cs320_mts.GUI;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Welcome extends JPanel {
	
    private JButton login;
    private JButton register;
    private Welcome currentPanel;
    
    public Welcome() {
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
