package controller;

import java.io.IOException;

import model.UserOrder;

/**
 * <h1>The Interface IController.</h1>
 * 
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IController {
	public void directionControl() throws InterruptedException;
	
	public void setStackOrder(final UserOrder userOrder);

}
