package view.move;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Permeability;
import view.IMove;
import view.IPanel;
import view.ISprite;
import view.SpriteType;
import view.element.Background;
import view.element.Diamond;
import view.element.Monster;

public class Move implements IMove {
	protected ISprite[][] sprites;
	protected int SET_SIZE;
	protected IPanel panel;
	protected boolean gameOver = false, victory = false;
	protected Image image;

	/**
	 * initialize MapModifier
	 * 
	 * @param sprites
	 * @param SET_SIZE
	 */

	public void setMapModifier(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		this.sprites = sprites;
		this.SET_SIZE = SET_SIZE;
		this.panel = panel;
	}

	/**
	 * move the character to the left and replace the old position by background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */

	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite) {
		GoToLeft left = new GoToLeft();
		return left.goLeft(colonne, ligne, sprite, this.sprites, this.panel);
	}

	/**
	 * move the character to the right and replace the old position by
	 * background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */

	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite) {
		GoToRight right = new GoToRight();
		return right.goRight(colonne, ligne, sprite, this.sprites, this.panel);
	}

	/**
	 * move the character up and replace the old position by background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */

	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite) {
		GoToUp up = new GoToUp();
		return up.goUp(colonne, ligne, sprite, this.sprites, this.panel);

	}

	/**
	 * move the character down and replace the old position by background
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return sprites
	 */

	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite) {
		GoToDown down = new GoToDown();
		return down.goDown(colonne, ligne, sprite, this.sprites, this.panel);
	}

	public Boolean isSpriteOn(ISprite sprite) {
		return sprite.getPermeability() == Permeability.BLOCKING;
	}

	public Boolean nextToDiamond(ISprite sprite) {
		return sprite.getType() == SpriteType.DIAMOND;
	}

	public Boolean nextToMonster(ISprite sprite) {
		return sprite.getType() == SpriteType.MONSTER;
	}
	
	public Boolean nextToBackground(ISprite sprite) {
		return sprite.getType() == SpriteType.BACKGROUND;
	}

	public Boolean nextToRock(ISprite sprite) {
		return sprite.getType() == SpriteType.ROCK;
	}
	public Boolean nextToOpenedExit(ISprite sprite) {
		return (sprite.getType() == SpriteType.EXIT && sprite.getPermeability() == Permeability.PERMEABLE);
	}

	public void gameOver() {
		gameOver = true;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public boolean isVictory() {
		return victory;
	}

	public void setVictory(boolean victory) {
		this.victory = victory;
	}
	

}
