package view;

public interface IMove {
	
	/**
	 * Move the character to the left and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return table who contains the modified map
	 */
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite);

	/**
	 * Move the character to the right and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return table who contains the modified map
	 */
	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite);

	/**
	 * Move the character up and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return table who contains the modified map
	 */
	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite);
	
	/**
	 * Move the character down and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @return table who contains the modified map
	 */
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite);
	
	/**
	 * Set the boolean gameOver to true
	 */
	public void gameOver(boolean gameOver);

	/**
	 * @return boolean
	 */
	public boolean isGameOver();
	
	/**
	 * @return boolean
	 */
	public boolean isVictory();

	/**
	 * Set the boolean victory to true
	 */
	public void setVictory(boolean gameOver);
	
	/**
	 * Looks if the sprite is a background
	 * @param sprite
	 * @return
	 */
	public Boolean nextToBackground(ISprite sprite);
	
}
