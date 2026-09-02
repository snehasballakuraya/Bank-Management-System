package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener{
    JTextField amount;
    JButton withdrawal,back;
    String pinnumber;
    public Withdrawal(String pinnumber){
    this.pinnumber=pinnumber;
        
    setLayout(null);
        
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo1.jpeg"));
    Image i2=i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 850, 720);
    add(image);
        
    JLabel text=new JLabel("Enter the Amount you want to Withdraw");
    text.setFont(new Font("Raleway",Font.BOLD,15));
    text.setBounds(220, 110, 700, 20);
    text.setForeground(Color.BLACK);
    image.add(text);
    
    amount=new JTextField();
    amount.setFont(new Font("Raleway",Font.BOLD,15));
    amount.setBounds(230, 160, 280, 25);
    image.add(amount);
    
    withdrawal=new JButton("Withdraw");
    withdrawal.setBounds(370, 300, 100, 30);
    withdrawal.addActionListener(this);
    image.add(withdrawal);
    
    back=new JButton("Back");
    back.setBounds(250, 300, 100, 30);
    back.addActionListener(this);
    image.add(back);
    
    
    setSize(850, 800);
    setLocation(350, 0);
//    setUndecorated(true);
    setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==withdrawal){
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the amount you want to withdraw");
            }else{
                try{
                Conn conn=new Conn();
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +number+ " Withdraw Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
        }else if(ae.getSource()==back){
            setVisible(false);
           new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Withdrawal("");
    }

    
}
