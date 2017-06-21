package controller;

import java.io.IOException;

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

	public Controller(ISprite sprite, IPanel panel, int SET_SIZE, IMapModifier modifier, IMapMaker maker) {
		this.panel = panel;
		this.sprite = sprite;
		this.SET_SIZE = SET_SIZE;
		this.modifier = modifier;
		this.maker = maker;
		modifier.setMapModifier(maker.getSprites(), SET_SIZE);
	}

	public Controller(ISprite sprite, IMapMaker maker) {
		this.sprite = sprite;
		this.maker = maker;

	}

	public final void play() throws InterruptedException {
		while (i < 2000) {
			Thread.sleep(40);
			colonne = sprite.getX() / SET_SIZE;
			ligne = sprite.getY() / SET_SIZE;
			if (colonne <= 0) {
				colonne = 0;
			}
			if (colonne >= 40) {
				colonne = 40;
			}
			if (ligne <= 0) {
				ligne = 0;
			}
			if (ligne >= 22) {
				ligne = 22;
			}
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
			i++;

		}
	}

	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	public UserOrder getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

}
