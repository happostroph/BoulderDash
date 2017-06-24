package controller;

import model.UserOrder;

public interface IController {
	/**
	 * @throws InterruptedException
	 */
	public void directionControl() throws InterruptedException;
	
	/**
	 * @param userOrder
	 */
	public void setStackOrder(final UserOrder userOrder);

}
