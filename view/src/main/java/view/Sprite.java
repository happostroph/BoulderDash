package view;

import java.awt.Image;

public class Sprite implements ISprite {
	private Image image;
	private int x = 0, y = 0;

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
	public Sprite(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}

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
}
