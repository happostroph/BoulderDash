package controller;

import model.UserOrder;

public interface IBDKeyListener {
	public UserOrder keyCodeToUserOrder(final int keyCode);
	
	public IController getController();

	public void setController(IController controller);
}
