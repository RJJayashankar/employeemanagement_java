/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class View_Employee1 implements ActionListener{

    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;

    View_Employee1(){
        f=new JFrame("View");
        f.setBackground(Color.gray);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,500,500);
        l1.setLayout(null);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\update1.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.add(l1);


        l2=new JLabel("Employee Id");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
        l2.setForeground(Color.red);
        Font F1 = new Font("serif",Font.BOLD,30);
        l2.setFont(F1); 
        l1.add(l2);
        


        t=new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);

        b=new JButton("Search");
        b.setBounds(240,150,100,30);
        b.addActionListener(this);
        l1.add(b);

        b2=new JButton("Cancel");
        b2.setBounds(360,150,100,30);
        b2.addActionListener(this);
        l1.add(b2);

        f.setSize(500,270);
        f.setLocation(450,250);
        f.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource()==b2){
            f.setVisible(false);
            details1 d=new details1();
        }
        if(ae.getSource()==b){
            f.setVisible(false);
            Print_Data1 p=new Print_Data1(t.getText());
        }

    }

    public static void main(String[]ar){
        View_Employee1 v=new View_Employee1();
    }
}
