package view.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.IAudio;
import view.IPanel;
import view.ISprite;
import view.element.Background;
import view.element.Monster;

public class GoToDown extends Move {

	/**
	 * Constructor of GoDown
	 * 
	 * @param sprites
	 * @param SET_SIZE
	 * @param panel
	 */
	public GoToDown(ISprite[][] sprites, int SET_SIZE, IPanel panel) {
		super(sprites, SET_SIZE, panel);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Tries to move the character down, if he cross a diamond he will collect
	 * it, if it's an opened exit he will win, if it's a monster he will die, if
	 * it's a BLOCKING sprite he wouldn't move, otherwise he will go down
	 * 
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param sprites
	 * @param panel
	 * @param audio
	 * @return sprites
	 */
	public ISprite[][] goDown(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel, IAudio audio) {
		try {
			image = ImageIO.read(new File("image/11.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne + 1][colonne])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
			panel.setScore(panel.getScore() + 1000);
			audio.playSound(new File("music/coin.wav"), 40.0f);
		}
		if (nextToOpenedExit(sprites[ligne + 1][colonne])) {
			panel.setScore(panel.getScore() + 10000);
			setVictory(true);
		} 
		if (nextToMonster(sprites[ligne + 1][colonne])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			sprites[ligne + 1][colonne] = new Monster(sprite.getX(), sprite.getY());
			audio.playSound(new File("music/die.wav"), 40.0f);
			gameOver(true);
			return sprites;
		} else if (isSpriteOn(sprites[ligne + 1][colonne])) {
			audio.playSound(new File("music/touch.wav"), 40.0f);
			return sprites;
		} else {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			sprite.setImage(image);
			sprites[ligne + 1][colonne] = sprite;
			return sprites;
		}
	}
}
