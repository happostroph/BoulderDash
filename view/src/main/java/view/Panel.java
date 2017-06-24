package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.Serializable;

import javax.swing.JPanel;

public class Panel extends JPanel implements Serializable, IPanel {
	private static final long serialVersionUID = 1L;
	protected Image buffer[][] = new Image[22][40];
	Font font = new Font("Courier", Font.BOLD, 15);
	private int diamondsGet = 0;
	private IMapMaker maker;
	private int finalDiamonds;

	/**
	 * The constructor of Panel
	 * 
	 * @param maker
	 *            the maker of the map
	 */
	public Panel(MapMaker maker, int finalDiamonds) {
		this.maker = maker;
		this.finalDiamonds = finalDiamonds;
	}

	/**
	 * Calls the draw functions of MapMaker
	 * 
	 * @param g
	 * 
	 */
	public void counterDiamond(Graphics g){
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Diamonds : " + diamondsGet + "/" + finalDiamonds, 10, 365);
	}
	
	/**
	 * @param g
	 */
	public void updateCount(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 500);
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		this.updateCount(g);
		this.counterDiamond(g);
		this.maker.drawMap(g);
	}

	/**
	 * Update the map when a mouvement is done
	 */
	@Override
	public void update() {
		this.repaint();
	}

	public int getDiamondsGet() {
		return diamondsGet;
	}

	public void setDiamondsGet(int diamondsGet) {
		this.diamondsGet = diamondsGet;
	}
}