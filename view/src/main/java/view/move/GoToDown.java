package view.move;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.IPanel;
import view.ISprite;
import view.element.Background;
import view.element.Monster;

public class GoToDown extends Move{

	public ISprite[][] goDown(int colonne, int ligne, ISprite sprite, ISprite[][] sprites, IPanel panel) {
		try {
			image = ImageIO.read(new File("image/11.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextToDiamond(sprites[ligne + 1][colonne])) {
			panel.setDiamondsGet(panel.getDiamondsGet() + 1);
		} else if (nextToOpenedExit(sprites[ligne + 1][colonne])) {
			setVictory(true);
		}else if (nextToMonster(sprites[ligne + 1][colonne])) {
			sprites[ligne][colonne] = new Background(sprite.getX(), sprite.getY());
			sprite.setY(sprite.getY() + 16);
			sprites[ligne + 1][colonne] = new Monster(sprite.getX(), sprite.getY());
			gameOver();
			return sprites;
		}
		if (isSpriteOn(sprites[ligne + 1][colonne])) {
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
