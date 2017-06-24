package view.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Permeability;
import view.SpriteType;

/**
 * @author maxim
 *
 */
public class Unbreakable extends Sprite{
	
	/**
	 * @param x
	 * @param y
	 */
	public Unbreakable(int x, int y){
		super();
		this.permeability = Permeability.BLOCKING;
		this.x = x;
		this.y = y;
		this.type = SpriteType.UNBREAKABLE;
		
		try {
			image = ImageIO.read(new File("image/01.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
