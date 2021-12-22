package com.cs320_mts.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

public class CheckBalance extends JPanel {
    private int userId;
    private final JButton back;
    private final JTable table;

    private final CheckBalance currentPanel;

    public CheckBalance(Dimension size){
        currentPanel = this;

        back  = new JButton("Back");

        String[] columns        = {"Account ID", "Balance"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        table            = new JTable(model);

        // ************ DATABASE ACTION NECESSARY ************
        // DATABASE ACTION HERE
        // use model.addRow() with 2 String tuple For each transaction
        // model.addRow({"5634", "3250"})
        // **********************************************************************


        this.add(back);
        this.add(table);
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
