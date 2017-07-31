package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.IPseudoKeyListener;


public class CreateMenu extends JFrame implements Observer, ICreateMenu {

	private static final long serialVersionUID = 1L;
	private Font font = new Font("Courier", Font.BOLD, 15);
	private int choice = 0;
	private String pseudo = "";
	private MenuPanel menuPanel;
//	private JLabel background;
	private Image image;
	List<LevelObservator> observators = new ArrayList<>();

	/**
	 * Getter of observators
	 * @return observators
	 */
	public List<LevelObservator> getObservators() {
		return observators;
	}

	/**
	 * Setter of observators
	 * @param observators
	 */
	public void setObservators(List<LevelObservator> observators) {
		this.observators = observators;
	}

	/**
	 * Method which create the Menu
	 * @throws IOException 
	 */
	public CreateMenu(IPseudoKeyListener pseudoKeyListener) throws IOException {
		setSize(new Dimension(700, 400));
		setResizable(false);
		setLayout(new BorderLayout());
		setFocusable(true);
		addKeyListener((KeyListener) pseudoKeyListener);
//		background = new JLabel(new ImageIcon("image/menu.png"));
		image = ImageIO.read(new File("image/menu.png"));
//		add(background);
//		background.setLayout(new FlowLayout());
		menuPanel = new MenuPanel(this);
		JButton bouton2 = new JButton("Choose Level");
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String[] level = {"Score", "Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
				JOptionPane jop = new JOptionPane();
				String name = (String) jop.showInputDialog(null, "Choose your level!", "The choice",
						JOptionPane.QUESTION_MESSAGE, null, level, level[2]);
				if (name == "Level 1") {
					choice = 1;
				}
				if (name == "Level 2") {
					choice = 2;
				}
				if (name == "Level 3") {
					choice = 3;
				}
				if (name == "Level 4") {
					choice = 4;
				}
				if (name == "Level 5") {
					choice = 5;
				}
				if (name == "Score"){
					choice = 42;
				}
				for (LevelObservator observator : observators) {
					observator.onLevelSelected(choice, pseudo);
				}
			}
		});
		menuPanel.add(bouton2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(menuPanel, BorderLayout.SOUTH);
		this.setContentPane(menuPanel);
		this.setVisible(true);
	}

	/**
	 * Getter of choice
	 * @return choice
	 */
	public int getChoice() {
		return choice;
	}

	@Override
	public void update(Observable obs, Object obj) {
		// TODO Auto-generated method stub
		if (obs instanceof IPseudoKeyListener) {
			System.out.println(this.pseudo);
			this.menuPanel.update();
		}
	}
	
	public void drawPseudo(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 500);
		g.drawImage(image, 175, 50, null);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("Please enter a pseudonyme before playing ;)", 10, 320);
		g.drawString(this.pseudo, 10, 360);
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}