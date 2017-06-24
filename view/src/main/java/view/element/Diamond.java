package view.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Permeability;
import view.SpriteType;

public class Diamond extends Sprite{

	/**
	 * Constructor of Diamond
	 * @param x
	 * @param y
	 */
	public Diamond(int x, int y){
		super();
		this.permeability = Permeability.PERMEABLE;
		this.x = x;
		this.y = y;
		this.type = SpriteType.DIAMOND;
		
		try {
			image = ImageIO.read(new File("image/05.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
