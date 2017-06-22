package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapModifier implements IMapModifier{
	ISprite[][] sprites;
	int SET_SIZE;
	Image image;
	
	
	/**
	 * initialize MapModifier
	 * @param sprites
	 * @param SET_SIZE
	 */
	public void setMapModifier(ISprite[][] sprites, int SET_SIZE) {
		this.sprites = sprites;
		this.SET_SIZE = SET_SIZE;
		try {
			this.image = ImageIO.read(new File("image/03.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * move the character to the left and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, sprite.getX(), sprite.getY());
		sprite.setX(sprite.getX() - 16);
		this.sprites[ligne][colonne - 1] = sprite;
		return this.sprites;
	}
	
	/**
	 * move the character to the right and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	
	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, sprite.getX(), sprite.getY());
		sprite.setX(sprite.getX() + 16);
		this.sprites[ligne][colonne + 1] = sprite;
		return this.sprites;
	}
	
	/**
	 * move the character up and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	
	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, sprite.getX(), sprite.getY());
		sprite.setY(sprite.getY() - 16);
		this.sprites[ligne - 1][colonne] = sprite;
		return this.sprites;
	}
	
	/**
	 * move the character down and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */
	
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, sprite.getX(), sprite.getY());
		sprite.setY(sprite.getY() + 16);
		this.sprites[ligne + 1][colonne] = sprite;
		return this.sprites;
	}
}
