package com.cs320_mts.GUI;

import com.cs320_mts.model.User;
import com.cs320_mts.service.UserService;

import javax.swing.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.awt.*;

public class ChangePassword  extends JPanel {
	
	@Autowired
	UserService userService;
	
    private User user;
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
        this.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        GridBagConstraints c3 = new GridBagConstraints();
        GridBagConstraints c4 = new GridBagConstraints();
        GridBagConstraints c5 = new GridBagConstraints();
        GridBagConstraints c6 = new GridBagConstraints();

        c1.gridy = 0;
        c2.gridy = 1;
        c3.gridy = 2;
        c4.gridy = 3;
        c5.gridy = 4;
        c6.gridy = 5;

        c2.ipady = 20;
        c2.ipadx = 180;
        c4.ipady = 20;
        c4.ipadx = 180;

        c3.insets = new Insets(20,0,0,0);
        c5.insets = new Insets(20,0,20,0);


        oldPassword.setFont(new Font("Arial",Font.ITALIC,40));
        oldPasswordField.setFont(new Font("Arial",Font.ITALIC,40));
        newPassword.setFont(new Font("Arial",Font.ITALIC,40));
        newPasswordField.setFont(new Font("Arial",Font.ITALIC,40));
        confirm.setFont(new Font("Arial", Font.ITALIC ,40));
        back.setFont(new Font("Arial", Font.ITALIC ,40));

        this.setSize(size);
        this.add(oldPassword,c1);
        this.add(oldPasswordField,c2);
        oldPasswordField.setHorizontalAlignment(JTextField.CENTER);
        this.add(newPassword,c3);
        this.add(newPasswordField,c4);
        newPasswordField.setHorizontalAlignment(JTextField.CENTER);
        this.add(confirm,c5);
        this.add(back,c6);

    }
    //DATABASE ACTION: PASSWORD NEEDS TO BE CHANGED !!!
    public void setConfirmButton(MainMenu backPanel){


        confirm.addActionListener(e -> {
                    try{
                        String oldPasswordText = String.valueOf(oldPasswordField.getPassword());
                        String newPasswordText = String.valueOf(newPasswordField.getPassword());

                        if(oldPasswordText.length() != 6)
                            throw new ArithmeticException("Old Password must be 6 digit number");
                        int passwordInputOld = Integer.parseInt(oldPasswordText);
                        if(newPasswordText.length() != 6)
                            throw new ArithmeticException("New Password must be 6 digit number");
                        int passwordInputNew = Integer.parseInt(newPasswordText);


                        //DATABASE Actions need to be triggered here
                        int oldPassword = Integer.parseInt(oldPasswordText);
                        int newPassword = Integer.parseInt(newPasswordText);
                        
                        userService.changePassword(user.getUserId(), oldPassword, newPassword);
                        

                        backPanel.setVisible(true);
                        currentPanel.setVisible(false);
                    }catch (NumberFormatException es){
                        JOptionPane.showMessageDialog(new JFrame(),"New password number must be digit" , "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }catch (Exception es){
                        JOptionPane.showMessageDialog(new JFrame(),es.getMessage() , "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }

                }
        );
    }

    // DO NOT TOUCH THIS METHOD
    public void setBackButton(MainMenu backPanel){
        back.addActionListener(e -> {
            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    public void setUser(User user) {
        this.user = user;
    }

}
