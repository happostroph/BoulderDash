package view;

public interface IGravity {
	public ISprite[][] makeThemFall(ISprite[][] sprites);
	
	public Boolean isSpriteAboveBlocker(ISprite sprites);
}
