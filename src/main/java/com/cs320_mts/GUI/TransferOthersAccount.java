package com.cs320_mts.GUI;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import com.cs320_mts.model.User;
import com.cs320_mts.service.AccountService;

import com.cs320_mts.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class TransferOthersAccount extends JPanel {
	
	@Autowired
	AccountService accountService;

    @Autowired
    UserServiceImpl userService;
	
    private int userId;
    private final JLabel accountSender;
    private final JList accountsList;
    private final JLabel accountID;
    private final JLabel amount;
    // private final JLabel name;
    private final JTextField accountIDText;
    private final JTextField amountText;
    // private final JTextField nameText;
    private final JButton confirm;
    private final JButton back;
    private final TransferOthersAccount currentPanel;


    public TransferOthersAccount(){
        currentPanel = this;

        accountSender   = new JLabel("Choose Sender Account");
        accountID 		= new JLabel("Account ID");
        amount 			= new JLabel("Amount");
        // name 			= new JLabel("User Name");
        accountIDText	= new JTextField();
        amountText		= new JTextField();
        // nameText 		= new JTextField();
        confirm			= new JButton("Confirm");
        back			= new JButton("Back");


        DefaultListModel listModel;
        listModel = new DefaultListModel();

        // ************ DATABASE ACTION NECESSARY ************
        accountsList    = new JList(listModel);
        List<Account> accounts = userService.getById(userId).getAccounts();
        for(Account account : accounts) {
       	 listModel.addElement(account.getAccountId());
        }
        // DATABASE ACTION HERE //ADD ACCOUNTS WITH user.getAccounts().get().getAccountId();
        // **********************************************************************


        //LAYOUT
        this.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        GridBagConstraints c3 = new GridBagConstraints();
        GridBagConstraints c4 = new GridBagConstraints();
        //GridBagConstraints c5 = new GridBagConstraints();
        //GridBagConstraints c6 = new GridBagConstraints();
        GridBagConstraints c7 = new GridBagConstraints();
        GridBagConstraints c8 = new GridBagConstraints();
        GridBagConstraints c9 = new GridBagConstraints();
        GridBagConstraints c10 = new GridBagConstraints();

        c9.gridy = 0;
        c10.gridy = 1;
        c1.gridy = 2;
        c2.gridy = 3;
        c3.gridy = 4;
        c4.gridy = 5;
        //c5.gridy = 6;
        //c6.gridy = 7;
        c7.gridy = 8;
        c8.gridy = 9;

        c2.ipady = 20;
        c2.ipadx = 220;
        c4.ipady = 20;
        c4.ipadx = 220;
        //c6.ipady = 20;
        //c6.ipadx = 240;

        c1.insets = new Insets(20,0,0,0);
        c3.insets = new Insets(20,0,0,0);
        // c5.insets = new Insets(20,0,0,0);
        c7.insets = new Insets(20,0,20,0);

        accountSender.setFont(new Font("Arial",Font.ITALIC,30));
        accountsList.setFont(new Font("Arial",Font.ITALIC,30));
        accountID.setFont(new Font("Arial",Font.ITALIC,30));
        accountIDText.setFont(new Font("Arial",Font.ITALIC,30));
        amount.setFont(new Font("Arial",Font.ITALIC,30));
        amountText.setFont(new Font("Arial",Font.ITALIC,30));
       /* name.setFont(new Font("Arial", Font.ITALIC ,30));
        nameText.setFont(new Font("Arial", Font.ITALIC ,30));*/
        confirm.setFont(new Font("Arial",Font.ITALIC,30));
        back.setFont(new Font("Arial",Font.ITALIC,30));

        this.add(accountSender,c9);
        this.add(accountsList,c10);
        this.add(accountID,c1);
        this.add(accountIDText,c2);
        accountIDText.setHorizontalAlignment(JTextField.CENTER);
        this.add(amount,c3);
        this.add(amountText,c4);
        amountText.setHorizontalAlignment(JTextField.CENTER);
     /*   this.add(name,c5);
        this.add(nameText,c6);
        nameText.setHorizontalAlignment(JTextField.CENTER);*/
        this.add(confirm,c7);
        this.add(back,c8);
    }

    //MONEY TRANSFER NEEDS TO BE DONE !!!
    public void setConfirmButton(MainMenu backPanel){
        confirm.addActionListener(e -> {
            try {
                    if(accountsList.isSelectionEmpty()) {
                        throw new Exception("Please choose sender account!");
                    }
                int selectedSenderAccountId = parseInt(accountsList.getSelectedValue().toString());
                int amount = parseInt(amountText.getText());
                int receiverAccountId = parseInt(accountIDText.getText());

                //DATABASE ACTION
                Transaction transaction = new Transaction();
                transaction.setReceiverAccId(receiverAccountId);
                transaction.setAmount(amount);
                accountService.moneyTransfer(selectedSenderAccountId, transaction);


                // ADD MODEL ACTION HERE



                backPanel.setVisible(true);
                currentPanel.setVisible(false);
            }catch (NumberFormatException es1){
                JOptionPane.showMessageDialog(new JFrame(), "Amount and Receiver Account Id must be valid! ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
            catch(Exception es2){
                JOptionPane.showMessageDialog(new JFrame(),es2.getMessage()  , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // DO NOT TOUCH THIS METHOD
    public void setBackButton(MainMenu backPanel){
        back.addActionListener(e -> {
            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    public void setUserId(int user) {
        this.userId = userId;
    }
}
