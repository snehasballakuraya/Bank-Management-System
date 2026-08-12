package bank_management_system;

import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class SignUpOne extends JFrame{
    
    SignUpOne(){
        
        setLayout(null);
        
        Random r=new Random();
        long random=Math.abs((r.nextLong() % 9000L) + 1000L);
                
        JLabel formno=new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel pdetails=new JLabel("Page 1: Personal Details");
        pdetails.setFont(new Font("Raleway", Font.BOLD,22));
        pdetails.setBounds(290, 80, 400, 30);
        add(pdetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        JTextField nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD,20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);
        
        JTextField fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300, 190, 400, 30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);
        
        JDateChooser dateChooser=new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(105,105,105));
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD,20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);
        
        JRadioButton male=new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.white);
        add(male);
        
        JRadioButton female=new JRadioButton("Female");
        female.setBounds(450, 290, 70, 30);
        female.setBackground(Color.white);
        add(female);
        
        JRadioButton other=new JRadioButton("Other");
        other.setBounds(600, 290, 70, 30);
        other.setBackground(Color.white);
        add(other);
        
        ButtonGroup genderbg=new ButtonGroup();
        genderbg.add(male);
        genderbg.add(female);
        genderbg.add(other);
        
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD,20));
        email.setBounds(100, 340, 200, 30);
        add(email);
        
        JTextField emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300, 340, 400, 30);
        add(emailTextField);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD,20));
        marital.setBounds(100, 390, 200, 30);
        add(marital);
        
        JRadioButton married=new JRadioButton("Married");
        married.setBounds(300, 390, 70, 30);
        married.setBackground(Color.white);
        add(married);
        
        JRadioButton Unmarried=new JRadioButton("Unmarried");
        Unmarried.setBounds(450, 390, 90, 30);
        Unmarried.setBackground(Color.white);
        add(Unmarried);
        
        JRadioButton others=new JRadioButton("Other");
        others.setBounds(600, 390, 70, 30);
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup maritalbg=new ButtonGroup();
        maritalbg.add(married);
        maritalbg.add(Unmarried);
        maritalbg.add(others);
        
         JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD,20));
        address.setBounds(100, 440, 200, 30);
        add(address);
        
        JTextField addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300, 440, 400, 30);
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,20));
        city.setBounds(100, 490, 200, 30);
        add(city);
        
        JTextField cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300, 490, 400, 30);
        add(cityTextField);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,20));
        state.setBounds(100, 540, 200, 30);
        add(state);
        
        JTextField stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300, 540, 400, 30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Raleway", Font.BOLD,20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);
        
        JTextField pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300, 590, 400, 30);
        add(pinTextField);
        
        JButton button =new JButton("Next");
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Raleway",Font.BOLD,14));
        button.setBounds(570,610,130,40);
        add(button);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
