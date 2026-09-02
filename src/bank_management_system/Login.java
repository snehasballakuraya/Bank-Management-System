package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login,clear,signUp;
    JTextField cardText;
    JPasswordField pinText;
    Login(){
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/Logo.png"));
        Image i2=il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        setLayout(null);
        add(label);
       
        JLabel l=new JLabel("Welcome to ATM");
        l.setFont(new Font("Osward",Font.BOLD,38));
        l.setBounds(200, 40,400 , 40);
        add(l);
        
        JLabel cardno=new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120, 150,150 , 30);
        add(cardno);
        
        cardText=new JTextField();
        cardText.setBounds(300,150,250,30);
        cardText.setFont(new Font("Arial",Font.BOLD,14));
        add(cardText);
        
        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220,400 , 30);
        add(pin);
        
        pinText=new JPasswordField();
        pinText.setBounds(300, 220, 250, 30);
        pinText.setFont(new Font("Arial",Font.BOLD,14));
        add(pinText);
        
        login=new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear=new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        
        signUp=new JButton("SIGNUP");
        signUp.setBounds(300, 350, 230, 30);
        signUp.setBackground(Color.black);
        signUp.setForeground(Color.white);
        signUp.addActionListener(this);
        add(signUp);
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(800,450);
        setLocation(350,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardText.setText("");
           pinText.setText("");
        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardText.getText();
            String pinnumber= pinText.getText();
            String query="Select * from login where cardnumber= '"+cardnumber+"' and pin= '"+pinnumber+"' " ;
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
                }
            }catch(Exception e){
              e.printStackTrace();
              JOptionPane.showMessageDialog(this, "Database Error:"+e.getMessage());
            }
//          
        }else if(ae.getSource()==signUp){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }

}
