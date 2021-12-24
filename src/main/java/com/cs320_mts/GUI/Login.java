package com.cs320_mts.GUI;

import com.cs320_mts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
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

    @Autowired
    UserService userService;

    public Login(){
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
        c2.ipadx = 300;
        c4.ipady = 20;
        c4.ipadx = 180;
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

        c5.insets = new Insets(20,0,20,0);

        identificationNumber.setFont(new Font("Arial",Font.ITALIC,40));
        password.setFont(new Font("Arial",Font.ITALIC,40));
        login.setFont(new Font("Arial",Font.ITALIC,25));
        back.setFont(new Font("Arial",Font.ITALIC,25));
        identificationNumberText.setFont(new Font("Arial", Font.ITALIC ,35));
        passwordText.setFont(new Font("Arial", Font.ITALIC ,40));

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
    public void setLoginButton(MainMenu mainMenu){
        login.addActionListener(e -> {
            try{
            String identificationNumberInput = identificationNumberText.getText();
            String myPass=String.valueOf(passwordText.getPassword());
            System.out.println(myPass);
                if(identificationNumberInput.length() != 11)
                    throw new ArithmeticException("Identification number must be 11 digit number");
                if(myPass.length() != 6)
                    throw new ArithmeticException("Password must be 6 digit number");
            int passwordInput = Integer.parseInt(myPass);
            for(int i = 0 ; i < identificationNumberInput.length(); i++){
                if (!(identificationNumberInput.charAt(i) >= '0' && identificationNumberInput.charAt(i) <= '9'))
                    throw new NumberFormatException();
            }
            // user = GET User information FROM DATABASE !!!
            if(userService.getByIdentificationNumber(identificationNumberInput)!=null){
                if(userService.getByIdentificationNumber(identificationNumberInput).getPassword()==passwordInput){
                    userId = userService.getByIdentificationNumber(identificationNumberInput).getUserId();
                }
                else{
                    throw new Exception("Password is wrong.");
                }
            }
            else{
                throw new Exception("This user is not registered.");
            }
            // User is login succesfully if everything OK.

            mainMenu.setUserId(userId);
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
            }catch (ArithmeticException es){
                JOptionPane.showMessageDialog(new JFrame(),es.getMessage() , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException es){
                JOptionPane.showMessageDialog(new JFrame(),"Password and Identification number must be digit" , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }catch (Exception es){
                JOptionPane.showMessageDialog(new JFrame(),es.getMessage() , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
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
