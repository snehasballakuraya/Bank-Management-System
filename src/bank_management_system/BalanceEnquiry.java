package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
JButton back;
String pinnumber;
    public BalanceEnquiry(String pinnumber) {
    this.pinnumber=pinnumber;
    setLayout(null);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo1.jpeg"));
    Image i2=i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 850, 720);
    add(image);
        
    back=new JButton("BACK");
    back.setBounds(390, 300, 100, 35);
    back.addActionListener(this);
    image.add(back);
               
    Conn c=new Conn();
    int balance=0;
           try{
               ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinnumber+"' ");
               
               while(rs.next()){
                   if(rs.getString("type").equals("Deposit")){
                       balance+=Integer.parseInt(rs.getString("amount"));
                   }else{
                       balance-=Integer.parseInt(rs.getString("amount"));
                   }
               }
           }catch(Exception e){
               System.out.println(e);
           }
    
    JLabel text=new JLabel("Your Current Account Balance is Rs "+balance);
     text.setForeground(Color.BLACK);
     text.setBounds(250, 150, 300, 35);
     image.add(text);
    
    
    setSize(850, 720);
    setLocation(350, 0);
    setUndecorated(true);
    setVisible(true);
    }
        
    public void actionPerformed(ActionEvent e) {
        
        setVisible(false);
        new Transactions(pinnumber).setVisible(true); 
    }
        
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    
}
