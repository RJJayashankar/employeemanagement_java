/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;



import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class Add_Employee1 implements ActionListener{

    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id15,id16,id17,lab,lab1;
    JTextField t,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JButton b,b1,b2,b3;

    Add_Employee1(int i){}
    
    Add_Employee1(){
        f = new JFrame("Add Employee");
        f.setBackground(Color.blue);
        f.setLayout(null);
        f.setBackground(Color.white);
        f.setLayout(null);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\add.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        

        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        

        id8 = new JLabel(" Employee Record System : Adding New Employee Details");
        id8.setBounds(100,30,800,50);
        id8.setFont(new Font("ARIAL",Font.BOLD,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);

 
        id1 = new JLabel("Emp. ID :");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Name :");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Father's name :");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);

        id4= new JLabel("Age :");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("DOB :");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);

        id6= new JLabel("Address :");
        id6.setBounds(400,250,100,30);
        id6.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id6);

        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id15.add(t6);

        id7= new JLabel("Phone No.:");
        id7.setBounds(50,300,100,30);
        id7.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id7);

        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id15.add(t7);

        id9= new JLabel("Email ID :");
        id9.setBounds(400,300,100,30);
        id9.setFont(new Font("serif",Font.BOLD,20));    
        id15.add(id9);

        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id15.add(t8);

        id10= new JLabel("Qualification :");
        id10.setBounds(50,350,100,30);
        id10.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id10);

        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id15.add(t9);


        id11= new JLabel("Designation :");
        id11.setBounds(400,350,100,30);
        id11.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id11);

        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id15.add(t10);

        id12= new JLabel("Aadhar No.:");
        id12.setBounds(50,400,150,30);
        id12.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id12);

        t11=new JTextField();   
        t11.setBounds(200,400,150,30);
        id15.add(t11);
        
        id13= new JLabel("Salary :");
        id13.setBounds(400,400,150,30);
        id13.setFont(new Font("serif",Font.BOLD,20));
        id15.add(id13);

        t12=new JTextField();   
        t12.setBounds(600,400,150,30);
        id15.add(t12);
        

        lab=new JLabel();
        lab.setBounds(200,450,250,200);
	id15.add(lab);

        lab1=new JLabel("");
        lab1.setBounds(600,450,250,200);
        id15.add(lab1);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(250,550,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(450,550,150,40);
        
        id15.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        String g = t7.getText();
        String h = t8.getText();
        String i = t9.getText();
        String j = t10.getText();
        String k = t11.getText();
        String l=t12.getText();
        if(ae.getSource() == b){
            try{
                conn1 cc = new conn1();
                //String q = "insert into e_id values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+ff+"','"+i+"','"+h+"','"+l+"','"+j+"','"+k+"','"+g+"')";
                String q = "insert into e_id values('"+a+"','"+bb+"','"+c+"','"+ff+"','"+g+"','"+h+"','"+i+"','"+j+"','"+d+"','"+e+"','"+k+"','"+l+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
                new details1();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new details1();
        }
    }
    public static void main(String args[]){
        new Add_Employee1();
    }
}
