package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import java.awt.*;

public class Register extends JPanel {
    private User user;
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
        password        = new JLabel("Password (Must be 6 digit-number)");
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
        GridBagConstraints c9 = new GridBagConstraints();
        GridBagConstraints c10 = new GridBagConstraints();
        GridBagConstraints c11 = new GridBagConstraints();
        GridBagConstraints c12 = new GridBagConstraints();
        GridBagConstraints c13 = new GridBagConstraints();
        GridBagConstraints c14 = new GridBagConstraints();
        GridBagConstraints c15 = new GridBagConstraints();
        GridBagConstraints c16 = new GridBagConstraints();

        c1.gridy = 0;
        c2.gridy = 1;
        c3.gridy = 2;
        c4.gridy = 3;
        c5.gridy = 4;
        c6.gridy = 5;
        c7.gridy = 6;
        c8.gridy = 7;
        c9.gridy = 8;
        c10.gridy = 9;
        c11.gridy = 10;
        c12.gridy = 11;
        c13.gridy = 12;
        c14.gridy = 13;
        c15.gridy = 14;
        c16.gridy = 15;

        c2.ipady = 20;
        c2.ipadx = 180;
        c4.ipady = 20;
        c4.ipadx = 180;
        c6.ipady = 20;
        c6.ipadx = 180;
        c8.ipady = 20;
        c8.ipadx = 180;
        c10.ipady = 20;
        c10.ipadx = 180;
        c12.ipady = 20;
        c12.ipadx = 180;
        c14.ipady = 20;
        c14.ipadx = 180;

        name.setFont(new Font("Arial",Font.BOLD,20));
        nameText.setFont(new Font("Arial",Font.BOLD,20));
        surname.setFont(new Font("Arial",Font.BOLD,20));
        surnameText.setFont(new Font("Arial",Font.BOLD,20));
        password.setFont(new Font("Arial", Font.BOLD ,20));
        passwordText.setFont(new Font("Arial", Font.BOLD ,20));
        dateOfBirth.setFont(new Font("Arial",Font.BOLD,20));
        dateOfBirthText.setFont(new Font("Arial",Font.BOLD,20));
        identificationNumber.setFont(new Font("Arial",Font.BOLD,20));
        identificationNumberText.setFont(new Font("Arial",Font.BOLD,20));
        email.setFont(new Font("Arial",Font.BOLD,20));
        emailText.setFont(new Font("Arial",Font.BOLD,20));
        phoneNumber.setFont(new Font("Arial", Font.BOLD ,20));
        phoneNumberText.setFont(new Font("Arial", Font.BOLD ,20));
        register.setFont(new Font("Arial",Font.BOLD,20));
        back.setFont(new Font("Arial",Font.BOLD,20));

        this.setSize(size);
        this.add(name,c1);
        this.add(nameText,c2);
        nameText.setHorizontalAlignment(JTextField.CENTER);
        this.add(surname,c3);
        this.add(surnameText,c4);
        surnameText.setHorizontalAlignment(JTextField.CENTER);
        this.add(password,c5);
        this.add(passwordText,c6);
        passwordText.setHorizontalAlignment(JTextField.CENTER);
        this.add(dateOfBirth,c7);
        this.add(dateOfBirthText,c8);
        dateOfBirthText.setHorizontalAlignment(JTextField.CENTER);
        this.add(identificationNumber,c9);
        this.add(identificationNumberText,c10);
        identificationNumberText.setHorizontalAlignment(JTextField.CENTER);
        this.add(email,c11);
        this.add(emailText,c12);
        emailText.setHorizontalAlignment(JTextField.CENTER);
        this.add(phoneNumber,c13);
        this.add(phoneNumberText,c14);
        phoneNumberText.setHorizontalAlignment(JTextField.CENTER);
        this.add(register,c15);
        this.add(back,c16);
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
    public void setUserId(User user){
        user = user;
    }
}
