package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, minstatement, pinchange, balanceenquiry, exit;
    String pinnumber;
    
    Transactions(String pinnumber) {
        this.pinnumber = pinnumber;
              
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(145, 220, 500, 35);
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(140, 322, 112, 22);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(280, 322, 112, 22);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("Fast cash");
        fastcash.setBounds(140, 349, 112, 22);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        minstatement = new JButton("Minstatement");
        minstatement.setBounds(280, 349, 112, 22);
        minstatement.addActionListener(this);
        image.add(minstatement);
        
        pinchange = new JButton("Pin change");
        pinchange.setBounds(140, 375, 112, 22);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry = new JButton("Bal Enquiry");
        balanceenquiry.setBounds(280, 375, 112, 22);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(280, 402, 112, 22);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == exit) {
            System.exit(0);
        } else if (ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        } else if (ae.getSource() == withdrawl) {
            setVisible(false);
            new Withdrawl(pinnumber).setVisible(true);
        } else if (ae.getSource() == fastcash) {
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if (ae.getSource() == pinchange) {
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        } else if (ae.getSource() == balanceenquiry) {
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        } else if (ae.getSource() == minstatement) {
            new MinStatement(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new Transactions("");
    }
    
}
