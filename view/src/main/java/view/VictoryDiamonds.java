package view;

import view.element.Diamond;

/**
 * @author maxim
 *
 */
public class VictoryDiamonds implements IVictoryDiamonds {
	
	/* (non-Javadoc)
	 * @see view.IVictoryDiamonds#setDirtAndBackgroundToDiamond(view.ISprite[][], int)
	 */
	public ISprite[][] setDirtAndBackgroundToDiamond(ISprite[][] sprites, final int SET_SIZE) {		
		int ligne = 0, colonne = 0, x = 0, y = 0;
		for (ISprite sousSpit[] : sprites) {
			x = 0;
			colonne = 0;
			for (ISprite spit : sousSpit) {
				if (spit.getType() == SpriteType.BACKGROUND || spit.getType() == SpriteType.DIRT) {
					sprites[ligne][colonne] = new Diamond(x, y);
				}
				x = x + SET_SIZE;
				colonne ++;
			}
			y = y + SET_SIZE;
			ligne++;
		}
		return sprites;
	}
}
