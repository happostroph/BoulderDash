package view;

public interface IMonsterMove {
	public ISprite[][] toMoveTheMonsters(ISprite[][] sprites);

	public Boolean isSpriteNearToBackground(ISprite sprites);

	public void gameOver();

	public Boolean isSpriteNearCharacter(ISprite sprites);

	public boolean isGameOver();
}
