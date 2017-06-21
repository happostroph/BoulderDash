package view;

import java.awt.Graphics;
import java.awt.Image;

public class MapMaker implements IMapMaker {
	private Sprite[][] sprites = new Sprite[22][40];
	private Image map[][] = new Image[22][40];
	private int x = 0, y = 0, ligne = 0, colonne = 0;

	/**
	 * The constructor of MapMaker, 
	 * 
	 * @param map 
	 * 				the map of the level
	 */

	public MapMaker(Image map[][]) {
		this.map = map;
	}

	/**
	 * Create the 880 sprites who are in the map and give then their position.
	 * Then he put them in the tab sprites.
	 * 
	 * @param SET_SIZE 
	 * 				    the size of a sprite
	 */

	public void spritesCreation(final int SET_SIZE) {
		for (Image sousImg[] : map) {
			x = 0;
			colonne = 0;
			for (Image img : sousImg) {
				// this.addSprite(new Sprite(img, x, y));
				sprites[ligne][colonne] = new Sprite(img, x, y);
				x = x + SET_SIZE;
				colonne++;
			}
			y = y + SET_SIZE;
			ligne++;
		}
	}

	/**
	 * Show the 880 sprites and their position
	 * 
	 * @param graphics
	 * 					
	 */

	public void drawMap(Graphics graphics) {
		for (Sprite[] sousSpit : this.getSprites()) {
			for (Sprite spit : sousSpit) {
				graphics.drawImage(spit.getImage(), spit.getX(), spit.getY(), null);
			}
		}
	}
	
	public void drawcharacter(Graphics g, ISprite sprite){
		g.drawImage(sprite.getImage(), sprite.getX(), sprite.getY(), null);
	}

	/**
	 * 
	 * @return a two-dimensional table of Sprite
	 */
	public Sprite[][] getSprites() {
		return sprites;
	}
}
