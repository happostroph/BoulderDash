package controller;

import java.util.Observable;
import java.util.Observer;

import model.UserOrder;
import view.IGravity;
import view.IMapMaker;
import view.IMove;
import view.IPanel;
import view.ISprite;

public class Controller implements IController, Observer {
	private UserOrder stackOrder = UserOrder.NOOP;
	int i = 0, SET_SIZE = 0, colonne = 0, ligne = 0;
	private IPanel panel;
	private ISprite sprite;
	private IMapMaker maker;
	private IMove move;
	private IGravity gravity;

	/**
	 * Constructor of Controller
	 * 
	 * @param sprite
	 * @param panel
	 * @param SET_SIZE
	 * @param modifier
	 * @param maker
	 */

	public Controller(ISprite sprite, IPanel panel, int SET_SIZE, IMove move, IMapMaker maker,
			IGravity gravity) {
		this.panel = panel;
		this.sprite = sprite;
		this.SET_SIZE = SET_SIZE;
		this.move = move;
		this.maker = maker;
		this.gravity = gravity;
		move.setMapModifier(maker.getSprites(), SET_SIZE);
	}

	/**
	 * move the character
	 */

	public final void directionControl() throws InterruptedException {
		Thread.sleep(100);
		maker.setAllHasMovedToFalse(maker.getSprites());

		colonne = sprite.getX() / SET_SIZE;
		ligne = sprite.getY() / SET_SIZE;

		switch (this.getStackOrder()) {
		case RIGHT:
			maker.setSprites(move.digRight(colonne, ligne, sprite));
			break;
		case LEFT:
			maker.setSprites(move.digLeft(colonne, ligne, sprite));
			break;
		case DOWN:
			maker.setSprites(move.digDown(colonne, ligne, sprite));
			break;
		case UP:
			maker.setSprites(move.digUp(colonne, ligne, sprite));
			break;
		case NOOP:
		default:
			break;
		}
		gravity.makeThemSlide(maker.getSprites());
		gravity.makeThemFall(maker.getSprites());
		panel.update();
		stackOrder = UserOrder.NOOP;

	}

	public UserOrder getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	@Override
	public void update(Observable obs, Object obj) {
		if (obs instanceof BDKeyListener) {
			try {
				directionControl();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
