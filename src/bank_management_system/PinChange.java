package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    public PinChange(String pinnumber) {
    this.pinnumber=pinnumber;
    setLayout(null);
    
    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atmlogo1.jpeg"));
    Image i2=i1.getImage().getScaledInstance(850, 720, Image.SCALE_DEFAULT);
    ImageIcon i3=new ImageIcon(i2);
    JLabel image=new JLabel(i3);
    image.setBounds(0, 0, 850, 720);
    add(image);
    
    JLabel text=new JLabel("CHANGE YOUR PIN");
    text.setForeground(Color.BLACK);
    text.setFont(new Font("System",Font.BOLD,16));
    text.setBounds(290, 110, 500, 35);
    image.add(text);
    
    JLabel pintext=new JLabel("NEW PIN:");
    pintext.setForeground(Color.BLACK);
    pintext.setFont(new Font("System",Font.BOLD,15));
    pintext.setBounds(230, 160, 500, 35);
    image.add(pintext);
    
    pin =new JPasswordField();
    pin.setFont(new Font("Raleway",Font.BOLD,20));
    pin.setBounds(310, 160, 200, 35);
    image.add(pin);
    
    JLabel repintext=new JLabel("RE-ENTER:");
    repintext.setForeground(Color.BLACK);
    repintext.setFont(new Font("System",Font.BOLD,15));
    repintext.setBounds(230, 210, 500, 35);
    image.add(repintext);
    
    repin =new JPasswordField();
    repin.setFont(new Font("Raleway",Font.BOLD,20));
    repin.setBounds(320, 210, 190, 35);
    image.add(repin);
    
    change=new JButton("CHANGE");
    change.setBounds(240, 300, 100, 35);
    change.addActionListener(this);
    image.add(change);
    
    back=new JButton("BACK");
    back.setBounds(390, 300, 100, 35);
    back.addActionListener(this);
    image.add(back);
    
    
    setSize(850, 720);
    setLocation(350, 0);
        setUndecorated(true);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
        
        try{
            String npin=pin.getText();
            String rpin=repin.getText();
            
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                return;
            }
            
            if(npin.equals("")){
                JOptionPane.showMessageDialog(null, " Please enter the PIN ");
                return;
            }
            
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null, " Please re-enter new PIN ");
                return;
            }
            
            Conn conn=new Conn();
            String query1="Update bank set pin='"+rpin+"' where pin='"+pinnumber+"'";
            String query2="Update login set pin='"+rpin+"' where pin='"+pinnumber+"'";
            String query3="Update signupthree set pin='"+rpin+"' where pin='"+pinnumber+"'";
            
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
            
            setVisible(false);
            new Transactions(rpin).setVisible(true);
            
        }catch(Exception ae){
            System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
         new PinChange("").setVisible(true);
    }

    
   
}
