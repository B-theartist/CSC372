package com.csuglobal.csc372.module3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class UserInterface extends JFrame {

    private JTextArea textArea;

    public UserInterface() {
        setTitle("User Interface Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        textArea = new JTextArea();
        textArea.setOpaque(true);
        add(textArea, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);


        JMenu menu = new JMenu("Options");
        menuBar.add(menu);

        JMenuItem dateTimeItem = new JMenuItem("Show Date and Time");
        JMenuItem saveItem = new JMenuItem("Save to log.txt");
        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        JMenuItem exitItem = new JMenuItem("Exit");

        menu.add(dateTimeItem);
        menu.add(saveItem);
        menu.add(changeColorItem);
        menu.add(exitItem);

        dateTimeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDateTime();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void showDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        textArea.setText(now.format(formatter));
    }

    private void saveToFile() {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write(textArea.getText() + "\n");
            JOptionPane.showMessageDialog(this, "Text saved to log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeBackgroundColor() {
        Random rand = new Random();
        float hue = 120.0f / 360; 
        float saturation = rand.nextFloat() * 0.5f + 0.5f; 
        float brightness = rand.nextFloat() * 0.5f + 0.5f; 
        Color color = Color.getHSBColor(hue, saturation, brightness);
        getContentPane().setBackground(color);
        textArea.setBackground(color);
        JOptionPane.showMessageDialog(this, String.format("Background color changed to HSB (%.2f, %.2f, %.2f)", hue, saturation, brightness));
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }
}