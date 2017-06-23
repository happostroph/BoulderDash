package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;

public class Panel extends JPanel implements Serializable, IPanel {
	private static final long serialVersionUID = 1L;

	protected Image buffer[][] = new Image[22][40];
	Font font = new Font("Courier", Font.BOLD, 15);
	int ligne = 0, colonne = 0;
	private IMapMaker maker;

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
	 * Calls the draw functions of MapMaker
	 * 
	 * @param g
	 * 
	 */

	public void compteurDiamond(Graphics g){
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Diamonds : " + diamonds , 10, 365);
		
	}
	
	public void paintComponent(Graphics g) {
		this.maker.drawMap(g);
		this.compteurDiamond(g);
	}

	/**
	 * Update the map when a mouvement is done
	 */

	@Override
	public void update() {
		this.repaint();
	}
}