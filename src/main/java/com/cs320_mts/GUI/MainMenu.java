package com.cs320_mts.GUI;

import com.cs320_mts.model.Account;
import com.cs320_mts.service.AccountService;
import com.cs320_mts.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class MainMenu extends JPanel {
	
	@Autowired
	AccountService accountService;

    @Autowired
    UserService userService;
	
    private int userId;
    private JButton createAccount;
    private JButton checkBalance;
    private JButton transferOwnAccount;
    private JButton transferOthersAccount;
    private JButton viewTransactionHistory;
    private JButton changePassword;
    private JButton exit;
    private MainMenu currentPanel;
    
    public MainMenu() {
        currentPanel = this;

        createAccount 			= new JButton("Create Account");
        checkBalance			= new JButton("Check Balance");
        transferOwnAccount		= new JButton("Transfer Own Account");
        transferOthersAccount	= new JButton("Transfer Others Account");
        viewTransactionHistory  = new JButton("View Transaction History");
        changePassword			= new JButton("Change Password");
        exit					= new JButton("Exit");

        //LAYOUT
        this.setLayout(new GridLayout(7, 1));

        createAccount.setFont(new Font("Arial",Font.ITALIC,20));
        checkBalance.setFont(new Font("Arial",Font.ITALIC,20));
        transferOwnAccount.setFont(new Font("Arial",Font.ITALIC,20));
        transferOthersAccount.setFont(new Font("Arial",Font.ITALIC,20));
        viewTransactionHistory.setFont(new Font("Arial",Font.ITALIC,20));
        changePassword.setFont(new Font("Arial",Font.ITALIC,20));
        exit.setFont(new Font("Arial",Font.ITALIC,20));

        this.add(createAccount);
        this.add(checkBalance);
        this.add(transferOwnAccount);
        this.add(transferOthersAccount);
        this.add(viewTransactionHistory);
        this.add(changePassword);
        this.add(exit);
    }
    
    public void setCreateAccount(){
        createAccount.addActionListener(e -> {
        	//DATABASE ACTIONS HERE
        	try {
                if(userService.getById(userId).getAccounts().size()>=3) {
                	throw new Exception("You have 3 accounts, plase contact with Customer Services to create a new account.");
                }
                else {
                	int dialogResult = JOptionPane.showConfirmDialog(new JFrame(), "Are you sure you want to create an account?", "Question",
                			JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
	                	Account account = new Account();
	                	account.setUser(userService.getById(userId));
	                	account.setBalance(0);  // NOW DEFAULT, WILL BE DESIGNED
                        userService.getById(userId).getAccounts().add(account);
	                	accountService.save(account);
	                	JOptionPane.showMessageDialog(new JFrame(), "Account is created succesfully!", "Succes", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            } catch (Exception ex){
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setCheckBalance(CheckBalance nextPanel){
        checkBalance.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setCheckBalancePanel();
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setTransferOwnAccount(TransferOwnAccount nextPanel){
        transferOwnAccount.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setTransferOwnAccount();
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setTransferOthersAccount(TransferOthersAccount nextPanel){
        transferOthersAccount.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setTransferOthersAccount();  /////
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setViewTransactionHist(ViewTransactionHist nextPanel){
        viewTransactionHistory.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setViewTransactionHist();
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    //DO NOT TOUCH THIS METHOD
    public void setChangePassword(ChangePassword nextPanel){
        changePassword.addActionListener(e -> {
            nextPanel.setUserId(userId);
            nextPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    // DO NOT TOUCH THIS METHOD
    public void setExit(){
        exit.addActionListener(e -> {
            System.exit(0);
        });
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}