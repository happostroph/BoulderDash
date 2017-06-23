package view;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import controller.IBDKeyListener;

public class Window extends JFrame implements IWindow {
	private static final long serialVersionUID = 8164118974463460991L;
	Panel panel;

	/**
	 * The constructor of Window
	 */
	public Window(MapMaker maker, IBDKeyListener listener) {

		/*
		 * Create a new window
		 */

		this.setTitle("Test");
		this.setSize(645, 410);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFocusable(true);
		this.addKeyListener((KeyListener) listener);
		/*
		 * Create a new Panel
		 */
		panel = new Panel(maker);

		/*
		 * Fill the panel
		 */

		this.setContentPane(panel);
		this.setVisible(true);
	}
	
	
	public Panel getPanel() {
		return panel;
	}
}