package view;

public interface IGravity {
	public ISprite[][] makeThemFall(ISprite[][] sprites);
	
	public Boolean isSpriteNextToBackground(ISprite sprites);
	
	public ISprite[][] makeThemSlide(ISprite[][] sprites);
	
	public boolean isGameOver();
}
