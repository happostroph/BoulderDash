package view;

import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;

public class Panel extends JPanel implements Serializable {
	private static final long serialVersionUID = 1L;
	protected Image buffer[][] = new Image[22][40];
	int ligne = 0, colonne = 0;
	private MapMaker maker;
/*
 * constructeur de Panel, recupère un MapMaker et le met dans this.maker
 */
	
	public Panel(MapMaker maker) {
		this.maker = maker;
	}
/*
 * appel la fonction d'affichage des Sprites
 */
	
	public void paintComponent(Graphics g) {
		this.maker.drawMap(g);
	}
		
}