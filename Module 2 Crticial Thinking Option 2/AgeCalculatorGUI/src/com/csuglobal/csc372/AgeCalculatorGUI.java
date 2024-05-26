package com.csuglobal.csc372;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.Period;

public class AgeCalculatorGUI extends JFrame implements ActionListener {
    private JTextField birthDateField;
    private JLabel resultLabel;
    
    public AgeCalculatorGUI() {
        setTitle("Age Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        
        JLabel birthDateLabel = new JLabel("Enter Birth Date (MM-DD-YYYY):");
        birthDateField = new JTextField();
        JButton calculateButton = new JButton("Calculate Age");
        resultLabel = new JLabel("Your age will be displayed here.");
        
        calculateButton.addActionListener(this);
        
        // Add components to panel
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(calculateButton);
        panel.add(resultLabel);
        
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String birthDateStr = birthDateField.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        try {
            LocalDate birthDate = LocalDate.parse(birthDateStr, formatter);
            LocalDate currentDate = LocalDate.now();
            int age = Period.between(birthDate, currentDate).getYears();
            resultLabel.setText("You are " + age + " years old.");
        } catch (DateTimeParseException ex) {
            resultLabel.setText("Invalid date format. Please use MM-DD-YYYY.");
        }
    }
    
    public static void main(String[] args) {
        new AgeCalculatorGUI();
    }
}

