package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import model.UserOrder;

public class BDKeyListener implements KeyListener, IBDKeyListener{
	IController controller;
	
	public BDKeyListener(){
		
	}
	
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
		try {
			this.getController().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
