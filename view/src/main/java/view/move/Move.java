package view.move;

import java.awt.Image;

import model.Permeability;
import view.IMove;
import view.IPanel;
import view.ISprite;
import view.SpriteType;

public class Move implements IMove {
	protected ISprite[][] sprites;
	protected int SET_SIZE;
	protected IPanel panel;
	protected static boolean gameOver = false, victory = false;
	protected Image image;

	/**
	 * initialize MapModifier
	 * 
	 * @param sprites
	 * @param SET_SIZE
	 */
	public Move(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
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
		GoToLeft left = new GoToLeft(sprites, ligne, panel);
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
		GoToRight right = new GoToRight(sprites, ligne, panel);
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
		GoToUp up = new GoToUp(sprites, ligne, panel);
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
		GoToDown down = new GoToDown(sprites, ligne, panel);
		return down.goDown(colonne, ligne, sprite, this.sprites, this.panel);
	}

	/**
	 * return true if the sprite is BLOCKING
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteOn(ISprite sprite) {
		return sprite.getPermeability() == Permeability.BLOCKING;
	}

	/**
	 * return true if the sprite is a Diamond
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToDiamond(ISprite sprite) {
		return sprite.getType() == SpriteType.DIAMOND;
	}

	/**
	 * return true if the sprite is a Monster
	 * @param sprite
	 * @return boolean
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
	 * return true if the sprite is a Rock
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToRock(ISprite sprite) {
		return sprite.getType() == SpriteType.ROCK;
	}

	/**
	 * return true if the sprite is the Exit and if it's PERMEABLE
	 * @param sprite
	 * @return boolean
	 */
	public Boolean nextToOpenedExit(ISprite sprite) {
		return (sprite.getType() == SpriteType.EXIT && sprite.getPermeability() == Permeability.PERMEABLE);
	}

	/* (non-Javadoc)
	 * @see view.IMove#gameOver()
	 */
	public void gameOver(boolean gameOver) {
		Move.gameOver = gameOver;
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
		Move.victory = victory;
	}
}