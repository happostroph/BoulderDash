package view;

import java.io.File;

import view.element.Background;

public class MonsterMove implements IMonsterMove {
	private int ligne = 0, colonne = 0;
	private boolean gameOver = false;

	/* (non-Javadoc)
	 * @see view.IMonsterMove#toMoveTheMonsters(view.ISprite[][])
	 */
	public ISprite[][] toMoveTheMonsters(ISprite[][] sprites, IAudio audio) {
		ligne = 0;
		for (ISprite sousSpit[] : sprites) {
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if ((spit.getType() == SpriteType.MONSTER)) {
					if ((isSpriteNearToBackground(sprites[ligne + 1][colonne])
							|| isSpriteNearToBackground(sprites[ligne - 1][colonne])
							|| isSpriteNearCharacter(sprites[ligne + 1][colonne])
							|| isSpriteNearCharacter(sprites[ligne - 1][colonne]))
							&& !sprites[ligne][colonne].isHasMoved()) {
						if (isSpriteNearCharacter(sprites[ligne + 1][colonne]) && spit.getDirection() == 2) {
							sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
							spit.setY(spit.getY() + 16);
							spit.setHasMoved(true);
							sprites[ligne + 1][colonne] = spit;
							audio.playSound(new File("music/die.wav"), 30.0f);
							gameOver();
						}
						else if (isSpriteNearCharacter(sprites[ligne - 1][colonne]) && spit.getDirection() == 1) {
							sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
							spit.setY(spit.getY() - 16);
							spit.setHasMoved(true);
							sprites[ligne - 1][colonne] = spit;
							audio.playSound(new File("music/die.wav"), 30.0f);
							gameOver();
						}
						else if (spit.getDirection() == 1) {
							if (sprites[ligne - 1][colonne].getType() == SpriteType.BACKGROUND) {
								MoveUp(sprites, spit);
							} else {
								MoveDown(sprites, spit);
							}
						} else if (spit.getDirection() == 2) {
							if (sprites[ligne + 1][colonne].getType() == SpriteType.BACKGROUND) {
								MoveDown(sprites, spit);
							} else {
								MoveUp(sprites, spit);
							}
						} else if (isSpriteNearToBackground(sprites[ligne + 1][colonne])) {
							MoveDown(sprites, spit);
						} else if (isSpriteNearToBackground(sprites[ligne - 1][colonne])) {
							MoveUp(sprites, spit);
						}
					}
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	/**
	 * @param sprites
	 * @param spit
	 * @return
	 */
	public ISprite[][] MoveUp(ISprite[][] sprites, ISprite spit) {
		sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
		spit.setY(spit.getY() - 16);
		spit.setHasMoved(true);
		spit.setDirection(1);
		sprites[ligne - 1][colonne] = spit;
		return sprites;
	}

	/**
	 * @param sprites
	 * @param spit
	 * @return
	 */
	public ISprite[][] MoveDown(ISprite[][] sprites, ISprite spit) {
		sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
		spit.setY(spit.getY() + 16);
		spit.setHasMoved(true);
		spit.setDirection(2);
		sprites[ligne + 1][colonne] = spit;
		return sprites;
	}

	/* (non-Javadoc)
	 * @see view.IMonsterMove#isSpriteNearToBackground(view.ISprite)
	 */
	public Boolean isSpriteNearToBackground(ISprite sprites) {
		return sprites.getType() == SpriteType.BACKGROUND;
	}

	/* (non-Javadoc)
	 * @see view.IMonsterMove#isSpriteNearCharacter(view.ISprite)
	 */
	public Boolean isSpriteNearCharacter(ISprite sprites) {
		return sprites.getType() == SpriteType.CHARACTER;
	}

	public void gameOver() {
		gameOver = true;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}