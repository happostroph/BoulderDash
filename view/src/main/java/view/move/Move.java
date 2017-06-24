package view.move;

import java.awt.Image;

import model.Permeability;
import view.IMove;
import view.IPanel;
import view.ISprite;
import view.SpriteType;

/**
 * @author maxim
 *
 */
public class Move implements IMove {
	protected ISprite[][] sprites;
	protected int SET_SIZE;
	protected IPanel panel;
	public boolean gameOver = false, victory = false;
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

	/**
	 * @param sprite
	 * @return
	 */
	public Boolean isSpriteOn(ISprite sprite) {
		return sprite.getPermeability() == Permeability.BLOCKING;
	}

	/**
	 * @param sprite
	 * @return
	 */
	public Boolean nextToDiamond(ISprite sprite) {
		return sprite.getType() == SpriteType.DIAMOND;
	}

	/**
	 * @param sprite
	 * @return
	 */
	public Boolean nextToMonster(ISprite sprite) {
		return sprite.getType() == SpriteType.MONSTER;
	}

	/* (non-Javadoc)
	 * @see view.IMove#nextToBackground(view.ISprite)
	 */
	public Boolean nextToBackground(ISprite sprite) {
		return sprite.getType() == SpriteType.BACKGROUND;
	}

	/**
	 * @param sprite
	 * @return
	 */
	public Boolean nextToRock(ISprite sprite) {
		return sprite.getType() == SpriteType.ROCK;
	}

	/**
	 * @param sprite
	 * @return
	 */
	public Boolean nextToOpenedExit(ISprite sprite) {
		return (sprite.getType() == SpriteType.EXIT && sprite.getPermeability() == Permeability.PERMEABLE);
	}

	/* (non-Javadoc)
	 * @see view.IMove#gameOver()
	 */
	public void gameOver() {
		gameOver = true;
	}

	/* (non-Javadoc)
	 * @see view.IMove#isGameOver()
	 */
	public boolean isGameOver() {
		return gameOver;
	}

	/* (non-Javadoc)
	 * @see view.IMove#isVictory()
	 */
	public boolean isVictory() {
		return victory;
	}

	/* (non-Javadoc)
	 * @see view.IMove#setVictory(boolean)
	 */
	
	public void setVictory(boolean victory) {
		this.victory = victory;
	}
}