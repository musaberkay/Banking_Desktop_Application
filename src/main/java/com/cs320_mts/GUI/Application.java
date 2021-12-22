package com.cs320_mts.GUI;

import javax.swing.*;

public class Application extends JFrame {
    private TransferOthersAccount   transferOthers;
    private Register                register;
    private CheckBalance            checkBalance;
    private MainMenu                mainMenu;
    private ViewTransactionHist     viewTransaction;
    private Welcome                 welcome;
    private ChangePassword          changePassword;
    private TransferOwnAccount      transferOwn;
    private Login                   login;

    public void init(){

        this.setTitle("Money Transfer System");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,800);
        this.setResizable(false);
        this.setVisible(true);

        // create panels
        transferOthers  = new TransferOthersAccount(this.getSize());
        register        = new Register(this.getSize());
        checkBalance    = new CheckBalance(this.getSize());
        mainMenu        = new MainMenu(this.getSize());
        viewTransaction = new ViewTransactionHist(this.getSize());
        welcome         = new Welcome(this.getSize());
        changePassword  = new ChangePassword(this.getSize());
        transferOwn     = new TransferOwnAccount(this.getSize());
        login           = new Login(this.getSize());
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
        mainMenu.setCheckBalance(checkBalance);
        mainMenu.setTransferOwnAccount(transferOwn);
        mainMenu.setTransferOthersAccount(transferOthers);
        mainMenu.setViewTransactionHist(viewTransaction);
        mainMenu.setChangePassword(changePassword);
        this.setVisible(true);


    }
}
