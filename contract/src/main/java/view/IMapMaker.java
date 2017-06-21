package view;

import java.awt.Graphics;

public interface IMapMaker {
	public void spritesCreation(final int SET_SIZE);

	public void drawMap(Graphics graphics);
	public void drawcharacter(Graphics g, ISprite sprite);
	public ISprite[][] getSprites();
	
	public ISprite getCharacter(int colonne, int ligne);

	public void setSprites(ISprite[][] sprites);
}