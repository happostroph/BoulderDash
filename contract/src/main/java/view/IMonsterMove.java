package view;

public interface IMonsterMove {
	/**
	 * Make the monsters move
	 * @param sprites
	 * @return sprites
	 */
	public ISprite[][] toMoveTheMonsters(ISprite[][] sprites);

	/**
	 * verify if the sprite is the background
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteNearToBackground(ISprite sprite);

	/**
	 * set boolean gameOver to true
	 */
	public void gameOver();

	/**
	 * verify if the sprite is the character
	 * @param sprite
	 * @return boolean
	 */
	public Boolean isSpriteNearCharacter(ISprite sprite);

	/**
	 * Getter of gameOver
	 * @return boolean
	 */
	public boolean isGameOver();
}
