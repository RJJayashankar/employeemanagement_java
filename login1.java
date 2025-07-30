/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;



import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import javax.imageio.ImageIO;

class login1  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;

    login1(){

        f=new JFrame("Login");

        f.setBackground(Color.white);
        f.setLayout(null);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\login.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        l1 = new JLabel("Username");
        l1.setBounds(150,70,100,30);
        f.add(l1);
        
        l2 = new JLabel("Password");
        l2.setBounds(150,110,100,30);
        f.add(l2);
 
        t1=new JTextField();
        t1.setBounds(250,70,150,30);
        f.add(t1);

        t2=new JPasswordField();
        t2.setBounds(250,110,150,30);
        f.add(t2);
        
        


        b1 = new JButton("Login");
        b1.setBounds(140,180,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(280,180,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
      //  b3=new JButton("Sign-up");
        //b3.setBounds(200,220,120,30);
       // b3.setFont(new Font("serif",Font.BOLD,15));
       // b3.setBackground(Color.BLACK);
        //b3.setForeground(Color.WHITE);
        //f.add(b3);

        //b3.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(600,300);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ae){

        try{
            conn1 c1 = new conn1();
            String username = t1.getText();
            String password = t2.getText();
            
            String q = "select * from login where username='"+username+"' and password='"+password+"'";
            
            ResultSet rs = c1.s.executeQuery(q); 
            if(rs.next()){
                new details1().f.setVisible(true);
                f.setVisible(false);
            }else if(ae.getSource()==b3)
            {
                JOptionPane.showMessageDialog(null, "opening signup page");
                new Signup();
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                f.setVisible(false);
                new Front_Page1();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        login1 l=new login1();
    }
}
