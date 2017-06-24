package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import model.UserOrder;

/**
 * @author maxim
 *
 */
public class BDKeyListener extends Observable implements KeyListener, IBDKeyListener{
	IController controller;
	
	/**
	 * It return the direction corresponding to the key pressed
	 * @param keyCode
	 * 			The value corresponding to the key pressed
	 * @return userOrder
	 */
	
	public UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOOP;
			break;
		}
		return userOrder;
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		this.getController().setStackOrder(keyCodeToUserOrder(keyEvent.getKeyCode()));
		setChanged();
		notifyObservers(keyEvent);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	public IController getController() {
		return this.controller;
	}

	public void setController(IController controller) {
		this.controller =  controller;
	}
}