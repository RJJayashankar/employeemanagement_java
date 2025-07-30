/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;


import java.awt.*;
import javax.swing.*;
import java.lang.Thread;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class Front_Page1 implements ActionListener{
    JFrame f; //declaration
    JLabel id,l1;
    JButton b;

    Front_Page1(){
 
        f=new JFrame("Employee Management System");
        f.setBackground(Color.red);
        f.setLayout(null);
        l1=new JLabel();
        
        l1.setBounds(0,0,800,500);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\update.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.add(l1);


        b = new JButton("CLICK HERE TO CONTINUE");
        b.setFont(new Font("serif",Font.BOLD,15));
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLACK);
        

        b.setBounds(200,400,300,30);
        b.addActionListener(this);

        id=new JLabel();
        id.setBounds(0,0,1000,500);
        id.setLayout(null);
        
   

        JLabel lid=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        lid.setBounds(50,30,1500,100);
        lid.setFont(new Font("arial",Font.PLAIN,40));
        lid.setForeground(Color.BLACK);
        id.add(lid);
        
        JLabel lid1=new JLabel(" Developed by team ems");
        lid1.setBounds(80,85,1500,100); 
        lid1.setFont(new Font("arial",Font.PLAIN,25));
        lid1.setForeground(Color.BLACK);
        id.add(lid1);
        
        
        id.add(b);
        f.add(id);
        
        
        f.getContentPane().setBackground(Color.WHITE);

        f.setVisible(true);
        f.setSize(800,500);
        f.setLocation(200,100);

        /*while(true){
            lid.setVisible(false); // lid =  j label
            try{
                Thread.sleep(500); //1000 = 1 second
            }catch(Exception e){} 
            lid.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){}
        }*/

    }
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b){
            f.setVisible(false);
            new login1();    
        }
    }

    public static void main(String[] arg){
        Front_Page1 of = new Front_Page1();
    }
}