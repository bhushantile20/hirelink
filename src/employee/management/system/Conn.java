package employee.management.system;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;

    public Conn () {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");    //Register the Driver class
            c = DriverManager.getConnection("jdbc:mysql:///employeemanagementsystem", "root", "rohitjha");  //Creating the connection string
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}