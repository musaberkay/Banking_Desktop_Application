package com.cs320_mts.GUI;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.Transaction;
import com.cs320_mts.service.AccountService;

import com.cs320_mts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

@Component
public class TransferOthersAccount extends JPanel {
	
	@Autowired
	AccountService accountService;

    @Autowired
    UserService userService;
	
    private int userId;
    private JLabel accountSender;
    private JList accountsList;
    private JLabel accountID;
    private JLabel amount;
    private JTextField accountIDText;
    private JTextField amountText;
    private JButton confirm;
    private JButton back;
    private TransferOthersAccount currentPanel;

    public TransferOthersAccount(){}

    public void setTransferOthersAccount(){
    	removeAll();
    	currentPanel = this;

        accountSender   = new JLabel("Choose Sender Account");
        accountID 		= new JLabel("Account ID");
        amount 			= new JLabel("Amount");
        accountIDText	= new JTextField();
        amountText		= new JTextField();

        DefaultListModel listModel;
        listModel = new DefaultListModel();


        List<Account> accounts = userService.getById(userId).getAccounts();
        List<Integer> accIdList = new ArrayList<>();
        List<Integer> filteredAccIdList = new ArrayList<>();

        for(Account account : accounts)
        {
            accIdList.add(account.getAccountId());
        }
        for(Integer item : accIdList)
        {
            if(!isContain(filteredAccIdList,item))
                filteredAccIdList.add(item);
        }
        for(Integer item : filteredAccIdList)
            listModel.addElement(item);

        accountsList    = new JList(listModel);

        //LAYOUT
        this.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();
        GridBagConstraints c2 = new GridBagConstraints();
        GridBagConstraints c3 = new GridBagConstraints();
        GridBagConstraints c4 = new GridBagConstraints();
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
        c7.gridy = 8;
        c8.gridy = 9;

        c2.ipady = 20;
        c2.ipadx = 220;
        c4.ipady = 20;
        c4.ipadx = 220;

        c1.insets = new Insets(20,0,0,0);
        c3.insets = new Insets(20,0,0,0);
        c7.insets = new Insets(20,0,20,0);

        accountSender.setFont(new Font("Arial",Font.ITALIC,30));
        accountsList.setFont(new Font("Arial",Font.ITALIC,30));
        accountID.setFont(new Font("Arial",Font.ITALIC,30));
        accountIDText.setFont(new Font("Arial",Font.ITALIC,30));
        amount.setFont(new Font("Arial",Font.ITALIC,30));
        amountText.setFont(new Font("Arial",Font.ITALIC,30));
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
        this.add(confirm,c7);
        this.add(back,c8);
    }

    //MONEY TRANSFER NEEDS TO BE DONE !!!
    public void setConfirmButton(MainMenu backPanel){
    	confirm = new JButton("Confirm");
        confirm.addActionListener(e -> {
            try {
                if(accountsList.isSelectionEmpty()) {
                    throw new Exception("Please choose sender account!");
                }
                int selectedSenderAccountId = parseInt(accountsList.getSelectedValue().toString());
                int amount = parseInt(amountText.getText());
                int receiverAccountId = parseInt(accountIDText.getText());

                //DATABASE ACTION
                List<Integer> list = new ArrayList<>();
                for(Account account: userService.getById(userId).getAccounts()){
                    list.add(account.getAccountId());
                }
                if(!list.contains(receiverAccountId)) {
                    Transaction transaction = new Transaction();
                    transaction.setReceiverAccId(receiverAccountId);
                    transaction.setAmount(amount);
                    accountService.moneyTransfer(selectedSenderAccountId, transaction);
                }
                else{
                    throw new Exception("You can not send money to your own account in this page.");
                }

                // ADD MODEL ACTION HERE

                backPanel.setVisible(true);
                currentPanel.setVisible(false);
            } catch (NumberFormatException es1){
                JOptionPane.showMessageDialog(new JFrame(), "Amount and Receiver Account Id must be valid! ", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } catch(Exception es2){
                JOptionPane.showMessageDialog(new JFrame(),es2.getMessage()  , "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // DO NOT TOUCH THIS METHOD
    public void setBackButton(MainMenu backPanel){
    	back = new JButton("Back");
        back.addActionListener(e -> {
            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private boolean isContain(List<Integer> idList, int id)
    {
        for (Integer item : idList)
        {
            if(item == id)
                return true;
        }
        return false;
    }
}