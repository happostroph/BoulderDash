package view;

import java.awt.Graphics;
import java.awt.Image;

public class MapMaker {
	private Sprite[][] sprites = new Sprite[22][40];
	private Image map[][] = new Image[22][40];
	private int x = 0, y = 0, ligne = 0, colonne = 0;

	/*
	 * constructeur de MapMaker, il recupère la map
	 */

	public MapMaker(TranslateMap translate) {
		this.map = translate.getMap();
	}

	/*
	 * Créer les 880 sprites contenu dans la map en leur donnant une position et
	 * les met dans le tableau de sprites
	 */

	public void spritesCreation() {
		for (Image sousImg[] : map) {
			x = 0;
			colonne = 0;
			for (Image img : sousImg) {
				// this.addSprite(new Sprite(img, x, y));
				sprites[ligne][colonne] = new Sprite(img, x, y);
				x = x + 16;
				colonne++;
			}
			y = y + 16;
			ligne++;
		}
	}

	/*
	 * affiche les 880 sprites à leur position
	 */

	public void drawMap(Graphics graphics) {
		for (Sprite[] sousSpit : this.getSprites()) {
			for(Sprite spit : sousSpit){
			graphics.drawImage(spit.getImage(), spit.getX(), spit.getY(), null);
			}
		}
	}

	/*
	 * return le tableau bidimensionnel sprites
	 */
	public Sprite[][] getSprites() {
		return sprites;
	}
}
