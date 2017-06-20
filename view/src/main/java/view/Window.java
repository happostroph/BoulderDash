package view;

import javax.swing.JFrame;

public class Window extends JFrame implements IWindow{
	private static final long serialVersionUID = 8164118974463460991L;
/**
 * The constructor of Window
 */
	public Window(MapMaker maker) {

		/*
		 * Create a new window
		 */
		
		this.setTitle("Test");
		this.setSize(645, 388);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * Create a new Panel
		 */
		Panel panel = new Panel(maker);

		/*
		 * Fill the panel
		 */

		this.setContentPane(panel);
		this.setVisible(true);
	}
}