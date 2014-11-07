/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daily_diary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author priyanja
 */
public class Database_Server {
     static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost/Daily_diary";
    
    static final String USER="root";
    static final String PASS="";
    
    static Connection conn=null;
    static Statement stmt=null;
    
    public void Start_Connection() throws SQLException, ClassNotFoundException{
    
        Class.forName("com.mysql.jdbc.Driver");
    
        System.out.println("Connecting to database");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);    
        stmt=conn.createStatement();
        System.out.println("Connection Established");
        
    
    }
}
