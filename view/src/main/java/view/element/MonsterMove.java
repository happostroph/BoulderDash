package view.element;

import model.Permeability;
import view.IMonsterMove;
import view.ISprite;
import view.SpriteType;

public class MonsterMove implements IMonsterMove {
	private int ligne = 0, colonne = 0;
	private boolean gameOver = false;

	public ISprite[][] toMoveTheMonsters(ISprite[][] sprites) {
		ligne = 0;
		for (ISprite sousSpit[] : sprites) {
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if ((spit.getType() == SpriteType.MONSTER)) {

					if ((isSpriteNearToBackground(sprites[ligne + 1][colonne])
							|| isSpriteNearToBackground(sprites[ligne - 1][colonne]))
							&& !sprites[ligne][colonne].isHasMoved()) {

						if ((isSpriteNearCharacter(sprites[ligne + 1][colonne])
								|| isSpriteNearCharacter(sprites[ligne - 1][colonne]))
								&& !sprites[ligne][colonne].isHasMoved()) {
							if (isSpriteNearCharacter(sprites[ligne + 1][colonne])) {
								System.out.println("test3");
								sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
								spit.setY(spit.getY() + 16);
								spit.setHasMoved(true);
								sprites[ligne + 1][colonne] = spit;
								gameOver();
							}
							if (isSpriteNearCharacter(sprites[ligne - 1][colonne])) {
								System.out.println("test4");
								sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
								spit.setY(spit.getY() - 16);
								spit.setHasMoved(true);
								sprites[ligne - 1][colonne] = spit;
								gameOver();
							}
						} else {
							if (spit.getDirection() == 1) {
								if (sprites[ligne - 1][colonne].getType() == SpriteType.BACKGROUND) {
									MoveUp(sprites, spit);
								} else {

									spit.setDirection(2);
									MoveDown(sprites, spit);
								}
							} else if (spit.getDirection() == 2) {

								if (sprites[ligne + 1][colonne].getType() == SpriteType.BACKGROUND) {
									MoveDown(sprites, spit);

								} else {
									spit.setDirection(1);
									MoveUp(sprites, spit);
								}
							}

							else if (isSpriteNearToBackground(sprites[ligne + 1][colonne])) {
								MoveDown(sprites, spit);
							} else if (isSpriteNearToBackground(sprites[ligne - 1][colonne])) {
								MoveUp(sprites, spit);
							}
						}
					}

				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	public ISprite[][] MoveUp(ISprite[][] sprites, ISprite spit) {
		sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
		spit.setY(spit.getY() - 16);
		spit.setHasMoved(true);
		spit.setDirection(1);
		sprites[ligne - 1][colonne] = spit;
		return sprites;
	}

	public ISprite[][] MoveDown(ISprite[][] sprites, ISprite spit) {
		sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
		spit.setY(spit.getY() + 16);
		spit.setHasMoved(true);
		spit.setDirection(2);
		sprites[ligne + 1][colonne] = spit;
		return sprites;
	}

	public Boolean isSpriteNearToBackground(ISprite sprites) {
		return sprites.getType() == SpriteType.BACKGROUND;
	}

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