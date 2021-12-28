package com.cs320_mts.GUI;

import com.cs320_mts.model.*;
import com.cs320_mts.service.AccountService;
import com.cs320_mts.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Component
public class ViewTransactionHist extends JPanel {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
    private int userId;
    private JButton back;
    private JTable transactions1;
    private JTable transactions2;
    private JTable transactions3;
    private ViewTransactionHist currentPanel;

    public ViewTransactionHist(){ }
    
    public void setViewTransactionHist() {
    	removeAll();
    	currentPanel    = this;

        // ************ GUI ACTION NECESSARY ************
    	// GUI ACTION IS NEEDED TO CREATE TABLES FOR EACH ACCOUNT OF THE USER
        String[] columns        = {"Transaction Id","Date","Amount","Sender Account","Receiver Account"};
        DefaultTableModel model1 = new DefaultTableModel(columns,0);
        transactions1            = new JTable(model1);
        DefaultTableModel model2 = new DefaultTableModel(columns,0);
        transactions2            = new JTable(model2);
        DefaultTableModel model3 = new DefaultTableModel(columns,0);
        transactions3            = new JTable(model3);
        // ************ DON'T TOUCH ************
        model1.addRow(new String[]{"Transaction Id","Date","Amount","Sender Account","Receiver Account"});
        model2.addRow(new String[]{"Transaction Id","Date","Amount","Sender Account","Receiver Account"});
        model3.addRow(new String[]{"Transaction Id","Date","Amount","Sender Account","Receiver Account"});
        // ************ DON'T TOUCH ************


        //EXAMPLES - DELETE AFTER IMPL!!!!
        /*model1.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"}); // Example for adding row
        model1.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model1.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model2.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model2.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model2.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model3.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model3.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model3.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});*/
        

        // ************ MODEL ACTION NECESSARY ************
        int counter = 0;
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        
        for(Account account: accountService.getAccountsByUserId(userId)){
            int size = account.getTransactions().size();
            List<Transaction> transactions = account.getTransactions();
            if(counter == 0){
                if(size>0){
                    model1.addRow(new String[]{Integer.toString(transactions.get(size-1).getTransactionId()),
                            dateFormat.format(transactions.get(size-1).getDate()),
                            Double.toString(transactions.get(size-1).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-1).getRecipientAccId())});
                }
                if(size>1){
                    model1.addRow(new String[]{Integer.toString(transactions.get(size-2).getTransactionId()),
                            dateFormat.format(transactions.get(size-2).getDate()),
                            Double.toString(transactions.get(size-2).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-2).getRecipientAccId())});
                }
                if(size>2){
                    model1.addRow(new String[]{Integer.toString(transactions.get(size-3).getTransactionId()),
                            dateFormat.format(transactions.get(size-3).getDate()),
                            Double.toString(transactions.get(size-3).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-3).getRecipientAccId())});
                }
            }
            if(counter == 1){
                if(size>0){
                    model2.addRow(new String[]{Integer.toString(transactions.get(size-1).getTransactionId()),
                            dateFormat.format(transactions.get(size-1).getDate()),
                            Double.toString(transactions.get(size-1).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-1).getRecipientAccId())});
                }
                if(size>1){
                    model2.addRow(new String[]{Integer.toString(transactions.get(size-2).getTransactionId()),
                            dateFormat.format(transactions.get(size-2).getDate()),
                            Double.toString(transactions.get(size-2).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-2).getRecipientAccId())});
                }
                if(size>2){
                    model2.addRow(new String[]{Integer.toString(transactions.get(size-3).getTransactionId()),
                            dateFormat.format(transactions.get(size-3).getDate()),
                            Double.toString(transactions.get(size-3).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-3).getRecipientAccId())});
                }
            }
            if(counter == 2){
                if(size>0){
                    model3.addRow(new String[]{Integer.toString(transactions.get(size-1).getTransactionId()),
                            dateFormat.format(transactions.get(size-1).getDate()),
                            Double.toString(transactions.get(size-1).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-1).getRecipientAccId())});
                }
                if(size>1){
                    model3.addRow(new String[]{Integer.toString(transactions.get(size-2).getTransactionId()),
                            dateFormat.format(transactions.get(size-2).getDate()),
                            Double.toString(transactions.get(size-2).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-2).getRecipientAccId())});
                }
                if(size>2){
                    model3.addRow(new String[]{Integer.toString(transactions.get(size-3).getTransactionId()),
                            dateFormat.format(transactions.get(size-3).getDate()),
                            Double.toString(transactions.get(size-3).getAmount()),
                            Integer.toString(account.getAccountId()),
                            Integer.toString(transactions.get(size-3).getRecipientAccId())});
                }
            }
            counter++;
        }
        // MODEL ACTION HERE
        // LAST 10 TRANSACTIONS!!!
        // use model.addRow() with 5 String tuple For each transaction
        // model.addRow(new String[]{"2345","2021-12-01,"1200$","123850291","742930123"})
        // **********************************************************************


        //DO NOT TOUCH below
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        //transaction1
        c.gridx = 0;
        c.gridy = 0;
        transactions1.setRowHeight(40);
        c.ipadx = 750;
        this.add(transactions1,c);
        //transaction2 if it exists
        if(userService.getById(userId).getAccounts().size()>1){
            c.gridx = 0;
            c.gridy = 1;
            transactions2.setRowHeight(40);
            c.ipadx = 750;
            c.insets = new Insets(10,0,0,0);
            this.add(transactions2,c);
        }
        if(userService.getById(userId).getAccounts().size()>2){
            c.gridx = 0;
            c.gridy = 2;
            transactions3.setRowHeight(40);
            c.ipadx = 750;
            c.insets = new Insets(10,0,0,0);
            this.add(transactions3,c);
        }
        c.gridx = 0;
        c.gridy = 3;
        c.ipadx = 200;
        c.insets = new Insets(40,0,0,0);
        this.add(back,c);

        transactions1.setFont(new Font("Arial",Font.ITALIC,12));
        transactions2.setFont(new Font("Arial",Font.ITALIC,12));
        transactions3.setFont(new Font("Arial",Font.ITALIC,12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        transactions1.setDefaultRenderer(String.class, centerRenderer);
        transactions2.setDefaultRenderer(String.class, centerRenderer);
        transactions3.setDefaultRenderer(String.class, centerRenderer);
        transactions1.setDefaultEditor(Object.class, null);
        transactions2.setDefaultEditor(Object.class, null);
        transactions3.setDefaultEditor(Object.class, null);
        back.setFont(new Font("Arial",Font.BOLD,20));
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

    private boolean isContain(List<Account> accountList,int id)
    {
        for (Account account : accountList)
        {
            if(account.getAccountId() == id)
                return true;
        }
        return false;
    }
}
