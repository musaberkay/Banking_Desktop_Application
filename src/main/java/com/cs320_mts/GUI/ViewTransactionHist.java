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
import java.util.List;

@Component
public class ViewTransactionHist extends JPanel {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AccountService accountService;
	
    private int userId;
    private JButton back;
    private JTable transactions;
    private ViewTransactionHist currentPanel;
    
    public ViewTransactionHist(){ }
    
    public void setViewTransactionHist() {
    	removeAll();
    	currentPanel    = this;

        // ************ GUI ACTION NECESSARY ************
    	// GUI ACTION IS NEEDED TO CREATE TABLES FOR EACH ACCOUNT OF THE USER
        String[] columns        = {"Transaction Id","Date","Amount","Sender Account","Receiver Account"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        transactions            = new JTable(model);
        // ************ DON'T TOUCH ************
        model.addRow(new String[]{"Transaction Id","Date","Amount","Sender Account","Receiver Account"});
        // ************ DON'T TOUCH ************


        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"}); // Example for adding row
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        model.addRow(new String[]{"1","2021.12.23","2500"," 3705","6589"});
        

        // ************ MODEL ACTION NECESSARY ************
        // MODEL ACTION HERE
        // LAST 10 TRANSACTIONS!!!
        // use model.addRow() with 5 String tuple For each transaction
        // model.addRow(new String[]{"2345","2021-12-01,"1200$","123850291","742930123"})
        // **********************************************************************
        
        List<Account> accounts = userService.getById(userId).getAccounts();


        //DO NOT TOUCH below
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        transactions.setRowHeight(40);
        c.ipadx = 750;
        this.add(transactions,c);
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 200;
        c.insets = new Insets(40,0,0,0);
        this.add(back,c);

        transactions.setFont(new Font("Arial",Font.ITALIC,12));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        transactions.setDefaultRenderer(String.class, centerRenderer);
        transactions.setDefaultEditor(Object.class, null);
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
}
