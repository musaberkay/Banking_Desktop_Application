package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class CheckBalance extends JPanel {
    private User user;
    private final JButton back;
    private final JTable table;

    private final CheckBalance currentPanel;

    public CheckBalance(Dimension size){
        currentPanel = this;

        back  = new JButton("Back");

        String[] columns        = {"Account ID", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        table                   = new JTable(model);
        model.addRow(new String[]{"Account Id","Balance"});
        model.addRow(new String[]{"33333333333","333333333333333"});
        model.addRow(new String[]{"12321312312","312312312312312"});
        // ************ DATABASE ACTION NECESSARY ************
        // DATABASE ACTION HERE
        // use model.addRow() with 2 String tuple For each transaction
        // model.addRow(new String[]{"5634", "3250"})
        // model.addRow(new String[]{user.getAccounts().get(0).getAccountId(), user.getAccounts().get(0).getBalance().toString()}
        // **********************************************************************
        this.setSize(size);
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

    public void setUser(User user) {
        this.user = user;
    }
}
