package view;

public interface IGravity {
	/**
	 * Do the rocks and Diamonds fall
	 * @param sprites
	 * @return
	 */
	public ISprite[][] makeThemFall(ISprite[][] sprites);
	
	/**
	 * Verify if the sprite is a background
	 * @param sprites
	 * @return boolean
	 */
	public Boolean isSpriteNextToBackground(ISprite sprites);
	
	/**
	 * Do rocks slide on other rock and diamonds
	 * @param sprites
	 * @return
	 */
	public ISprite[][] makeThemSlide(ISprite[][] sprites);
	
	/**
	 * Getter of gameOver
	 * @return gameOver
	 */
	public boolean isGameOver();
}
