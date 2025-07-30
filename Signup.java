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

class Signup  implements ActionListener{

    JFrame f;
    JLabel l1,l2,id1,id2,id3,id4,id5;
    JTextField t1,t2,t3;
    JButton b1,b2;

    Signup(){

        f=new JFrame("Signup");

        f.setBackground(Color.white);
        f.setLayout(null);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\login.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        id5=new JLabel();
        id5.setBounds(0,0,600,700);
        id5.setLayout(null);        
        
        
        id4 = new JLabel("Sign-up");
        id4.setBounds(200,20,100,50);
        id4.setFont(new Font("ARIAL",Font.BOLD,25));
        id4.setForeground(Color.black);
        id5.add(id4);
        f.add(id5);
        
        id1 = new JLabel("username");
        id1.setBounds(50,85,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id5.add(id1);

        t1=new JTextField();
        t1.setBounds(200,85,150,30);
        id5.add(t1);
        
        id2 = new JLabel("phone number");
        id2.setBounds(50,125,100,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id5.add(id2);

        t2=new JTextField();
        t2.setBounds(200,125,150,30);
        id5.add(t2);
        
        id3 = new JLabel("password");
        id3.setBounds(50,165,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id5.add(id3);

        t3=new JTextField();
        t3.setBounds(200,165,150,30);
        id5.add(t3);

        
        b1 = new JButton("Signup");
        b1.setBounds(130,230,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.gray);
        b1.setForeground(Color.WHITE);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(280,230,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.gray);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        b2.addActionListener(this);
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(500,400);
        f.setLocation(400,300);
    }

    public void actionPerformed(ActionEvent ae){
        String username = t1.getText();
        String phone = t2.getText();
        String password=t3.getText();
        if(ae.getSource()==b2)
        {
            f.setVisible(false);
            login1 l=new login1();
        }
        if(ae.getSource() == b1){
            try{
                conn1 cc = new conn1();
                String q = "insert into login values('"+username+"','"+password+"','"+phone+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new login1();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
    }
    public static void main(String args[]){
        Signup s=new Signup();
    }
}
