package view.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.IPanel;
import view.ISprite;
import view.element.Background;
import view.element.Monster;
import view.element.Rock;

public class GoToLeft extends Move {

	public GoToLeft(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		super(sprites, SET_SIZE, panel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Tries to move the character left, if he cross a diamond he will collect
	 * it, if it's an opened exit he will win, if it's a monster he will die, if
	 * it's a BLOCKING sprite he wouldn't move, otherwise he will go left
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param sprites
	 * @param panel
	 * @return sprites
	 */
	public ISprite[][] goLeft(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
		try {
			image = ImageIO.read(new File("image/g1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne][colonne - 1])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
		}
		if (nextToOpenedExit(sprites[ligne][colonne - 1])) {
			setVictory();
		}
		if (nextToMonster(sprites[ligne][colonne - 1])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			sprites[ligne][colonne - 1] = new Monster(sprite.getX(), sprite.getY());
			System.out.println("game of");
			gameOver(true);
			return sprites;
		}
		if (nextToRock(sprites[ligne][colonne - 1]) && nextToBackground(sprites[ligne][colonne - 2])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			sprite.setImage(image);
			sprites[ligne][colonne - 1] = sprite;
			sprites[ligne][colonne - 2] = new Rock((sprite.getX() - 16), sprite.getY());
			return sprites;
		} else if (isSpriteOn(sprites[ligne][colonne - 1])) {
			return sprites;
		}

		else {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setX(sprite.getX() - 16);
			sprite.setImage(image);
			sprites[ligne][colonne - 1] = sprite;
			return sprites;
		}

	}
}
