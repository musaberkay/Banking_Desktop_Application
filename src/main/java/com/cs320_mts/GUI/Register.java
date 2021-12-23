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
            try{

                if(String.valueOf(passwordText.getPassword()).length() != 6)
                    throw new Exception("Password length must be 6");
                if(!String.valueOf(passwordText.getPassword()).matches("[0-9]+"))
                    throw new Exception("Password must be only digits");

            String userName         = nameText.getText();
            String userSurname      = surnameText.getText();
            String userPassword_    = String.valueOf(passwordText.getPassword());
            int userPassword        = Integer.parseInt(userPassword_);  // Use this
            String userDateOfBirth  = dateOfBirthText.getText(); //  like 2000-10-04


                if (userName.length() > 100 || userName.length() < 3)
                    throw new Exception("Name must be between 3 and 100 characters");

                for(int i = 0 ; i < userName.length(); i++){
                    if (!(userName.charAt(i) >= 'A' && userName.charAt(i) <= 'z'))
                        throw new Exception("Name only includes letters");
                }
                if (userSurname.length() > 100 || userSurname.length() < 2)
                    throw new Exception("Surname must be between 2 and 100 characters");

                for(int i = 0 ; i < userSurname.length(); i++){
                    if (!(userSurname.charAt(i) >= 'A' && userSurname.charAt(i) <= 'z'))
                        throw new Exception("Surname only includes letters");
                }
                if(userDateOfBirth.length() != 10) {
                    throw new Exception("It is not valid date of birth should be in form 2021-12-30");
                }
                if(userDateOfBirth.charAt(4) != '-' || userDateOfBirth.charAt(7) != '-'){
                    throw new Exception("It is not valid date of birth should be in form 2021-12-30");
                }
                for(int i = 0 ; i < 4 ; i++ ){
                    if(!(userDateOfBirth.charAt(i) >= '0' && userDateOfBirth.charAt(i) <= '9'))
                        throw new Exception("Year is not in valid form");
                }
                for(int i = 5 ; i < 7 ; i++){
                    if(!(userDateOfBirth.charAt(i) >= '0' && userDateOfBirth.charAt(i) <= '9'))
                        throw new Exception("Month is not in valid form");
                }
                for(int i = 8 ; i < 10 ; i++){
                    if(!(userDateOfBirth.charAt(i) >= '0' && userDateOfBirth.charAt(i) <= '9'))
                        throw new Exception("Day is not in valid form");
                }

            int year    = Integer.parseInt(userDateOfBirth.substring(0,4));
            int month   = Integer.parseInt(userDateOfBirth.substring(5,7));
            int day     = Integer.parseInt(userDateOfBirth.substring(8,10));

                if(year > 2005 || year < 1900)
                    throw new Exception("Not valid year");
                if(month > 12 || 1 > month)
                    throw new Exception("Not valid month");
                if(day > 31 || 1 > day)
                    throw new Exception("Not valid day");

            // NEEDS TO BE CHECKED ON DATABASE, THEY ARE UNIQUE
            String userIdentificationNumber     = identificationNumberText.getText();
            String userEmail                    = emailText.getText();
            String userPhoneNumber              = phoneNumberText.getText();

                if(userIdentificationNumber.length() != 11)
                    throw new Exception("Identification number must be 11 digit number");
                for(int i = 0 ; i < userIdentificationNumber.length(); i++){
                    if (!(userIdentificationNumber.charAt(i) >= '0' && userIdentificationNumber.charAt(i) <= '9'))
                        throw new Exception("Identification number only includes digits");
                }
                if(!userEmail.contains("@"))
                    throw new Exception("Email needs '@' character");

                if(userPhoneNumber.length() != 10)
                    throw new Exception("Phone number must be 10 digits ");

                for(int i = 0 ; i < userPhoneNumber.length() ; i++){
                    if(!(userPhoneNumber.charAt(i) >= '0' && userPhoneNumber.charAt(i) <= '9'))
                        throw new Exception("Phone number only includes digits");
            }


            // DATABASE ACTION HERE
            // Create new User Object named "user"

            // ************ DON'T TOUCH ************
            mainMenu.setUser(user);
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
    public void setUser(User user){
        user = user;
    }
}
