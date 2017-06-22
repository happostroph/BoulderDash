package view.Element;

import java.awt.Image;

import model.IPermeability;
import view.ISprite;

public abstract class Sprite implements ISprite {
	protected Image image;
	protected int x = 0, y = 0;
	protected IPermeability permeability;

	/**
	 * The constructor of Sprite, a Sprite is a picture with a size of 16x16
	 * pixels
	 * 
	 * @param image
	 *            the path of the file were the picture is stored
	 * @param x
	 *            the position on the X axle
	 * @param y
	 *            the position on the Y axle
	 */
	
//	public Sprite(Image image, int x, int y) {
//		this.image = image;
//		this.x = x;
//		this.y = y;
//	}

	/**
	 * @return x the position on the X axle
	 */
	
	public int getX() {
		return x;
	}

	/**
	 * @param x
	 *            the position on the X axle
	 */
	
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return y the position on the Y axle
	 */
	
	public int getY() {
		return y;
	}

	/**
	 * @param y
	 *            the position on the Y axle
	 */
	
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return image the path of the file were the picture is stored
	 */
	
	public Image getImage() {
		return image;
	}

	@Override
	public void setImage(Image image) {
		this.image = image;
	}

	public IPermeability getPermeability() {
		return permeability;
	}

	public void setPermeability(IPermeability permeability) {
		this.permeability = permeability;
	}
}
