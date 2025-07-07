package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, minstatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;
              
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(145, 220, 500, 35);
        image.add(text);
        
        deposit = new JButton("Rs 100");
        deposit.setBounds(140, 322, 112, 22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(280, 322, 112, 22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(140, 349, 112, 22);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        minstatement = new JButton("Rs 2000");
        minstatement.setBounds(280, 349, 112, 22);
        minstatement.addActionListener(this);
        image.add(minstatement);
        
        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(140, 375, 112, 22);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("10000");
        balanceenquiry.setBounds(280, 375, 112, 22);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("BACK");
        exit.setBounds(280, 402, 112, 22);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()) {
                    if(rs.getString("type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if (ae.getSource() != exit && balance < Integer.parseInt(amount)) {
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+ amount + "Debited Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } 
    }

    public static void main(String args[]) {
        new FastCash("");
    }
    
}
