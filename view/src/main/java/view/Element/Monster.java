package view.Element;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.IPermeability;

public class Monster extends Sprite{

	public Monster(int x, int y, IPermeability permeability){
		super();
		this.permeability = permeability;
		this.x = x;
		this.y = y;
		
		try {
			image = ImageIO.read(new File("image/07.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
