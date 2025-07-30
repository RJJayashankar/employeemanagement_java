/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 *
 * @author Jayashankar Jayaram
 */
public class EnterEmployeeToUpdate extends JFrame implements ActionListener{
    
    JFrame f;
    //JPanel jp;
    JLabel l;
    JTextField tf;
    JButton b;
    
    public EnterEmployeeToUpdate() {
        f = new JFrame();
        //jp = new JPanel();
        f.setTitle("Employee ID to update");
        f.setSize(250, 100);
        
        //f.setLayout(new GridLayout(1, 3));
        f.setLayout(new GridLayout(1,3));
        f.setVisible(true);
        //f.setSize(900,700);
        //f.setLocation(400,150);
        //f.setLocation(450,250);    
        
        l = new JLabel("Enter Id");
        //l.setBounds(0,30,50,30);
        l.setFont(new Font("serif",Font.BOLD,20));
        tf=new JTextField();
        //tf.setBounds(100,30,150,30);
        b = new JButton("Submit");
        //b.setBounds(450,550,150,40);
        b.addActionListener(this);
        f.add(l);
        f.add(tf);
        f.add(b);
        //f.add(jp);
    }
    
       
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b){
            new Update_Employee1(tf.getText());
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        
    }
    
}
