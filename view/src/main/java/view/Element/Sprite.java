package view.Element;

import java.awt.Image;

import model.Permeability;
import view.ISprite;
import view.SpriteType;

public abstract class Sprite implements ISprite {
	protected Image image;
	protected int x = 0, y = 0;
	protected Permeability permeability;
	protected SpriteType type;
	protected boolean hasMoved = false;

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

	public Permeability getPermeability() {
		return permeability;
	}

	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	public SpriteType getType() {
		return type;
	}

	public boolean isHasMoved() {
		return hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
}
