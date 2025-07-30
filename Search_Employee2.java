/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Search_Employee2 extends JFrame {
    private JTextField searchField;
    private JTextArea resultArea;
    private JButton searchButton;
    private JComboBox<String> searchOptions;
    private Connection connection;

    public Search_Employee2() {
        setTitle("Employee Search App");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        searchField = new JTextField(20);
        resultArea = new JTextArea(10, 30);
        searchButton = new JButton("Search");
        String[] options = {"Name", "ID", "Salary","Age"};
        searchOptions = new JComboBox<>(options);

        add(new JLabel("Select search option:\n"));
        add(searchOptions);
        add(new JLabel("\nEnter search term:"));
        add(searchField);
        add(searchButton);
        add(new JScrollPane(resultArea));

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText().trim();
                String selectedOption = (String) searchOptions.getSelectedItem();
                searchEmployee(selectedOption, searchTerm);
            }
        });

         try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "27Janu122004#");
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
                query = "SELECT * FROM employee WHERE name LIKE ?";
                break;
            case "ID":
                query = "SELECT * FROM employee WHERE empid = ?";
                break;
            case "Salary":
                query = "SELECT * FROM employee WHERE salary = ?";
                break;
            case "Age":
                query = "SELECT * FROM employee WHERE age = ?";
                break;
            default:
                break;
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (option.equals("Salary")) {
                preparedStatement.setString(1, searchTerm);
            } else if (option.equals("ID")) {
                System.out.println("ID>");
                System.out.println(searchTerm);
                preparedStatement.setString(1, searchTerm);
            } else {
                preparedStatement.setString(1, searchTerm );
            }

            ResultSet resultSet = preparedStatement.executeQuery();

            StringBuilder result = new StringBuilder();
            while (resultSet.next()) {
                String id = resultSet.getString("empid");
                String empName = resultSet.getString("name");
                String salary = resultSet.getString("salary");
                String age=resultSet.getString("age");
                String designation=resultSet.getString("designation");
                String spes=resultSet.getString("specialisation");

                result.append("\nName: ").append(empName).append("\n Salary: ").append(salary).append("\n").append("Age: ").append(age).append("\n").append("Designation: ").append(designation).append("\n").append("Specialization: ").append(spes).append("\n\n");
            }
            if (result.length() == 0) {
                result.append("No results found.");
            }
            resultArea.setText(result.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    

    public static void main(String[] args) {
        Search_Employee2 s=new Search_Employee2();
        s.setVisible(true);
        
    }
}