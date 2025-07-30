/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;



import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class Remove_Employee1 implements ActionListener{
    JFrame f;
    JTextField t;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JButton b,b1,b2,b3;

    Remove_Employee1(){
        f=new JFrame("Remove Employee");
        

        l5=new JLabel();
        l5.setBounds(0,0,500,500);
        l5.setLayout(null);
        f.setLayout(null);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\delete.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.add(l5);

        
        l1=new JLabel("Employee Id");
        l1.setBounds(50,50,250,30);
        l1.setForeground(Color.BLACK);
        Font f2 = new Font("ARIAL",Font.BOLD,25); 
        l1.setFont(f2);
        l5.add(l1);

        t=new JTextField();
        t.setBounds(250,50,150,30);
        l5.add(t);


        b=new JButton("Search");
        b.setBounds(200,100,100,30);
        b.addActionListener(this);
        l5.add(b);
        b.addActionListener(this);

        b3=new JButton("back");
        b3.setBounds(360,100,100,30);   
        b3.addActionListener(this);
        l5.add(b3);


        l2=new JLabel("Name:"); 
        l2.setBounds(50,150,250,30);
        l2.setForeground(Color.BLACK);
        Font f3 = new Font("serif",Font.BOLD,20); 
        l2.setFont(f3);
        l5.add(l2);

        l6=new JLabel();    
        l6.setBounds(200,150,350,30);
        l6.setForeground(Color.BLACK);
        Font F6=new Font("serif",Font.BOLD,20); 
        l6.setFont(F6);
        l5.add(l6);

        l3=new JLabel("Mobile No:");
        l3.setBounds(50,200,250,30);
        l3.setForeground(Color.BLACK);
        Font f4 = new Font("serif",Font.BOLD,20); 
        l3.setFont(f4);
        l5.add(l3);


        l7=new JLabel();
        l7.setBounds(200,200,350,30);
        l7.setForeground(Color.BLACK);
        Font F7=new Font("serif",Font.BOLD,20); 
        l7.setFont(F7);
        l5.add(l7);



        l4=new JLabel("Email Id:");
        l4.setBounds(50,250,250,30);
        l4.setForeground(Color.BLACK);
        Font F5=new Font("serif",Font.BOLD,20); 
        l4.setFont(F5);
        l5.add(l4);

        l8=new JLabel();
        l8.setBounds(200,250,350,30);
        l8.setForeground(Color.BLACK);
        Font f8=new Font("serif",Font.BOLD,20); 
        l8.setFont(f8);
        l5.add(l8);
        
//        l9=new JLabel("Salary :");
//        l9.setBounds(50,250,250,30);
//        l9.setForeground(Color.white);
//        Font F9=new Font("serif",Font.BOLD,20); 
//        l9.setFont(F9);
//        l5.add(l9);

//        l10=new JLabel();
//        l10.setBounds(200,250,350,30);
//        l10.setForeground(Color.white);
//        Font f10=new Font("serif",Font.BOLD,20); 
//        l10.setFont(f10);
//        l5.add(l10);

        b1=new JButton("Remove");
        b1.setBounds(120,300,100,30);
        b1.addActionListener(this);
        l5.add(b1);


        b2=new JButton("Cancel");
        b2.setBounds(300,300,100,30);
        b2.addActionListener(this);
        l5.add(b2);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        b1.setVisible(false);
        b2.setVisible(false);

        f.setSize(500,500);
        f.setLocation(500,250);  
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            try{
                conn1 con = new conn1();
                String str = "select name,phone,email from e_id where id ='"+t.getText()+"' ";
                ResultSet rs = con.s.executeQuery(str);
                System.out.println("rs object >>>>>>>>>>>>>>>>:"+rs);

                int i=0;
                if(rs.next()){
                    String name = rs.getString("name");
                    System.out.println("name >>>>>>>>>>>>>>>>:"+name);
                    String phno = rs.getString("phone");
                    String email=rs.getString("email");

                    l2.setVisible(true);
                    l3.setVisible(true);
                    l4.setVisible(true);
                    b1.setVisible(true);
                    b2.setVisible(true);    
                    i=1;
                    l6.setText(name);
                    l7.setText(phno);
                    l8.setText(email);
                }
                if(i==0)
                    JOptionPane.showMessageDialog(null,"Id not found");
            }catch(Exception ex){}
        }
        if(ae.getSource()==b1){
            try{
                conn1 con = new conn1();
                String str = "delete from e_id where id = '"+t.getText()+"'";
                con.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"deleted successfully");
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);
                l6.setVisible(false);
                l7.setVisible(false);
                l8.setVisible(false);
                b1.setVisible(false);
                b2.setVisible(false);

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception occured while delting record "+ex);
            }
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            details1 d=new details1();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            details1 d=new details1();
        }
    }

    public static void main(String[]ar){
        new Remove_Employee1();
    }
}
