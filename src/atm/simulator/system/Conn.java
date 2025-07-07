package atm.simulator.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulatorsystem", "root", "Priya@2003");
            s = c.createStatement();
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}

   
