/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;

import java.sql.*;

public class conn2{
    
    public Connection c;
    public Statement s;
 
    public conn2(){
        try{
            Class.forName("com.mysql.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:\"jdbcmysql://localhost:3306/ems?zeroDateTimeBehavior=CONVERT_TO_NULL","root","eviljay_4");    
            s =c.createStatement();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}