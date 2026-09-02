package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{
   JButton deposit,withdraw,fastcash,mini,pinchange,balanceenquiry,exit;
   String pinnumber;
  Transactions(String pinnumber) {
      this.pinnumber=pinnumber;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo1.jpeg"));
    Image i2=i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 850, 720);
    add(image);
            
    JLabel text= new JLabel("Please select your Transaction");
    text.setFont(new Font("Raleway",Font.BOLD,16));
    text.setBounds(250, 110, 700, 35);
    text.setForeground(Color.BLACK);
    image.add(text);
    
    deposit=new JButton("Deposit");
    deposit.setBounds(240, 223, 130, 30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    withdraw=new JButton("Withdraw");
    withdraw.setBounds(380, 223, 130, 30);
    withdraw.addActionListener(this);
    image.add(withdraw);
    
    fastcash=new JButton("Fast Cash");
    fastcash.setBounds(240, 263, 130, 30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    mini=new JButton("Mini Statement");
    mini.setBounds(380, 263, 130, 30);
    mini.addActionListener(this);
    image.add(mini);
    
    pinchange=new JButton("Pin Change");
    pinchange.setBounds(240, 302, 130, 30);
    pinchange.addActionListener(this);
    image.add(pinchange);
    
    balanceenquiry=new JButton("Balance Enquiry");
    balanceenquiry.setBounds(380, 302, 130, 30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);
    
    exit=new JButton("Exit");
    exit.setBounds(380, 340, 130, 30);
    exit.addActionListener(this);
    image.add(exit);
    
    setSize(850, 720);
    setLocation(350, 0);
    setUndecorated(true);
    setVisible(true);
      
}

    public void actionPerformed(ActionEvent ae) {
       if(ae.getSource()==exit){
           System.exit(0);
       }else if(ae.getSource()==deposit){
           setVisible(false);
           new Deposit(pinnumber).setVisible(true);
       }
       else if(ae.getSource()==withdraw){
           setVisible(false);
           new Withdrawal(pinnumber).setVisible(true);
       }
    }
  
  
    public static void main(String[] args) {
        new Transactions("");
    }

    
}