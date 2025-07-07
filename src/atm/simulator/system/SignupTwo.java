package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField pan, aadhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occupation, education, income;
    String formno;

    SignupTwo(String formno) {
        this.formno = formno;
        
        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        JLabel additionalDetails = new JLabel("Page 1: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        JLabel sreligion = new JLabel("Religion:");
        sreligion.setFont(new Font("Raleway", Font.BOLD, 20));
        sreligion.setBounds(100, 140, 100, 30);
        add(sreligion);
        
        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        JLabel scategory = new JLabel("Category:");
        scategory.setFont(new Font("Raleway", Font.BOLD, 20));
        scategory.setBounds(100, 190, 200, 30);
        add(scategory);
        
        String valcategory[] = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);        
        
        JLabel sincome = new JLabel("Income:");
        sincome.setFont(new Font("Raleway", Font.BOLD, 20));
        sincome.setBounds(100, 240, 200, 30);
        add(sincome);
        
        String incomecategory[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);    
        
        JLabel seducation = new JLabel("Educational:");
        seducation.setFont(new Font("Raleway", Font.BOLD, 20));
        seducation.setBounds(100, 290, 200, 30);
        add(seducation);
        
        JLabel qvalue = new JLabel("Qualification:");
        qvalue.setFont(new Font("Raleway", Font.BOLD, 20));
        qvalue.setBounds(100, 315, 200, 30);
        add(qvalue);
        
        String educationvalues[] = {"Non-Graduate", "Graduation", "Post-Graduation", "Doctrate", "Others"};
        education = new JComboBox(educationvalues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);  
        
        JLabel soccupation = new JLabel("Occupation:");
        soccupation.setFont(new Font("Raleway", Font.BOLD, 20));
        soccupation.setBounds(100, 390, 200, 30);
        add(soccupation);
        
        String occupationvalues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Others"};
        occupation = new JComboBox(occupationvalues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);  
       
        JLabel span = new JLabel("PAN Number:");
        span.setFont(new Font("Raleway", Font.BOLD, 20));
        span.setBounds(100, 440, 200, 30);
        add(span);
        
        pan = new JTextField();
        pan.setBounds(300, 440, 400, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        add(pan);
        
        JLabel saadhar = new JLabel("Aadhar Number:");
        saadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        saadhar.setBounds(100, 490, 200, 30);
        add(saadhar);
        
        aadhar = new JTextField();
        aadhar.setBounds(300, 490, 400, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 14));
        add(aadhar);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorcitizen.setBounds(100, 540, 200, 30);
        add(seniorcitizen);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup citizengroup = new ButtonGroup();
        citizengroup.add(syes);
        citizengroup.add(sno);
        
        JLabel existingaccount = new JLabel("Existing Account:");
        existingaccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingaccount.setBounds(100, 590, 200, 30);
        add(existingaccount);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup accountgroup = new ButtonGroup();
        accountgroup.add(eyes);
        accountgroup.add(eno);
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();
        String seniorcitizen = null;
        if (syes.isSelected()) {
            seniorcitizen = "Yes";
           
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }
   
        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";
        } else if (eno.isSelected()) {
            existingaccount = "No";
        } 
        
        String span = pan.getText();
        String saadhar = aadhar.getText();   
           
       try{
               Conn c = new Conn();
               String query = "insert into signuptwo values('"+formno+"', '"+sreligion+"', '"+scategory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhar+"', '"+seniorcitizen+"', '"+existingaccount+"')";
               c.s.executeUpdate(query);
               
               //Signup3 Object
               setVisible(false);
               new SignupThree(formno).setVisible(true);
       } catch (Exception e) {
           System.out.println(e);
       }
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
    }
    
}

