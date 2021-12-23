package com.cs320_mts.GUI;

import com.cs320_mts.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewTransactionHist extends JPanel {
    private User user;
    private final JButton back;
    private final JTable transactions;
    private final ViewTransactionHist currentPanel;
    public ViewTransactionHist(Dimension size){
        currentPanel    = this;
        back            = new JButton();

        String[] columns        = {"Transaction Id","Date","Amount","Sender Account","Receiver Account"};
        DefaultTableModel model = new DefaultTableModel(columns,0);
        transactions            = new JTable(model);

        // ************ DATABASE ACTION NECESSARY ************
        // DATABASE ACTION HERE
        // use model.addRow() with 5 String tuple For each transaction
        // model.addRow({"2345","2021-12-01,"1200$","123850291","742930123"})
        // **********************************************************************

        this.setSize(size);
        this.add(back);
        this.add(transactions);
    }
    // ************ DON'T TOUCH ************
    public void setBackButton(MainMenu mainMenu){
        back.addActionListener(e -> {
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    public void setUser(User user){
        user = user;
    }
}
