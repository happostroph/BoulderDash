package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;

public class Panel extends JPanel implements Serializable, IPanel {
	private static final long serialVersionUID = 1L;
	protected Image buffer[][] = new Image[22][40];
	int ligne = 0, colonne = 0;
	private MapMaker maker;

	/**
	 * The constructor of Panel
	 * 
	 * @param maker
	 *            the maker of the map
	 */

	public Panel(MapMaker maker) {
		this.maker = maker;
	}

	/**
	 * Calls the drow function of MapMaker
	 * 
	 * @param g
	 * 
	 */

	public void paintComponent(Graphics g) {
		this.maker.drawMap(g);
	}

}