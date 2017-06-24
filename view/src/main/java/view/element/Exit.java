package view.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Permeability;
import view.SpriteType;

public class Exit extends Sprite{
	
	/**
	 * Constructor of Exit
	 * @param x
	 * @param y
	 */
	public Exit(int x, int y){
		super();
		this.permeability = Permeability.BLOCKING;
		this.x = x;
		this.y = y;
		this.type = SpriteType.EXIT;
		
		try {
			image = ImageIO.read(new File("image/06.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
