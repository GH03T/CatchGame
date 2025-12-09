package com.example.ui.view;

// Import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class BattleSubframe {
    // INSTANCE VARIABLES
    private JFrame frame;
    private JPanel panel;
    private JButton catchButton;
    private JButton escapeButton; // escapes battle

    // CONSTRUCTOR
    public BattleSubframe() {
        FlatLightLaf.setup();

        // Configure Frame
        frame = new JFrame();
        frame.setTitle("Battle!");
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(360, 120));

        // JButtons
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        catchButton = new JButton("Catch!");
        escapeButton = new JButton("Escape!");

        panel.add(catchButton);
        panel.add(escapeButton);

        frame.add(panel);

        // Final Configuration
        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    // METHODS
    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    public void catchButton_addActionListener(ActionListener listener) {
        catchButton.addActionListener(listener);
    } 

    public void escapeButton_addActionListener(ActionListener listener) {
        escapeButton.addActionListener(listener);
    }
}