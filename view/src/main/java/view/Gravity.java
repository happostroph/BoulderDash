package view;

import view.Element.Background;

public class Gravity implements IGravity {
	private int ligne = 0, colonne = 0;
	private boolean gameOver = false;

	public ISprite[][] makeThemFall(ISprite[][] sprites) {
		ligne = 0;
		for (ISprite sousSpit[] : sprites) {
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if ((spit.getType() == SpriteType.DIAMOND || spit.getType() == SpriteType.ROCK)) {

					if (isSpriteNextToBackground(sprites[ligne + 1][colonne])) {
						System.out.println("test1");
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setY(spit.getY() + 16);
						spit.setHasMoved(true);
						sprites[ligne + 1][colonne] = spit;

					}
					if (isSpriteAboveCharacter(sprites[ligne + 1][colonne]) && spit.isHasMoved()) {
						System.out.println("test2");
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setY(spit.getY() + 16);
						spit.setHasMoved(true);
						sprites[ligne + 1][colonne] = spit;
						gameOver();
					}
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	public ISprite[][] makeThemSlide(ISprite[][] sprites) {
		ligne = 0;
		for (ISprite sousSpit[] : sprites) {
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if ((spit.getType() == SpriteType.DIAMOND || spit.getType() == SpriteType.ROCK)
						&& isSpriteAboveRockOrDiamond(sprites[ligne + 1][colonne])
						&& !sprites[ligne][colonne].isHasMoved()) {

					if (isSpriteNextToBackground(sprites[ligne][colonne + 1])
							&& isSpriteNextToBackground(sprites[ligne + 1][colonne + 1])) {
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setX(spit.getX() + 16);
						sprites[ligne][colonne + 1] = spit;
					} else if (isSpriteNextToBackground(sprites[ligne][colonne - 1])
							&& isSpriteNextToBackground(sprites[ligne + 1][colonne - 1])) {
						sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
						spit.setX(spit.getX() - 16);
						sprites[ligne][colonne - 1] = spit;
					}
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}

	public Boolean isSpriteAboveRockOrDiamond(ISprite sprites) {
		if (sprites.getType() == SpriteType.ROCK || sprites.getType() == SpriteType.DIAMOND) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean isSpriteNextToBackground(ISprite sprites) {
		return sprites.getType() == SpriteType.BACKGROUND;
	}

	public Boolean isSpriteAboveCharacter(ISprite sprites) {
		return sprites.getType() == SpriteType.CHARACTER;
	}

	public void gameOver() {
		gameOver = true;
	}

	public boolean isGameOver() {
		return gameOver;
	}
}
