package view;

import java.awt.Graphics;
import java.util.List;
import java.util.Observable;

public interface ICreateMenu {
	public List<LevelObservator> getObservators();
	
	public void setObservators(List<LevelObservator> observators);
	
	public int getChoice();

	public void update(Observable obs, Object obj);
	
	public void drawPseudo(Graphics g);

	public String getPseudo();

	public void setPseudo(String pseudo);
}
