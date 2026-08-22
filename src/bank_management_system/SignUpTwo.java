package bank_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JComboBox rel,cat,inco,edhu,occ;
    JTextField panTextField,aadharTextField;
    JRadioButton senioryes,seniorno,existyes,existno;
   JButton next;
   String formno;
    SignUpTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel p2details=new JLabel("Page 2: Additional Details");
        p2details.setFont(new Font("Raleway",Font.BOLD,22));
        p2details.setBounds(290, 80, 400, 30);
        add(p2details);
        
        JLabel religion=new JLabel("Religion: ");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100, 140, 100, 30);
        add(religion);
        
        String valReligion[]={"Please Select Religion","Hindu","Muslim","Christian","Jains","Sikh","others"};
        rel=new JComboBox(valReligion);
        rel.setBounds(300, 140, 400, 30);
        rel.setBackground(Color.WHITE);
        add(rel);
        
        JLabel category=new JLabel("Category: ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(100, 190, 200, 30);
        add(category);
        
        String valcat[]={"Please Select Category","General","SC","ST","OBC","others"};
        cat=new JComboBox(valcat);
        cat.setBounds(300, 190, 400, 30);
        cat.setBackground(Color.WHITE);
        add(cat);
        
        JLabel income=new JLabel("Income: ");
        income.setFont(new Font("Raleway",Font.BOLD,20));
        income.setBounds(100, 240, 200, 30);
        add(income);
        
        String valincome[]={"Please Select Income","Null","< 1,50,000","< 2,50,000","< 5,00,000","upto 10,00,000"};
        inco=new JComboBox(valincome);
        inco.setBounds(300, 240, 400, 30);
        inco.setBackground(Color.WHITE);
        add(inco);
        
        JLabel EQ=new JLabel("Educational ");
        EQ.setFont(new Font("Raleway",Font.BOLD,20));
        EQ.setBounds(100, 290, 200, 30);
        add(EQ);
        
        JLabel Q=new JLabel("Qualification : ");
        Q.setFont(new Font("Raleway",Font.BOLD,20));
        Q.setBounds(100, 315, 200, 30);
        add(Q);
        
        String valedu[]={" ","Non Graduate","Graduate","Post Graduation","Doctrate","Others"};
        edhu=new JComboBox(valedu);
        edhu.setBounds(300, 315, 400, 30);
        edhu.setBackground(Color.WHITE);
        add(edhu);
       
        JLabel occupation=new JLabel("Occupation: ");
        occupation.setFont(new Font("Raleway",Font.BOLD,20));
        occupation.setBounds(100, 390, 200, 30);
        add(occupation);
        
        String valocc[]={" ","Salaried","Self-Employed"," Business","Student","Retired","Others"};
        occ=new JComboBox(valocc);
        occ.setBounds(300, 395, 400, 30);
        occ.setBackground(Color.WHITE);
        add(occ);
        
        JLabel pan=new JLabel("PAN Number: ");
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(100, 440, 200, 30);
        add(pan);
        
        panTextField=new JTextField();
        panTextField.setFont(new Font("Raleway",Font.BOLD,14));
        panTextField.setBounds(300, 440, 400, 30);
        add(panTextField);
        
        
        JLabel aadhar=new JLabel("Aadhar Number: ");
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(100, 490, 200, 30);
        add(aadhar);
        
        aadharTextField=new JTextField();
        aadharTextField.setFont(new Font("Raleway",Font.BOLD,14));
        aadharTextField.setBounds(300, 490, 400, 30);
        add(aadharTextField);
        
        JLabel senior=new JLabel("Senior Citizen: ");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        senioryes=new JRadioButton("Yes");
        senioryes.setBounds(300, 540, 60, 30);
        senioryes.setBackground(Color.white);
        add(senioryes);
        
        seniorno=new JRadioButton("No");
        seniorno.setBounds(450, 540, 60, 30);
        seniorno.setBackground(Color.white);
        add(seniorno);
        
        ButtonGroup sbg=new ButtonGroup();
        sbg.add(senioryes);
        sbg.add(seniorno);
        
        JLabel exist=new JLabel(" Existing Account: ");
        exist.setFont(new Font("Raleway",Font.BOLD,20));
        exist.setBounds(100, 590, 200, 30);
        add(exist);
        
        existyes=new JRadioButton("Yes");
        existyes.setBounds(300, 590, 60, 30);
        existyes.setBackground(Color.white);
        add(existyes);
        
        existno=new JRadioButton("No");
        existno.setBounds(450, 590, 60, 30);
        existno.setBackground(Color.white);
        add(existno);
        
        ButtonGroup ebg=new ButtonGroup();
        ebg.add(existyes);
        ebg.add(existno);
        
        next =new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(570, 625, 130, 40);
        next.addActionListener(this);
        add(next);
           
    getContentPane().setBackground(Color.WHITE);
    
    setSize(850, 720);
    setLocation(350, 10);
    setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String relig=(String)rel.getSelectedItem();
        String categ=(String)cat.getSelectedItem();
        String incom=(String)inco.getSelectedItem();
        String educate=(String)edhu.getSelectedItem();
        String occupate=(String)occ.getSelectedItem();
        String panno=panTextField.getText();
        String aadh=aadharTextField.getText();
        String senioryon=null;
        if(senioryes.isSelected()){
            senioryon="yes";
        }else if(seniorno.isSelected()){
            senioryon="No";
        }
        String Existyon=null;
        if(existyes.isSelected()){
            Existyon="Yes";
        }else if(existno.isSelected()){
            Existyon="No";
        }
         try{
          
              Conn c=new Conn();
              String query="insert into signuptwo values('"+formno+"','"+relig+"','"+categ+"','"+incom+"','"+educate+"', '"+occupate+"','"+panno+"','"+aadh+"','"+senioryon+"','"+Existyon+"')";
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(this, "Page 2 details submitted successfully!");
              new SignUpThree(formno).setVisible(true);
      }catch(Exception e){
          e.printStackTrace();
          JOptionPane.showMessageDialog(this, "Database Error:"+e.getMessage());
      }
        
        
    }
    
    public static void main(String[] args) {
        new SignUpTwo("");
    }
   
    }
