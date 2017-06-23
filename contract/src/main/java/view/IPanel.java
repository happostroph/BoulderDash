package view;

import java.awt.Graphics;

public interface IPanel {
	public void paintComponent(Graphics g);

	public void update();
	
	public int getDiamondsGet();

	public void setDiamondsGet(int diamondsGet);
}
