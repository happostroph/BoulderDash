package view;

import java.awt.Image;

import model.Permeability;

public interface ISprite {
	
	/**
	 * Getter of x axes
	 * @return x
	 */
	public int getX();

	/**
	 * Setter of x axes
	 * @param x
	 */
	public void setX(int x);

	/**
	 * Getter of y axes
	 * @return y
	 */
	public int getY();

	/**
	 * Setter of y axes
	 * @param y
	 */
	public void setY(int y);

	/**
	 * Getter of Image
	 * @return image
	 */
	public Image getImage();

	/**
	 * Setter of Image
	 * @param image
	 */
	public void setImage(Image image);
	
	/**
	 * Getter of permeability
	 * @return permeability
	 */
	public Permeability getPermeability();

	/**
	 * Setter of permeability
	 * @param permeability
	 */
	public void setPermeability(Permeability permeability);
	
	/**
	 * Getter of Type
	 * @return type
	 */
	public SpriteType getType();
	
	/**
	 * @return boolean
	 */
	public boolean isHasMoved();

	/**
	 * Set hasMoved to true
	 * @param hasMoved
	 */
	public void setHasMoved(boolean hasMoved);
	
	/**
	 * Getter of direction
	 * @return direction
	 */
	public int getDirection();
	
	/**
	 * setter of direction
	 * @param direction
	 */
	public void setDirection(int direction);
}
