package com.cs320_mts.GUI;

import javax.swing.*;
import java.awt.*;

public class Register extends JPanel {
    private int userId;
    private final JLabel name;
    private final JLabel surname;
    private final JLabel password;
    private final JLabel dateOfBirth;
    private final JLabel identificationNumber;
    private final JLabel email;
    private final JLabel phoneNumber;
    private final JTextField nameText;
    private final JTextField surnameText;
    private final JPasswordField passwordText;
    private final JTextField dateOfBirthText;
    private final JTextField identificationNumberText;
    private final JTextField emailText;
    private final JTextField phoneNumberText;
    private final JButton register;
    private final JButton back;
    private final Register currentPanel;
    public Register(Dimension size){
        currentPanel    = this;
        name            = new JLabel("Name");
        surname         = new JLabel("Surname");
        password        = new JLabel("Password");
        dateOfBirth     = new JLabel("Date of Birth");
        identificationNumber = new JLabel("Identification Number");
        email           = new JLabel("Email");
        phoneNumber     = new JLabel("Phone Number");
        nameText        = new JTextField();
        surnameText     = new JTextField();
        passwordText    = new JPasswordField();
        dateOfBirthText = new JTextField("2021-12-30");
        identificationNumberText = new JTextField();
        emailText       = new JTextField();
        phoneNumberText = new JTextField();
        register        = new JButton("Register");
        back            = new JButton("Back");

        this.setSize(size);
        this.add(name);
        this.add(surname);
        this.add(password);
        this.add(dateOfBirth);
        this.add(identificationNumber);
        this.add(email);
        this.add(phoneNumber);
        this.add(nameText);
        this.add(surnameText);
        this.add(passwordText);
        this.add(dateOfBirthText);
        this.add(identificationNumberText);
        this.add(emailText);
        this.add(phoneNumberText);
        this.add(register);
        this.add(back);
    }
    // ************ DATA HAS RECEIVED. DATABASE ACTION NECESSARY ************
    public void setRegisterButton(MainMenu mainMenu){
        register.addActionListener(e -> {
            String userName         = nameText.getText();
            String userSurname      = surnameText.getText();
            int userPassword        = Integer.parseInt(passwordText.getPassword().toString());
            String userDateOfBirth  = dateOfBirthText.getText(); //  like 2000-10-04
            int year    = Integer.parseInt(userDateOfBirth.substring(0,4));
            int month   = Integer.parseInt(userDateOfBirth.substring(5,7));
            int day     = Integer.parseInt(userDateOfBirth.substring(8,10));
            String userIdentificationNumber     = identificationNumberText.getText();
            String userEmail                    = emailText.getText();
            String userPhoneNumber              = phoneNumberText.getText();
            // DATABASE ACTION HERE
            // userId = GET USER ID FROM DATABASE
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);

        });
    }
    // ************ DON'T TOUCH ************
    public void setBackButton(Welcome welcome){
        back.addActionListener(e -> {
            welcome.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    public void setUserId(int id){
        userId = id;
    }
}
