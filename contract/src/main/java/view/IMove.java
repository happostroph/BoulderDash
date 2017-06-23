package view;

public interface IMove {
	
	public void setMapModifier(ISprite[][] sprites, int SET_SIZE, IPanel panel);
	
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite);

	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite);

	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite);
	
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite);
}
