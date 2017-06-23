package view;

import java.awt.Graphics;

public interface IMapMaker {
	public void spritesCreation(final int SET_SIZE);

	public void drawMap(Graphics graphics);

	public ISprite[][] getSprites();
	
	public ISprite getCharacter(int colonne, int ligne);

	public void setSprites(ISprite[][] sprites);
	
	public void setAllHasMovedToFalse(ISprite[][] sprites);
}