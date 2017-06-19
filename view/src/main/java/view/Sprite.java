package view;

import java.awt.Image;

public class Sprite {
	private Image image;
	private int x = 0, y = 0;
/*
 * constructeur de Sprite, un sprite est une image de 16x16 pixels
 */
	public Sprite(Image image, int x, int y) {
		this.image = image;
		this.x = x;
		this.y = y;
	}
/*
 * Getters and Setters
 */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}
}
