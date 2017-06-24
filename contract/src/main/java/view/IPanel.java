package view;

import java.awt.Graphics;

public interface IPanel {
	/**
	 * Paint the component
	 * @param g
	 */
	public void paintComponent(Graphics g);

	/**
	 * update the map
	 */
	public void update();
	
	/**
	 * Getter of diamondGet
	 * @return diamondGet
	 */
	public int getDiamondsGet();

	/**
	 * Setter of diamondGet
	 * @param diamondsGet
	 */
	public void setDiamondsGet(int diamondsGet);
}
