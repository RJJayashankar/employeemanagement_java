/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;

import java.sql.*;

public class conn1{
    
    public Connection c;
    public Statement s;
 
    public conn1(){
        try{
//            Class.forName("com.mysql.cj.jdbc.Driver");  
//            c =DriverManager.getConnection("");    
//            s =c.createStatement();

        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("your connection url,password");  
        //here sonoo is database name, root is username and password  
        s=con.createStatement();  
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
