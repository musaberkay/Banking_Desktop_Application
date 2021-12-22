package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class ChangePassword  extends JPanel {
    private int userId;
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

        this.setSize(size);
        this.add(oldPassword);
        this.add(newPassword);
        this.add(oldPasswordField);
        this.add(newPasswordField);
        this.add(confirm);
        this.add(back);

    }
    //DATABASE ACTION: PASSWORD NEEDS TO BE CHANGED !!!
    public void setConfirmButton(MainMenu backPanel){
        confirm.addActionListener(e -> {
            String oldPasswordText = oldPasswordField.getPassword().toString();
            String newPasswordText = newPasswordField.getPassword().toString();

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

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
