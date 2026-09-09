package bank_management_system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton back, exit;
    String pinnumber;

    public MiniStatement(String pinnumber) {

        this.pinnumber = pinnumber;

        setTitle("Mini Statement");
        setLayout(null);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 150, 30);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(150, 60, 500, 30);
        add(card);

        JLabel balance = new JLabel();
        balance.setBounds(150, 90, 500, 30);
        add(balance);

        JLabel mini = new JLabel();
        mini.setBounds(150, 140, 600, 250);
        mini.setVerticalAlignment(SwingConstants.TOP);
        add(mini);

        back = new JButton("Back");
        back.setBounds(380, 450, 130, 30);
        back.addActionListener(this);
        add(back);

        exit = new JButton("Exit");
        exit.setBounds(200, 450, 130, 30);
        exit.addActionListener(this);
        add(exit);

        
        try {

            Conn conn = new Conn();

            ResultSet rs = conn.s.executeQuery(
                    "select * from login where pin='" + pinnumber + "'"
            );

            while (rs.next()) {

                String cardnumber = rs.getString("cardnumber");

                card.setText(
                        "Card Number: "
                        + cardnumber.substring(0, 4)
                        + "XXXXXXXX"
                        + cardnumber.substring(cardnumber.length() - 4)
                );
            }

        } catch (Exception e) {
            System.out.println(e);
        }

       
        try {

            Conn conn = new Conn();

            int bal = 0;

            ResultSet rs = conn.s.executeQuery(
                    "select * from bank where pin='" + pinnumber + "'"
            );

            String statement = "<html>";

            while (rs.next()) {

                statement = statement
                        + rs.getString("date")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("type")
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                        + rs.getString("amount")
                        + "<br><br>";

                if (rs.getString("type").equals("Deposit")) {

                    bal += Integer.parseInt(rs.getString("amount"));

                } else {

                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            statement = statement + "</html>";
            mini.setText(statement);
            balance.setText("Your current account balance is Rs " + bal);

        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(850, 720);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new MiniStatement("");
    }
}