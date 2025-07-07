package atm.simulator.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField pin, repin;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 700);
        add(image);
        
        JLabel text = new JLabel("Change your PIN");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        text.setBounds(200, 220, 500, 35);
        image.add(text);
        
        JLabel pintext = new JLabel("New PIN");
        pintext.setFont(new Font("System", Font.BOLD, 14));
        pintext.setForeground(Color.WHITE);
        pintext.setBounds(130, 260, 130, 20);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(270, 260, 130, 20);
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(pin);
        
        JLabel repintext = new JLabel("Re-Enter New PIN");
        repintext.setFont(new Font("System", Font.BOLD, 14));
        repintext.setForeground(Color.WHITE);
        repintext.setBounds(130, 290, 140, 20);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(270, 290, 130, 20);
        repin.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(repin);
        
        change = new JButton("CHANGE");
        change.setBounds(300, 370, 100, 25);
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(300, 400, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "Update bank set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query2 = "Update login set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                String query3 = "Update signupthree set pin = '"+rpin+"' where pin='"+pinnumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                
                setVisible(false);
                new Transactions(rpin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String args[]) {
        new PinChange("").setVisible(true);
     
    }
    
}
