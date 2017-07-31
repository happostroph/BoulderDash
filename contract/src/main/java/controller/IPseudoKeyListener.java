package controller;

import java.awt.event.KeyEvent;

import view.ICreateMenu;

public interface IPseudoKeyListener {
	public String keyCodeToString(final int keyCode);
	
	public void keyPressed(KeyEvent keyEvent);
	
	public void keyReleased(KeyEvent e);
	
	public void keyTyped(KeyEvent e);
	
	public ICreateMenu getCreateMenu();
	
	public void setCreateMenu(ICreateMenu createMenu);
}
