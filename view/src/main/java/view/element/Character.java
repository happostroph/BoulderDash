package view.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Permeability;
import view.SpriteType;

public class Character extends Sprite{

	/**
	 * Constructor of Character
	 * @param x
	 * @param y
	 */
	public Character(int x, int y){
		super();
		this.permeability = Permeability.PERMEABLE;
		this.x = x;
		this.y = y;
		this.type = SpriteType.CHARACTER;
		try {
			image = ImageIO.read(new File("image/13.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
