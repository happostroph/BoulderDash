package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import view.ICreateMenu;

public class PseudoKeyListener extends Observable implements KeyListener, IPseudoKeyListener{
	private ICreateMenu createMenu;
	private String str = "";
	
	/**
	 * It return the direction corresponding to the key pressed
	 * @param keyCode
	 * 			The value corresponding to the key pressed
	 * @return userOrder
	 */
	
	public String keyCodeToString(final int keyCode) {
		str += (char)keyCode;
		return str;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent keyEvent) {
//		this.getController().setStackOrder(keyCodeToUserOrder(keyEvent.getKeyCode()));
		this.getCreateMenu().setPseudo(keyCodeToString(keyEvent.getKeyCode()));
		setChanged();
		notifyObservers(keyEvent);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	/* (non-Javadoc)
	 * @see controller.IBDKeyListener#getController()
	 */
	public ICreateMenu getCreateMenu() {
		return this.createMenu;
	}

	/* (non-Javadoc)
	 * @see controller.IBDKeyListener#setController(controller.IController)
	 */

	public void setCreateMenu(ICreateMenu createMenu) {
		this.createMenu =  createMenu;
	}
}