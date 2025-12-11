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
        frame.addEnterButtonListener(e -> onEnterClick());
        frame.addInputFieldListener(e -> onEnterClick());

        // List Dex
        frame.addDexButtonListener(e -> {
            frame.setDexDialogText(model.getPlayer().getDex());
            frame.setDexDialogVisible(true);
        });

        // List Team
        frame.addTeamButtonListener(e -> {
            frame.setTeamDialogText(model.getPlayer().getTeam());
            frame.setTeamDialogVisible(true);
        });


        /* BATTLE MENU */
        
        // Open Battle Menu
        frame.addBattleButtonListener(e -> frame.setBattleFrameVisible(true));

        // Catch Button
        frame.addBattleFrameCatchListener(e -> {
            frame.setDisplayText(model.getPlayer().catchBoblet());
            frame.setBattleFrameVisible(false);

            updateDialog(); // Update Dialog Boxes
        });
        
        // Escape Button
        frame.addBattleFrameEscapeListener(e -> {
            frame.setDisplayText(model.getPlayer().runAway());
            frame.setBattleFrameVisible(false);

            updateDialog(); // Update Dialog Boxes
        });
    }

    private void onEnterClick() {
        // Get Name
        if(frame.getDisplayText().equals(model.getInputNameText())) {
            model.setName(frame.getInputText());

            frame.setDisplayText(model.getInputAgeText());
            frame.setInputText(null);

            return;
        }

        // Get Age
        if(frame.getDisplayText().equals(model.getInputAgeText())) {
            model.setAgeString(frame.getInputText());
            model.initPlayer();

            frame.setDisplayText(model.getGreeting());

            frame.setInputText(null);
            frame.setTopPanelVisible(true);
            frame.setBottomPanelVisible(false);;

            model.isLoaded(true);

            return;
        }
    }

    // Update Dialog Boxes
    private void updateDialog() {
        frame.setDexDialogText(model.getPlayer().getDex());
        frame.setTeamDialogText(model.getPlayer().getTeam());
    }

    // Start Game
    public void start() {
        if(model.isLoaded()) {
            frame.setDisplayText(model.getGreeting());

            frame.setTopPanelVisible(true);;
            frame.setBottomPanelVisible(false);
        } else {
            frame.setDisplayText(model.getInputNameText());
        }

        frame.setVisible(true);
    }
}