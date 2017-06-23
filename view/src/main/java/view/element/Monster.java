package view.element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Permeability;
import view.SpriteType;

public class Monster extends Sprite{

	public Monster(int x, int y){
		super();
		this.permeability = Permeability.KILL;
		this.x = x;
		this.y = y;
		this.type = SpriteType.MONSTER;
		
		try {
			image = ImageIO.read(new File("image/07.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
