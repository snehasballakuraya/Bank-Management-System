package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener{
    JRadioButton saving,fixed,current,recurring;
    JButton submit,cancel;
    JCheckBox atm,internet,mobile,sms,cheque,estatement,declare;
    String formno;
    SignUpThree(String formno){
        this.formno=formno;
        setLayout(null);
        
        JLabel p3details=new JLabel("Page 3: Account Details ");
        p3details.setFont(new Font("Raleway",Font.BOLD,22));
        p3details.setBounds(280, 40, 400, 40);
        add(p3details);
        
        JLabel account=new JLabel("Account Type");
        account.setFont(new Font("Raleway",Font.BOLD,22));
        account.setBounds(100, 140, 200, 30);
        add(account);
        
        saving=new JRadioButton("Saving Account");
        saving.setFont(new Font("Raleway",Font.BOLD,16));
        saving.setBackground(Color.WHITE);
        saving.setBounds(100, 180, 160, 20);
        add(saving);
        
        fixed=new JRadioButton("Fixed Deposit Account");
        fixed.setFont(new Font("Raleway",Font.BOLD,16));
        fixed.setBackground(Color.WHITE);
        fixed.setBounds(350, 180, 200, 20);
        add(fixed);
        
        current=new JRadioButton("Current Account");
        current.setFont(new Font("Raleway",Font.BOLD,16));
        current.setBackground(Color.WHITE);
        current.setBounds(100, 220, 160, 20);
        add(current);
        
        recurring=new JRadioButton("Recurring Deposit Account");
        recurring.setFont(new Font("Raleway",Font.BOLD,16));
        recurring.setBackground(Color.WHITE);
        recurring.setBounds(350, 220, 240, 20);
        add(recurring);
        
        ButtonGroup abg=new ButtonGroup();
        abg.add(saving);
        abg.add(fixed);
        abg.add(current);
        abg.add(recurring);
        
        JLabel card=new JLabel("Card Number: ");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100, 260, 200, 30);
        add(card);
        
        JLabel no=new JLabel("XXXX-XXXX-XXXX-4184");
        no.setFont(new Font("Raleway",Font.BOLD,22));
        no.setBounds(300, 260, 300, 30);
        add(no);
        
        JLabel details=new JLabel("Your 16 Digits Card Number");
        details.setFont(new Font("Raleway",Font.BOLD,10));
        details.setBounds(100, 290, 300, 20);
        add(details);
        
        JLabel pins=new JLabel("PIN:");
        pins.setFont(new Font("Raleway",Font.BOLD,22));
        pins.setBounds(100, 330, 200, 30);
        add(pins);
        
        JLabel number=new JLabel("XXXX");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300, 330, 300, 30);
        add(number);
        
        JLabel pdetails=new JLabel("Your 4 Digit Pin");
        pdetails.setFont(new Font("Raleway",Font.BOLD,10));
        pdetails.setBounds(100, 360, 300, 20);
        add(pdetails);
        
        JLabel service=new JLabel("Services Required:");
        service.setFont(new Font("Raleway",Font.BOLD,22));
        service.setBounds(100, 400, 200, 30);
        add(service);
        
        atm = new JCheckBox("ATM CARD");
        atm.setBackground(Color.WHITE);
        atm.setFont(new Font("Raleway",Font.BOLD,14));
        atm.setBounds(100, 430, 100, 30);
        add(atm);
        
        internet = new JCheckBox("Internet Banking");
        internet.setBackground(Color.WHITE);
        internet.setFont(new Font("Raleway",Font.BOLD,14));
        internet.setBounds(350, 430, 150, 30);
        add(internet);
        
        mobile = new JCheckBox("Mobile Banking");
        mobile.setBackground(Color.WHITE);
        mobile.setFont(new Font("Raleway",Font.BOLD,14));
        mobile.setBounds(100, 470, 150, 30);
        add(mobile);
        
        sms = new JCheckBox("Email & SMS Alerts");
        sms.setBackground(Color.WHITE);
        sms.setFont(new Font("Raleway",Font.BOLD,14));
        sms.setBounds(350, 470, 180, 30);
        add(sms);
        
        cheque = new JCheckBox("Cheque Book");
        cheque.setBackground(Color.WHITE);
        cheque.setFont(new Font("Raleway",Font.BOLD,14));
        cheque.setBounds(100, 510, 200, 30);
        add(cheque);
        
        estatement = new JCheckBox("E-Statement");
        estatement.setBackground(Color.WHITE);
        estatement.setFont(new Font("Raleway",Font.BOLD,14));
        estatement.setBounds(350, 510, 200, 30);
        add(estatement);
        
        declare = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        declare.setBackground(Color.WHITE);
        declare.setFont(new Font("Raleway",Font.BOLD,12));
        declare.setBounds(100, 560, 550, 30);
        add(declare);
        
        submit =new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(200, 600, 130, 40);
        submit.addActionListener(this);
        add(submit);
        
        cancel =new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420, 600, 130, 40);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setSize(850, 720);
        setLocation(350, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
            String accountType=null;
            if(saving.isSelected()){
                accountType="Savings Account";
            }else if(fixed.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(current.isSelected()){
               accountType="Current Account"; 
            }else if(recurring.isSelected()){
                accountType="Recurring Deposit Account";
            }
            
            Random ran=new Random();
            String cardno=""+Math.abs((ran.nextLong() % 90000000L)) + 5040936000000000L;
            
            String pinnumber=""+Math.abs((ran.nextLong() % 9000L) + 1000L);
            
            String facility="";
            if(atm.isSelected()){
                facility=facility+" ATM Card";
            }else if(internet.isSelected()){
                facility=facility+" Internet Banking";
            }else if(mobile.isSelected()){
                facility=facility+" Mobile Banking";
            }else if(sms.isSelected()){
                facility=facility+" Email & SMS Alerts";
            }else if(cheque.isSelected()){
                facility=facility+" Cheque Book";
            }else if(estatement.isSelected()){
                facility=facility+" E-Statement";
            }
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }else{
                    Conn c=new Conn();
                    String query2="insert into signupthree values('"+formno+"','"+accountType+"','"+cardno+"','"+pinnumber+"','"+facility+"')";
                    c.s.executeUpdate(query2);
                    String query3="insert into login values('"+formno+"','"+cardno+"','"+pinnumber+"')";
                    c.s.executeUpdate(query3);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
                 
                
              
              JOptionPane.showMessageDialog(this, "Page 3 details submitted successfully!");
              
                
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
   }
    
    
    public static void main(String[] args) {
        new SignUpThree("");
    }

    
    
}
