/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.bnmit.ems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployeeDetailsGUI extends JFrame implements ActionListener {
    private JTextField idField, nameField, fatherNameField, addressField, phoneField, emailField, educationField,
            postField, ageField, dobField, aadharNoField, salaryField;
    private JButton updateButton;

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/ems";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "eviljay_4";

    public UpdateEmployeeDetailsGUI() {
        setTitle("Update Employee Details");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(14, 2));

        add(new JLabel("Employee ID:"));
        idField = new JTextField();
        add(idField);

        add(new JLabel("New Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Father's Name:"));
        fatherNameField = new JTextField();
        add(fatherNameField);

        add(new JLabel("Address:"));
        addressField = new JTextField();
        add(addressField);

        add(new JLabel("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Education:"));
        educationField = new JTextField();
        add(educationField);

        add(new JLabel("Post:"));
        postField = new JTextField();
        add(postField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Date of Birth (YYYY-MM-DD):"));
        dobField = new JTextField();
        add(dobField);

        add(new JLabel("Aadhar Number:"));
        aadharNoField = new JTextField();
        add(aadharNoField);

        add(new JLabel("New Salary:"));
        salaryField = new JTextField();
        add(salaryField);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        add(updateButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == updateButton) {
            String employeeId = idField.getText();
            String newName = nameField.getText();
            String newFatherName = fatherNameField.getText();
            String newAddress = addressField.getText();
            String newPhone = phoneField.getText();
            String newEmail = emailField.getText();
            String newEducation = educationField.getText();
            String newPost = postField.getText();
            int newAge = Integer.parseInt(ageField.getText());
            String newDob = dobField.getText();
            String newAadharNo = aadharNoField.getText();
            double newSalary = Double.parseDouble(salaryField.getText());

            try (
                    // Establishing a connection to the database
                    Connection connection = DriverManager.getConnection("jdbc:\"jdbcmysql://localhost:3306/ems","root","eviljay_4");

                    // Creating a PreparedStatement object for the SQL query
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE employees SET name = ?, father_name = ?, address = ?, phone = ?, email = ?, education = ?, post = ?, age = ?, dob = ?, aadhar_no = ?, salary = ? WHERE id = ?")
            ) {
                // Setting parameters for the PreparedStatement
                preparedStatement.setString(1, newName);
                preparedStatement.setString(2, newFatherName);
                preparedStatement.setString(3, newAddress);
                preparedStatement.setString(4, newPhone);
                preparedStatement.setString(5, newEmail);
                preparedStatement.setString(6, newEducation);
                preparedStatement.setString(7, newPost);
                preparedStatement.setInt(8, newAge);
                preparedStatement.setString(9, newDob);
                preparedStatement.setString(10, newAadharNo);
                preparedStatement.setDouble(11, newSalary);
                preparedStatement.setString(12, employeeId);

                // Executing the update operation
                int rowsAffected = preparedStatement.executeUpdate();

                // Checking if the update was successful
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Employee details updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "No employee found with the given ID.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error occurred while updating employee details.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new UpdateEmployeeDetailsGUI();
            }
        });
    }
}
