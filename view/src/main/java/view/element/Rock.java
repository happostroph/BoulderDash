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
public class Rock extends Sprite{
	
	/**
	 * @param x
	 * @param y
	 */
	public Rock(int x, int y){
		super();
		this.permeability = Permeability.BLOCKING;
		this.x = x;
		this.y = y;
		this.type = SpriteType.ROCK;
		
		try {
			image = ImageIO.read(new File("image/04.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
