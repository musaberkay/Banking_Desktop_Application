package com.cs320_mts.GUI;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import com.cs320_mts.service.AccountService;
import com.cs320_mts.service.UserService;
import com.cs320_mts.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Component
public class TransferOwnAccount extends JPanel {
	
	@Autowired
    AccountService accountService;

    @Autowired
    UserService userService;
	
    private int userId;
    private JLabel accountSender;
    private JLabel accountReceiver;
    private JLabel amount;
    private JList accountsList1;
    private JList accountsList2;
    private JTextField amountText;
    private JButton confirm;
    private JButton back;
    private TransferOwnAccount currentPanel;

    public TransferOwnAccount(){}
    
    public void setTransferOwnAccount() {
    	this.removeAll();
    	currentPanel            = this;
        accountSender           = new JLabel("Choose Sender Account");
        accountReceiver         = new JLabel("Choose Receiver Account");
        amount                  = new JLabel("Amount");
        amountText      = new JTextField();
        DefaultListModel listModel;
        listModel = new DefaultListModel();
        
        List<Account> accounts = userService.getById(userId).getAccounts();
        for(Account account : accounts) {
        	listModel.addElement(account.getAccountId());
        }
        accountsList1   = new JList(listModel);
        accountsList2   = new JList(listModel);


        // ************ DON'T TOUCH ************


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

        c1.gridy = 0;
        c2.gridy = 1;
        c7.gridy = 2;
        c8.gridy = 3;
        c3.gridy = 4;
        c4.gridy = 5;
        c5.gridy = 6;
        c6.gridy = 7;

        c4.ipady = 20;
        c4.ipadx = 220;

        c7.insets = new Insets(20,0,0,0);
        c3.insets = new Insets(20,0,0,0);
        c5.insets = new Insets(20,0,20,0);

        amount.setFont(new Font("Arial",Font.ITALIC,40));
        amountText.setFont(new Font("Arial",Font.ITALIC,30));
        accountSender.setFont(new Font("Arial", Font.ITALIC ,40));
        accountsList1.setFont(new Font("Arial", Font.ITALIC ,30));
        accountReceiver.setFont(new Font("Arial", Font.ITALIC ,40));
        accountsList2.setFont(new Font("Arial", Font.ITALIC ,30));
        confirm.setFont(new Font("Arial",Font.ITALIC,30));
        back.setFont(new Font("Arial",Font.ITALIC,30));


        this.add(accountSender,c1);
        this.add(accountsList1,c2);
        this.add(accountReceiver,c7);
        this.add(accountsList2,c8);
        this.add(amount,c3);
        this.add(amountText,c4);
        amountText.setHorizontalAlignment(JTextField.CENTER);
        this.add(confirm,c5);
        this.add(back,c6);
    }
    
    // ************ DATA HAS RECEIVED. DATABASE ACTION NECESSARY ************
    public void setConfirmButton(MainMenu mainMenu){
    	confirm = new JButton("Confirm");
        confirm.addActionListener(e -> {
            try {
                    if(accountsList1.isSelectionEmpty()) {
                        throw new Exception("Please choose sender account!");
                    }
                    if(accountsList2.isSelectionEmpty()) {
                        throw new Exception("Please choose receiver account!");
                    }


                int selectedSenderAccountId = Integer.parseInt(String.valueOf(accountsList1.getSelectedValue()));
                int selectedReceiverAccountId = Integer.parseInt(String.valueOf(accountsList2.getSelectedValue()));
                double amount = Double.parseDouble(amountText.getText());

                if(selectedSenderAccountId==selectedReceiverAccountId)
                    throw new Exception("You can not choose same account.");

                // DATABASE ACTION HERE
                Transaction transaction = new Transaction();
                transaction.setReceiverAccId(selectedReceiverAccountId);
                transaction.setAmount(amount);
                accountService.moneyTransfer(selectedSenderAccountId, transaction);  // validation of transfer is checked under moneyTransfer method


                // ************ DON'T TOUCH ************
                mainMenu.setVisible(true);
                currentPanel.setVisible(false);
            }catch (NumberFormatException es1){
                JOptionPane.showMessageDialog(new JFrame(), "Amount must be valid! ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception es2){
                JOptionPane.showMessageDialog(new JFrame(),es2.getMessage()  , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        });
    }
    // ************ DON'T TOUCH ************
    public void setBackButton(MainMenu mainMenu){
    	back = new JButton("Back");
        back.addActionListener(e -> {
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    
    public void setUserId(int userId){
        this.userId = userId;
    }
}
