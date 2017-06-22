package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MapModifier implements IMapModifier{
	ISprite[][] sprites;
	int SET_SIZE;
	Image image;

	public MapModifier(){
		
	}
	
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

	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, colonne * SET_SIZE, ligne * SET_SIZE);
		sprite.setX(sprite.getX() - 16);
		this.sprites[ligne][colonne - 1] = sprite;
		return this.sprites;
	}

	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, colonne * SET_SIZE, ligne * SET_SIZE);
		sprite.setX(sprite.getX() + 16);
		this.sprites[ligne][colonne + 1] = sprite;
		return this.sprites;
	}

	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, colonne * SET_SIZE, ligne * SET_SIZE);
		sprite.setY(sprite.getY() - 16);
		this.sprites[ligne - 1][colonne] = sprite;
		return this.sprites;
	}
	
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite) {
		this.sprites[ligne][colonne] = new Sprite(image, colonne * SET_SIZE, ligne * SET_SIZE);
		sprite.setY(sprite.getY() + 16);
		this.sprites[ligne + 1][colonne] = sprite;
		return this.sprites;
	}
}
