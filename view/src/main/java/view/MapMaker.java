package view;

import java.awt.Graphics;
import java.awt.Image;

public class MapMaker implements IMapMaker {
	private ISprite[][] sprites = new Sprite[22][40];
	private Image map[][] = new Image[22][40];
	private int x = 0, y = 0, ligne = 0, colonne = 0, characterX =0, characterY =0;

	/**
	 * The constructor of MapMaker, 
	 * 
	 * @param translate 
	 * 				the translation of the query
	 */

	public MapMaker(TranslateMap translate) {
		this.map = translate.getMap();
		this.characterX = translate.getCharacterX();
		this.characterY = translate.getCharacterY();
	}

	/**
	 * Create the 880 sprites who are in the map and give then their position.
	 * Then he put them in the tab sprites.
	 * 
	 * @param SET_SIZE 
	 * 				    the size of a sprite
	 */

	public void spritesCreation(final int SET_SIZE) {
		ligne =0;
		for (Image sousImg[] : map) {
			x = 0;
			colonne = 0;
			for (Image img : sousImg) {
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
	 * @param g
	 * 					
	 */

	public void drawMap(Graphics g) {
		for (ISprite[] sousSpit : this.getSprites()) {
			for (ISprite spit : sousSpit) {
				g.drawImage(spit.getImage(), spit.getX(), spit.getY(), null);
			}
		}
	}

	/**
	 * 
	 * @return a two-dimensional table of Sprite
	 */
	
	public ISprite[][] getSprites() {
		return sprites;
	}
	
	/**
	 * 
	 * @return a Sprite in the two-dimensional table 
	 */
	
	public ISprite getCharacter(int colonne, int ligne){
		return sprites[ligne][colonne];
	}

	public void setSprites(ISprite[][] sprites) {
		this.sprites = sprites;
	}
}
