package view;

import model.Permeability;
import view.Element.Background;
import view.Element.Monster;
import view.Element.Rock;

public class Move implements IMove {
	private ISprite[][] sprites;
	private int SET_SIZE;
	private IPanel panel;
	private boolean gameOver = false, victory = false;

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
		if (nextToDiamond(this.sprites[ligne][colonne - 1])) {
			this.panel.setDiamondsGet(this.panel.getDiamondsGet() + 1);
		} else if (nextToOpenedExit(this.sprites[ligne][colonne - 1])) {
			setVictory(true);
		} else if (nextToMonster(this.sprites[ligne][colonne + 1])) {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			this.sprites[ligne][colonne - 1] = new Monster(sprite.getX(), sprite.getY());
			gameOver();
			return this.sprites;
		}
		if (nextToRock(this.sprites[ligne][colonne - 1]) && nextToBackground(sprites[ligne][colonne - 2])){
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			this.sprites[ligne][colonne - 1] = sprite;
			this.sprites[ligne][colonne - 2] = new Rock((sprite.getX() - 16), sprite.getY());
			return this.sprites;
		}
		else if (isSpriteOn(this.sprites[ligne][colonne - 1])) {
			return this.sprites;
		} 
		
		else {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			this.sprites[ligne][colonne - 1] = sprite;
			return this.sprites;
		}
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
		if (nextToDiamond(this.sprites[ligne][colonne + 1])) {
			this.panel.setDiamondsGet(this.panel.getDiamondsGet() + 1);
		} else if (nextToOpenedExit(this.sprites[ligne][colonne + 1])) {
			setVictory(true);
		} else if (nextToMonster(this.sprites[ligne][colonne + 1])) {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() + 16);
			this.sprites[ligne][colonne + 1] = new Monster(sprite.getX(), sprite.getY());
			gameOver();
			return this.sprites;
		}
		if (nextToRock(this.sprites[ligne][colonne + 1]) && nextToBackground(sprites[ligne][colonne + 2])){
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() + 16);
			this.sprites[ligne][colonne + 1] = sprite;
			this.sprites[ligne][colonne + 2] = new Rock((sprite.getX() + 16), sprite.getY());
			return this.sprites;
		}
		else if (isSpriteOn(this.sprites[ligne][colonne + 1])) {
			return this.sprites;
		} 
		 
		else {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() + 16);
			this.sprites[ligne][colonne + 1] = sprite;
			return this.sprites;
		}
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
		if (nextToDiamond(this.sprites[ligne - 1][colonne])) {
			this.panel.setDiamondsGet(this.panel.getDiamondsGet() + 1);
		}else if (nextToOpenedExit(this.sprites[ligne - 1][colonne])) {
			setVictory(true);
		}
		else if (nextToMonster(this.sprites[ligne - 1][colonne])) {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() - 16);
			this.sprites[ligne - 2][colonne] = new Monster(sprite.getX(), (sprite.getY() - 16));
			gameOver();
			return this.sprites;
		}
//		else if (nextToRock(this.sprites[ligne - 1][colonne])){
//			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
//			sprite.setX(sprite.getY() - 16);
//			this.sprites[ligne - 1][colonne] = sprite;
//			this.sprites[ligne][colonne - 2] = new Rock((sprite.getX() - 16), sprite.getY());
//			return this.sprites;
//		}
		if (isSpriteOn(this.sprites[ligne - 1][colonne])) {
			return this.sprites;
		} else {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() - 16);
			this.sprites[ligne - 1][colonne] = sprite;
			return this.sprites;
		}

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
		if (nextToDiamond(this.sprites[ligne + 1][colonne])) {
			this.panel.setDiamondsGet(this.panel.getDiamondsGet() + 1);
		} else if (nextToOpenedExit(this.sprites[ligne + 1][colonne])) {
			setVictory(true);
		}else if (nextToMonster(this.sprites[ligne + 1][colonne])) {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			this.sprites[ligne + 1][colonne] = new Monster(sprite.getX(), sprite.getY());
			gameOver();
			return this.sprites;
		}
//		else if (nextToRock(this.sprites[ligne + 1][colonne])){
//			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
//			sprite.setX(sprite.getY() + 16);
//			this.sprites[ligne + 1][colonne] = sprite;
//			this.sprites[ligne][colonne + 2] = new Rock((sprite.getX() + 16), sprite.getY());
//			return this.sprites;
//		}
		if (isSpriteOn(this.sprites[ligne + 1][colonne])) {
			return this.sprites;
		} else {
			this.sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			this.sprites[ligne + 1][colonne] = sprite;
			return this.sprites;
		}
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
