package view.element;

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
	protected boolean blocked = false;
	protected boolean isNearCharacter = false;
	protected boolean wasAboveCharacter = false;
	private int direction = 0;
	
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

	/* (non-Javadoc)
	 * @see view.ISprite#setImage(java.awt.Image)
	 */
	@Override
	public void setImage(Image image) {
		this.image = image;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#getPermeability()
	 */
	public Permeability getPermeability() {
		return permeability;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#setPermeability(model.Permeability)
	 */
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#getType()
	 */
	public SpriteType getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#isHasMoved()
	 */
	public boolean isHasMoved() {
		return hasMoved;
	}

	/* (non-Javadoc)
	 * @see view.ISprite#setHasMoved(boolean)
	 */
	public void setHasMoved(boolean hasMoved ) {
		this.hasMoved = hasMoved;
	}
	
	/* (non-Javadoc)
	 * @see view.ISprite#getDirection()
	 */
	public int getDirection() {
		return direction;
	}
	/* (non-Javadoc)
	 * @see view.ISprite#setDirection(int)
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}


	public boolean isWasAboveCharacter() {
		return wasAboveCharacter;
	}


	public void setWasAboveCharacter(boolean wasAboveCharacter) {
		this.wasAboveCharacter = wasAboveCharacter;
	}


	public boolean isBlocked() {
		return blocked;
	}


	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
}
