package com.example.ui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatLightLaf;

public final class MainFrame {
	// INSTANCE VARIABLES
	private static final String VERSION = "v1.0.0";

	private final BattleSubframe battleFrame;
	private final DialogBox dexDialogBox;
	private final DialogBox teamDialogBox;

	private final JButton enterButton;
	private final JButton battleButton;
	private final JButton teamButton;
	private final JButton dexButton;

	private final JLabel displayLabel;

	private final JTextField inputField;

	private final JFrame frame;

	private final JPanel panel;
	private final JPanel topPanel;
	private final JPanel bottomPanel;

	// CONSTRUCTOR
	public MainFrame() {
		FlatLightLaf.setup(); // Set Look and Feel

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
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

		inputField = new JTextField();
		enterButton = new JButton("Enter");

		bottomPanel.add(inputField);
		bottomPanel.add(enterButton);

		panel.add(bottomPanel, BorderLayout.SOUTH);

		// Final Configuration
		frame.add(panel);

		frame.pack();
		frame.setLocationRelativeTo(null);

		// Initialize subframes/dialogs after frame setup
		battleFrame = new BattleSubframe();
		dexDialogBox = new DialogBox();
		teamDialogBox = new DialogBox();
	}

	// METHODS

	/* Main Frame */
	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	public void addWindowListener(WindowListener listener) {
		frame.addWindowListener(listener);
	}

	/* Display Label */
	public String getDisplayText() {
		return displayLabel.getText();
	}

	public void setDisplayText(String text) {
		displayLabel.setText(text);
	}

	/* Top Toolbar */
	public void setTopPanelVisible(boolean visible) {
		topPanel.setVisible(visible);
	}

	public void addBattleButtonListener(ActionListener listener) {
		battleButton.addActionListener(listener);
	}

	public void addTeamButtonListener(ActionListener listener) {
		teamButton.addActionListener(listener);
	}

	public void addDexButtonListener(ActionListener listener) {
		dexButton.addActionListener(listener);
	}

	/* Bottom Toolbar */
	public void setBottomPanelVisible(boolean visible) {
		bottomPanel.setVisible(visible);
	}

	public String getInputText() {
		return inputField.getText();
	}

	public void setInputText(String text) {
		inputField.setText(text);
	}

	public void addInputFieldListener(ActionListener listener) {
		inputField.addActionListener(listener);
	}

	public void addEnterButtonListener(ActionListener listener) {
		enterButton.addActionListener(listener);
	}

	/* Battle Frame */
	public void setBattleFrameVisible(boolean visible) {
		battleFrame.setVisible(visible);
	}

	public void addBattleFrameCatchListener(ActionListener listener) {
		battleFrame.catchButton_addActionListener(listener);
	}

	public void addBattleFrameEscapeListener(ActionListener listener) {
		battleFrame.escapeButton_addActionListener(listener);
	}

	/* Dialog Box - Dex */
	public void setDexDialogVisible(boolean visible) {
		dexDialogBox.setVisible(visible);
	}

	public void setDexDialogText(String text) {
		dexDialogBox.setText(text);
	}

	/* Dialog Box - Team */
	public void setTeamDialogVisible(boolean visible) {
		teamDialogBox.setVisible(visible);
	}

	public void setTeamDialogText(String text) {
		teamDialogBox.setText(text);
	}
}