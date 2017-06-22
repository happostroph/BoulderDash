package view;

import java.awt.Image;

import model.Permeability;

public interface ISprite {
	
	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	public Image getImage();

	public void setImage(Image image);
	
	public Permeability getPermeability();

	public void setPermeability(Permeability permeability);
	
	public SpriteType getType();
}
