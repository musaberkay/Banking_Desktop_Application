package com.cs320_mts.GUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Component
public class Application extends JFrame {
    @Autowired
    private TransferOthersAccount   transferOthers;
    @Autowired
    private Register                register;
    @Autowired
    private CheckBalance            checkBalance;
    @Autowired
    private MainMenu                mainMenu;
    @Autowired
    private ViewTransactionHist     viewTransaction;
    @Autowired
    private Welcome                 welcome;
    @Autowired
    private ChangePassword          changePassword;
    @Autowired
    private TransferOwnAccount      transferOwn;
    @Autowired
    private Login                   login;


    public void init(){

        this.setTitle("Money Transfer System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setResizable(false);
        this.setVisible(true);

        // create panels
        transferOthers.setSize(this.getSize());
        register.setSize(this.getSize());
        checkBalance.setSize(this.getSize());
        mainMenu.setSize(this.getSize());
        viewTransaction.setSize(this.getSize());
        welcome.setSize(this.getSize());
        changePassword.setSize(this.getSize());
        transferOwn.setSize(this.getSize());
        login.setSize(this.getSize());
        // set visibility
        transferOthers.setVisible(false);
        register.setVisible(false);
        checkBalance.setVisible(false);
        mainMenu.setVisible(false);
        viewTransaction.setVisible(false);
        welcome.setVisible(true); // open screen
        changePassword.setVisible(false);
        transferOwn.setVisible(false);
        login.setVisible(false);

        // add panels to frame
        this.add(transferOthers);
        this.add(register);
        this.add(checkBalance);
        this.add(mainMenu);
        this.add(viewTransaction);
        this.add(welcome);
        this.add(changePassword);
        this.add(transferOwn);
        this.add(login);

        // set transitions
        welcome.setLoginButton(login);
        welcome.setRegisterButton(register);
        register.setRegisterButton(mainMenu);
        register.setBackButton(welcome);
        login.setLoginButton(mainMenu);
        login.setBackButton(welcome);
        transferOthers.setConfirmButton(mainMenu);
        transferOthers.setBackButton(mainMenu);
        checkBalance.setBackButton(mainMenu);
        changePassword.setConfirmButton(mainMenu);
        changePassword.setBackButton(mainMenu);
        viewTransaction.setBackButton(mainMenu);
        transferOwn.setConfirmButton(mainMenu);
        transferOwn.setBackButton(mainMenu);
        mainMenu.setCreateAccount();
        mainMenu.setCheckBalance(checkBalance);
        mainMenu.setTransferOwnAccount(transferOwn);
        mainMenu.setTransferOthersAccount(transferOthers);
        mainMenu.setViewTransactionHist(viewTransaction);
        mainMenu.setChangePassword(changePassword);
        mainMenu.setExit();
        this.setVisible(true);


    }
}
