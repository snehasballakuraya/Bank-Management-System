package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
   JButton deposit,withdraw,fastcash,mini,pinchange,balanceenquiry,exit;
   String pinnumber;
  FastCash(String pinnumber) {
      this.pinnumber=pinnumber;
    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo1.jpeg"));
    Image i2=i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 850, 720);
    add(image);
            
    JLabel text= new JLabel("SELECT WITHDRAWAL AMOUNT");
    text.setFont(new Font("Raleway",Font.BOLD,16));
    text.setBounds(240, 110, 700, 35);
    text.setForeground(Color.BLACK);
    image.add(text);
    
    deposit=new JButton("Rs 100");
    deposit.setBounds(240, 223, 130, 30);
    deposit.addActionListener(this);
    image.add(deposit);
    
    withdraw=new JButton("Rs 500");
    withdraw.setBounds(380, 223, 130, 30);
    withdraw.addActionListener(this);
    image.add(withdraw);
    
    fastcash=new JButton("Rs 1000");
    fastcash.setBounds(240, 263, 130, 30);
    fastcash.addActionListener(this);
    image.add(fastcash);
    
    mini=new JButton("Rs 2000");
    mini.setBounds(380, 263, 130, 30);
    mini.addActionListener(this);
    image.add(mini);
    
    pinchange=new JButton("Rs 5000");
    pinchange.setBounds(240, 302, 130, 30);
    pinchange.addActionListener(this);
    image.add(pinchange);
    
    balanceenquiry=new JButton("Rs 10000");
    balanceenquiry.setBounds(380, 302, 130, 30);
    balanceenquiry.addActionListener(this);
    image.add(balanceenquiry);
    
    exit=new JButton("BACK");
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
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
       }else {
           String amount=((JButton)ae.getSource()).getText().substring(3);
           Conn c=new Conn();
           try{
               ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"' ");
               int balance=0;
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                  JOptionPane.showMessageDialog(null, "Insufficient Balance");
                  return;
               }
               
               Date date=new Date();
               String query="insert into bank values('"+pinnumber+"','"+date+"','Withdrawal','"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited Successfully");
               
               setVisible(false);
               new Transactions(pinnumber).setVisible(true);
           }catch(Exception e){
               System.out.println(e);
           }
       }
       
    }
  
  
    public static void main(String[] args) {
        new FastCash("");
    }

    
}