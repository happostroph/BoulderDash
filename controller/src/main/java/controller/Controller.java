package controller;

import java.io.IOException;

import model.UserOrder;
import view.IMapMaker;
import view.IPanel;
import view.ISprite;

public class Controller implements IController{
	private UserOrder stackOrder = UserOrder.NOOP;
	int i = 0;
	IPanel panel;
	ISprite sprite;
	IMapMaker maker;

	public Controller(ISprite sprite, IPanel panel) {
		this.panel = panel;
		this.sprite = sprite;
	}

	public Controller(ISprite sprite, IMapMaker maker) {
		this.sprite = sprite;
		this.maker = maker;
	}

	public final void play() throws InterruptedException {
		while (i < 200) {
			Thread.sleep(40);
			switch (this.getStackOrder()) {
			case RIGHT:
				sprite.setX(sprite.getX() + 16);
				break;
			case LEFT:
				sprite.setX(sprite.getX() - 16);
				break;
			case DOWN:
				sprite.setY(sprite.getY() + 16);
				break;
			case UP:
				sprite.setY(sprite.getY() - 16);
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
