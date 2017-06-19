package view;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class MapMaker {
	private ArrayList<Sprite> sprites;
	private Image map[][] = new Image[22][40];
	private int x = 0, y = 0;

	/*
	 * constructeur de MapMaker créer une ArrayList<Sprite>
	 */

	public MapMaker(TranslateMap translate) {
		sprites = new ArrayList<>();
		this.map = translate.getMap();
	}

	/*
	 * Créer les 880 sprites contenu dans la map en leur donnant une position et
	 * les met dans l'ArrayList
	 */

	public void spritesCreation() {
		for (Image sousImg[] : map) {
			x = 0;
			for (Image img : sousImg) {
				this.addSprite(new Sprite(img, x, y));
				x = x + 16;
			}
			y = y + 16;
		}
	}

	/*
	 * affiche les 880 sprites à leur position
	 */

	public void drawMap(Graphics graphics) {
		for (Sprite mdl : this.getSprites()) {
			graphics.drawImage(mdl.getImage(), mdl.getX(), mdl.getY(), null);
		}
	}

	/*
	 * return l'ArrayList sprites
	 */
	public ArrayList<Sprite> getSprites() {
		return this.sprites;
	}

	/*
	 * met les sprites créer dans l'ArrayList
	 */
	public void addSprite(Sprite sprite) {
		this.sprites.add(sprite);
	}
}
