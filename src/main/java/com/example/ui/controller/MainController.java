package com.example.ui.controller;

import com.example.ui.model.MyModel;
import com.example.ui.view.MainFrame;

public class MainController {
    // INSTANCE VARIABLES
    private final MyModel model;
    private final MainFrame frame;

    // CONSTRUCTOR
    public MainController(MyModel model, MainFrame frame) {
        this.model = model;
        this.frame = frame;

        setupActionListeners(); // Add Action Listeners
    }

    // METHODS
    private void setupActionListeners() {
        /* MAIN MENU */

        // On Enter
        frame.enterButton_addActionListener(e -> onEnterClick());
        frame.inputField_addActionListener(e -> onEnterClick());

        // List Dex
        frame.dexButton_addActionListener(e -> {
            frame.dexDialogBox_setText(model.getPlayer().getDex());
            frame.dexDialogBox_setVisible(true);
        });

        // List Team
        frame.teamButton_addActionListener(e -> {
            frame.teamDialogBox_setText(model.getPlayer().getTeam());
            frame.teamDialogBox_setVisible(true);
        });


        /* BATTLE MENU */
        
        // Open Battle Menu
        frame.battleButton_addActionListener(e -> frame.battleFrame_setVisible(true));

        // Catch Button
        frame.battleFrame_catchButton_addActionListener(e -> {
            frame.displayLabel_setText(model.getPlayer().catchBoblet());
            frame.battleFrame_setVisible(false);

            updateDialog(); // Update Dialog Boxes
        });
        
        // Escape Button
        frame.battleFrame_escapeButton_addActionListener(e -> {
            frame.displayLabel_setText(model.getPlayer().runAway());
            frame.battleFrame_setVisible(false);

            updateDialog(); // Update Dialog Boxes
        });
    }

    private void onEnterClick() {
        // Get Name
        if(frame.displayLabel_getText().equals(model.getInputNameText())) {
            model.setName(frame.inputField_getText());

            frame.displayLabel_setText(model.getInputAgeText());
            frame.inputField_setText(null);

            return;
        }

        // Get Age
        if(frame.displayLabel_getText().equals(model.getInputAgeText())) {
            model.setAgeString(frame.inputField_getText());
            model.initPlayer();

            frame.displayLabel_setText(model.getGreeting());

            frame.inputField_setText(null);
            frame.topPanel_setVisible(true);
            frame.bottomPanel_setVisible(false);

            model.isLoaded(true);

            return;
        }
    }

    // Update Dialog Boxes
    private void updateDialog() {
        frame.dexDialogBox_setText(model.getPlayer().getDex());
        frame.teamDialogBox_setText(model.getPlayer().getTeam());
    }

    // Start Game
    public void start() {
        if(model.isLoaded()) {
            frame.displayLabel_setText(model.getGreeting());

            frame.topPanel_setVisible(true);
            frame.bottomPanel_setVisible(false);
        } else {
            frame.displayLabel_setText(model.getInputNameText());
        }

        frame.setVisible(true);
    }
}