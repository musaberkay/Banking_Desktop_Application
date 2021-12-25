package com.cs320_mts.GUI;

import com.cs320_mts.model.User;
import com.cs320_mts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Register extends JPanel {
    private User user;
    private JLabel name;
    private JLabel surname;
    private JLabel password;
    private JLabel dateOfBirth;
    private JLabel identificationNumber;
    private JLabel email;
    private JLabel phoneNumber;
    private JTextField nameText;
    private JTextField surnameText;
    private JPasswordField passwordText;
    private JTextField dateOfBirthText;
    private JTextField identificationNumberText;
    private JTextField emailText;
    private JTextField phoneNumberText;
    private JButton register;
    private JButton back;
    private Register currentPanel;

    @Autowired
    UserService userService;

    public Register(){
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
        dateOfBirthText = new JTextField("30-12-2021");
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

        c15.insets = new Insets(20,0,20,0);

        name.setFont(new Font("Arial",Font.ITALIC,20));
        nameText.setFont(new Font("Arial",Font.ITALIC,20));
        surname.setFont(new Font("Arial",Font.ITALIC,20));
        surnameText.setFont(new Font("Arial",Font.ITALIC,20));
        password.setFont(new Font("Arial", Font.ITALIC ,20));
        passwordText.setFont(new Font("Arial", Font.ITALIC ,20));
        dateOfBirth.setFont(new Font("Arial",Font.ITALIC,20));
        dateOfBirthText.setFont(new Font("Arial",Font.ITALIC,20));
        identificationNumber.setFont(new Font("Arial",Font.ITALIC,20));
        identificationNumberText.setFont(new Font("Arial",Font.ITALIC,20));
        email.setFont(new Font("Arial",Font.ITALIC,20));
        emailText.setFont(new Font("Arial",Font.ITALIC,20));
        phoneNumber.setFont(new Font("Arial", Font.ITALIC ,20));
        phoneNumberText.setFont(new Font("Arial", Font.ITALIC ,20));
        register.setFont(new Font("Arial",Font.ITALIC,20));
        back.setFont(new Font("Arial",Font.ITALIC,20));

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
            try{

            String userName         = nameText.getText();
            String userSurname      = surnameText.getText();
            String userPassword_    = String.valueOf(passwordText.getPassword());
            int userPassword        = Integer.parseInt(userPassword_);  // Use this
            String userDateOfBirth  = dateOfBirthText.getText(); //  like 21-07-2000

                
            String userIdentificationNumber     = identificationNumberText.getText();
            String userEmail                    = emailText.getText();
            String userPhoneNumber              = phoneNumberText.getText();

            user = new User(userName,userSurname,userPassword,userDateOfBirth
                    ,userIdentificationNumber,userEmail,userPhoneNumber);

            // DATABASE ACTION HERE
                userService.save(user);
            //User inserted to DB

            // ************ DON'T TOUCH ************
            mainMenu.setUserId(user.getUserId());
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
            }catch (Exception es){
                JOptionPane.showMessageDialog(new JFrame(),es.getMessage() , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    // ************ DON'T TOUCH ************
    public void setBackButton(Welcome welcome){
        back.addActionListener(e -> {
            welcome.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
}