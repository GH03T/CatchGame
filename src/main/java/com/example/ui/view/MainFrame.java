package com.example.ui.view;

// Import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public class MainFrame {
    // INSTANCE VARIABLES
    private static final String VERSION = "v1.0.0";

    private BattleSubframe battleFrame;
    private DialogBox dexDialogBox;
    private DialogBox teamDialogBox;

    private JButton enterButton;
    private JButton battleButton;
    private JButton teamButton;
    private JButton dexButton;

    private JLabel displayLabel;

    private JTextField inputField;

    private JFrame frame;

    private JPanel panel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    
    private BoxLayout boxLayout;

    // CONSTRUCTOR
    public MainFrame() {
        FlatLightLaf.setup(); // Set Look and Feel

        setupFrame();

        battleFrame = new BattleSubframe();
        dexDialogBox = new DialogBox();
        teamDialogBox = new DialogBox();
    }

    private void setupFrame() {
        // Configure JFrame
        frame = new JFrame();
        frame.setTitle("Boblet's Factory Finding - " + VERSION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setPreferredSize(new Dimension(480, 240));

        // Setup JPanel
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Display Label (JLabel)
        displayLabel = new JLabel("", SwingConstants.CENTER); 
        panel.add(displayLabel, BorderLayout.CENTER);

        // Top Toolbar (JPanel)
        topPanel = new JPanel();
        
        battleButton = new JButton("Catch a Boblet");
        teamButton = new JButton("View Team");
        dexButton = new JButton("View BobbeDex");

        topPanel.add(battleButton);
        topPanel.add(teamButton);
        topPanel.add(dexButton);

        topPanel.setVisible(false);

        panel.add(topPanel, BorderLayout.NORTH);

        // Bottom Toolbar (JPanel)
        bottomPanel = new JPanel();
        boxLayout = new BoxLayout(bottomPanel, BoxLayout.X_AXIS);
        bottomPanel.setLayout(boxLayout);

        inputField = new JTextField();
        enterButton = new JButton("Enter");

        bottomPanel.add(inputField);
        bottomPanel.add(enterButton);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        // Final Configuration
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
    }

    // METHODS

    /* Main Frame */
    public void setVisible(boolean b) {
        frame.setVisible(b);
    }

    public void addWindowListener(WindowListener listener) {
        frame.addWindowListener(listener);
    }

    /* Display Label */
    public String displayLabel_getText() {
        return displayLabel.getText();
    }

    public void displayLabel_setText(String text) {
        displayLabel.setText(text);
    }

    /* Top Toolbar */
    public void topPanel_setVisible(boolean b) {
        topPanel.setVisible(b);
    }

    public void battleButton_addActionListener(ActionListener listener) {
        battleButton.addActionListener(listener);
    }

    public void teamButton_addActionListener(ActionListener listener) {
        teamButton.addActionListener(listener);
    }

    public void dexButton_addActionListener(ActionListener listener) {
        dexButton.addActionListener(listener);
    }

    /* Bottom Toolbar */
    public void bottomPanel_setVisible(boolean b) {
        bottomPanel.setVisible(b);
    }

    public String inputField_getText() {
        return inputField.getText();
    }

    public void inputField_setText(String text) {
        inputField.setText(text);
    }

    public void inputField_addActionListener(ActionListener listener) {
        inputField.addActionListener(listener);
    }

    public void enterButton_addActionListener(ActionListener listener) {
        enterButton.addActionListener(listener);
    }

    /* Battle Frame */
    public void battleFrame_setVisible(boolean b) {
        battleFrame.setVisible(b);
    }

    public void battleFrame_catchButton_addActionListener(ActionListener listener) {
        battleFrame.catchButton_addActionListener(listener);
    }

    public void battleFrame_escapeButton_addActionListener(ActionListener listener) {
        battleFrame.escapeButton_addActionListener(listener);
    }

    /* Dialog Box - Dex */
    public void dexDialogBox_setVisible(boolean b) {
        dexDialogBox.setVisible(b);
    }

    public void dexDialogBox_setText(String text) {
        dexDialogBox.setText(text);
    }

    /* Dialog Box - Team */
    public void teamDialogBox_setVisible(boolean b) {
        teamDialogBox.setVisible(b);
    }

    public void teamDialogBox_setText(String text) {
        teamDialogBox.setText(text);
    }
}