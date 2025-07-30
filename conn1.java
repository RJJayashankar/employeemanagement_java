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
//            c =DriverManager.getConnection("jdbc:\"jdbcmysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL","root","eviljay_4");    
//            s =c.createStatement();

        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","eviljay_4");  
        //here sonoo is database name, root is username and password  
        s=con.createStatement();  
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}