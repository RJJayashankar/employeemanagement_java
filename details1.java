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
import javax.imageio.ImageIO;

class details1  implements ActionListener{

    JFrame f;
    JLabel l1,l2;
    JButton b1,b2,b3,b4,b5;

    details1(){
        f=new JFrame("Employee Detail");
        f.setBackground(Color.white);
        f.setLayout(null);

        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        try {
            f.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\Bhara\\OneDrive\\Documents\\java pics\\ems4.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        f.add(l1);

        l2 = new JLabel("Employee Record System Dashboard");
        l2.setBounds(100,20,900,40);
        l2.setFont(new Font("arial",Font.BOLD,25));
        l2.setForeground(Color.blue);
        l1.add(l2);

        b1=new JButton("Add Employee");
        b1.setBounds(300,80,140,40);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        l1.add(b1);


        b2=new JButton("Search Employee");
        b2.setBounds(460,80,140,40);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.addActionListener(this);
        l1.add(b2);

        b3=new JButton("Remove Employee");
        b3.setBounds(300,140,140,40);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.addActionListener(this);
        l1.add(b3);

        b4=new JButton("Update Employee");
        b4.setBounds(460,140,140,40);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.addActionListener(this);
        l1.add(b4);
        
//        b5=new JButton("search Employee");
//        b5.setBounds(460,140,140,40);
//        b5.setFont(new Font("serif",Font.BOLD,15));
//        b5.addActionListener(this);
//        l1.add(b5);

        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            f.setVisible(false);
            new Add_Employee1();
        }
        if(ae.getSource()==b2){
            f.setVisible(false);
            new search();
        }
        if(ae.getSource()==b3){
            f.setVisible(false);
            new Remove_Employee1();
        }
        if(ae.getSource()==b4){
            f.setVisible(false);
            new EnterEmployeeToUpdate();
        
        }
       //if(ae.getSource()==b5){
       //     f.setVisible(false);
     //      new search();
   // }
    }

    public static void main(String[ ] arg){
        details1 d = new details1();
    }
}

