package com.cs320_mts.GUI;

import com.cs320_mts.model.Account;
import com.cs320_mts.model.User;
import com.cs320_mts.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.List;

@Component
public class CheckBalance extends JPanel {
    private int userId;
    private final JButton back;
    private final JTable table;
    private final CheckBalance currentPanel;

    @Autowired
    UserServiceImpl userService;

    public CheckBalance(){
        currentPanel = this;

        back  = new JButton("Back");

        String[] columns        = {"Account ID", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        table                   = new JTable(model);
        model.addRow(new String[]{"Account Id","Balance"});
        //DO NOT TOUCH ABOVE, IF IT'S POSSIBLE

        // ************ DATABASE ACTION NECESSARY ************
        List<Account> accounts = userService.getById(userId).getAccounts();
        for(Account account : accounts) {
        	String accountId = String.valueOf(account.getAccountId());
        	String balance = String.valueOf(account.getBalance());
        	model.addRow(new String[] {accountId, balance});
        }
        // **********************************************************************


        //LAYOUT __ DO NOT TOUCH
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 0;
        table.setRowHeight(40);
        c.ipadx = 500;
        this.add(table,c);
        c.gridx = 0;
        c.gridy = 2;
        c.ipadx = 200;
        c.insets = new Insets(40,0,0,0);
        this.add(back,c);

        table.setFont(new Font("Arial",Font.ITALIC,30));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);
        table.setDefaultEditor(Object.class, null);
        back.setFont(new Font("Arial",Font.BOLD,20));

    }

    // DO NOT TOUCH THIS METHOD
    public void setBackButton(MainMenu backPanel){
        back.addActionListener(e -> {
            backPanel.setVisible(true);
            currentPanel.setVisible(false);
        });
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
