package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pinnumber;
    
    Deposit(String pinnumber) {
        this.pinnumber = pinnumber;
         setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel("Enter amount you want to deposit");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(135, 220, 500, 35);
        image.add(text);
        
        amount = new JTextField();
        amount.setBounds(135, 270, 260, 20);
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(280, 375, 112, 22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back = new JButton("Back");
        back.setBounds(280, 402, 112, 22);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == deposit) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter amount you want to deposit");               
            } else {
                try {       
                   Conn conn = new Conn();
                   String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Deposit', '"+number+"')";
                   conn.s.executeUpdate(query);
                   JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Successfully");
                   setVisible(false);
                   new Transactions(pinnumber).setVisible(true);
                 } catch (Exception e) {
                     System.out.println(e);
                 }
            }
      
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
      new Deposit("");
    }
    
}
