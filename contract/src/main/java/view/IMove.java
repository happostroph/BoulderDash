package view;

public interface IMove {
	
	public void setMapModifier(ISprite[][] sprites, int SET_SIZE, IPanel panel);
	
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite);

	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite);

	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite);
	
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite);
	
	public void gameOver();

	public boolean isGameOver();
	
	public boolean isVictory();

	public void setVictory(boolean victory);
	
	public Boolean nextToBackground(ISprite sprite);
	
	public ISprite[][] setDirtAndBackgroundToDiamond(ISprite[][] sprites, final int SET_SIZE);
}
