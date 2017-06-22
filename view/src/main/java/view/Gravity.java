package view;

import view.Element.Background;

public class Gravity implements IGravity{
	int ligne = 0, colonne = 0;
	public ISprite[][] makeThemFall(ISprite[][] sprites){
		ligne = 0;
		for(ISprite sousSpit[] : sprites){
			colonne = 0;
			for(ISprite spit : sousSpit){
				if((spit.getType() == SpriteType.DIAMOND || spit.getType() == SpriteType.ROCK) && isSpriteAboveBlocker(sprites[ligne+1][colonne])){
					sprites[ligne][colonne] = new Background(spit.getX(), spit.getY());
					spit.setY(spit.getY() + 16);
					sprites[ligne+1][colonne] = spit;
				}
				colonne++;
			}
			ligne++;
		}
		return sprites;
	}
	
	public Boolean isSpriteAboveBlocker(ISprite sprites) {
		return sprites.getType() == SpriteType.BACKGROUND;
	}
}
