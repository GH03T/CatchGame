package com.example;

import javax.swing.SwingUtilities;

import com.example.ui.controller.MainController;
import com.example.ui.model.MyModel;
import com.example.ui.view.MainFrame;
import com.example.util.SaveManager;

public class Main {
    public static void main(String[] args) {
        // Load Save on Startup
        MyModel loadedModel = SaveManager.load();
        MyModel model;
        if(loadedModel != null) {
            model = loadedModel;
            model.isLoaded(true);
        } else {
            model = new MyModel();
            model.isLoaded(false);
        }

        // Run on the EDT (Event Dispatcher Thread)
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame();
            MainController controller = new MainController(model, frame);
            controller.start(); 

            // Save on Exit
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    if (model.isLoaded()) {
                        SaveManager.save(model);
                    }
                }
            });
        });
    }
}