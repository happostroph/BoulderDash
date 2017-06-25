package view;

public interface IMove {
	
	/**
	 * Move the character to the left and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return table who contains the modified map
	 */
	public ISprite[][] digLeft(int colonne, int ligne, ISprite sprite, IAudio audio);

	/**
	 * Move the character to the right and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return table who contains the modified map
	 */
	public ISprite[][] digRight(int colonne, int ligne, ISprite sprite, IAudio audio);

	/**
	 * Move the character up and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return table who contains the modified map
	 */
	public ISprite[][] digUp(int colonne, int ligne, ISprite sprite, IAudio audio);
	
	/**
	 * Move the character down and replace the old position by background
	 * @param colonne
	 * @param ligne
	 * @param sprite
	 * @param audio
	 * @return table who contains the modified map
	 */
	public ISprite[][] digDown(int colonne, int ligne, ISprite sprite, IAudio audio);
	
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
	 * @param victory
	 */
	public void setVictory(boolean victory);
	
	/**
	 * Looks if the sprite is a background
	 * @param sprite
	 * @return
	 */
	public Boolean nextToBackground(ISprite sprite);
	
}
