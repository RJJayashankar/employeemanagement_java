/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class search extends JFrame {
    JFrame f;
    //JButton b5;
    private JTextField searchField;
    private JTextArea resultArea;
    private JButton searchButton;
    private JComboBox<String> searchOptions;
    private Connection connection;

    public search() {
        
        f = new JFrame();
        f.setTitle("Search Employee");
        f.setSize(400, 300);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());
        f.setVisible(true);
        //f.setSize(900,700);
        f.setLocation(400,150);

//        setTitle("Search Employee");
//        setSize(400, 300);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        setLayout(new FlowLayout());

        searchField = new JTextField(20);
        resultArea = new JTextArea(10, 30);
        searchButton = new JButton("Search");
        String[] options = {"Name", "ID", "Salary"};
        searchOptions = new JComboBox<>(options);
        
//        f.setVisible(true);
//        f.setSize(900,700);
//        f.setLocation(400,150);

        f.add(new JLabel("Select search option:"));
        f.add(searchOptions);
        f.add(new JLabel("Enter search term:"));
        f.add(searchField);
        f.add(searchButton);
        f.add(new JScrollPane(resultArea));

        //add(new JLabel("Select search option:"));
        //add(searchOptions);
//        add(new JLabel("Enter search term:"));
//        add(searchField);
//        add(searchButton);
//        add(new JScrollPane(resultArea));
        //add(f);

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().trim();
                String selectedOption = (String) searchOptions.getSelectedItem();
                searchEmployee(selectedOption, searchTerm);
            }
        });

        // Connect to the database
         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems", "root", "eviljay_4");
            System.out.println("Database connection established successfully.");
        } catch (ClassNotFoundException ex) {
            System.err.println("Failed to load JDBC driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.err.println("Failed to connect to the database: " + ex.getMessage());
        }
    }

    private void searchEmployee(String option, String searchTerm) {
        String query = "";
        switch (option) {
            case "Name":
                query = "SELECT * FROM e_id WHERE name LIKE ?";
                break;
            case "ID":
                query = "SELECT * FROM e_id WHERE id = ?";
                break;
            case "Salary":
                query = "SELECT * FROM e_id WHERE salary = ?";
                break;
            default:
                break;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (option.equals("Salary")) {
                preparedStatement.setString(1, searchTerm);
            } else if (option.equals("ID")) {
                System.out.println("ID>>>>>>>");
                System.out.println(searchTerm);
                preparedStatement.setString(1, searchTerm);
            } else {
                preparedStatement.setString(1, searchTerm );
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String empName = resultSet.getString("name");
                String salary = resultSet.getString("salary");

                result.append("ID: ").append(id).append(", Name: ").append(empName).append(", Salary: ").append(salary).append("\n");
            }
            if (result.length() == 0) {
                result.append("No results found.");
            }
            resultArea.setText(result.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==b5){
//            f.setVisible(false);
//            details1 d=new details1();
//        }
//    }

    public static void main(String[] args) {
        search s=new search();
            new search().setVisible(true);
        
    }
}
