package com.cs320_mts.GUI;

import com.cs320_mts.model.User;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Component
public class ViewTransactionHist extends JPanel {
    private int userId;
    private final JButton back;
    private final JTable transactions;
    private final ViewTransactionHist currentPanel;
    public ViewTransactionHist(){
        currentPanel    = this;
        back            = new JButton("Back");

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
        back.addActionListener(e -> {
            mainMenu.setVisible(true);
            currentPanel.setVisible(false);
        });
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
}
