package controller;

import model.UserOrder;
import view.IMapMaker;
import view.IMapModifier;
import view.IPanel;
import view.ISprite;

public class Controller implements IController {
	private UserOrder stackOrder = UserOrder.NOOP;
	int i = 0, SET_SIZE = 0, colonne = 0, ligne = 0;
	IPanel panel;
	ISprite sprite;
	IMapMaker maker;
	IMapModifier modifier;

	/**
	 * Constructor of Controller
	 * @param sprite
	 * @param panel
	 * @param SET_SIZE
	 * @param modifier
	 * @param maker
	 */
	
	public Controller(ISprite sprite, IPanel panel, int SET_SIZE, IMapModifier modifier, IMapMaker maker) {
		this.panel = panel;
		this.sprite = sprite;
		this.SET_SIZE = SET_SIZE;
		this.modifier = modifier;
		this.maker = maker;
		modifier.setMapModifier(maker.getSprites(), SET_SIZE);
	}

	
	/**
	 * move the character
	 */
	
	public final void directionControl() throws InterruptedException {
		while (true) {
			Thread.sleep(40);
			colonne = sprite.getX() / SET_SIZE;
			ligne = sprite.getY() / SET_SIZE;

			
			switch (this.getStackOrder()) {
			case RIGHT:
				maker.setSprites(modifier.digRight(colonne, ligne, sprite));
				break;
			case LEFT:
				maker.setSprites(modifier.digLeft(colonne, ligne, sprite));
				break;
			case DOWN:
				maker.setSprites(modifier.digDown(colonne, ligne, sprite));
				break;
			case UP:
				maker.setSprites(modifier.digUp(colonne, ligne, sprite));
				break;
			case NOOP:
			default:
				break;
			}
			
			
			panel.update();
			stackOrder = UserOrder.NOOP;

		}
	}

	public UserOrder getStackOrder() {
		return stackOrder;
	}
	
	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

}
