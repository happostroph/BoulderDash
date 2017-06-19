package view;

import javax.swing.JFrame;

public class Window extends JFrame {
	private static final long serialVersionUID = 8164118974463460991L;

	public Window(MapMaker maker) {

		/**
		 * créer une nouvelle fenetre
		 **/
		
		this.setTitle("Test");
		this.setSize(645, 388);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/**
		 * créer un nouveau Panel
		 **/
		Panel panel = new Panel(maker);

		/**
		 * remplie un JPanel avec display
		 **/

		this.setContentPane(panel);
		this.setVisible(true);
	}
}