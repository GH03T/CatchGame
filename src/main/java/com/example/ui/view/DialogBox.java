package com.example.ui.view;

import java.awt.*;
import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

public class DialogBox {
    // INSTANCE VARIABLES
    private JDialog dialogBox;
    private JScrollPane scrollPane;
    private JTextArea textArea;

    // CONSTRUCTOR
    public DialogBox() {
        FlatLightLaf.setup();

        dialogBox = new JDialog();
        dialogBox.setSize(new Dimension(240, 120));
        dialogBox.setResizable(true);

        textArea = new JTextArea();
        textArea.setEditable(false);

        scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        dialogBox.add(scrollPane);
        dialogBox.setVisible(false);
    }

    // METHODS
    public void setVisible(boolean b) {
        dialogBox.setVisible(b);
    }

    public void setText(String text) {
        textArea.setText(text);
    }
}
