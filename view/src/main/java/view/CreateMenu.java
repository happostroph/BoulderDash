package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CreateMenu extends JFrame {
	int choice = 0;

	List<LevelObservator> observators = new ArrayList<>();
	
	public List<LevelObservator> getObservators() {
		return observators;
	}

	public void setObservators(List<LevelObservator> observators) {
		this.observators = observators;
	}

	public CreateMenu() {

		setSize(new Dimension(700, 400));

		setLayout(new BorderLayout());
		JLabel background = new JLabel(new ImageIcon("image/menu.png"));
		add(background);
		background.setLayout(new FlowLayout());

		JPanel boutonPane = new JPanel();

		JButton bouton2 = new JButton("Choose Level");
		bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				String[] level = { "Level 1", "Level 2", "Level 3", "Level 4", "Level 5" };
				JOptionPane jop = new JOptionPane();
				String name = (String) jop.showInputDialog(null, "Choose your level!", "The choise",
						JOptionPane.QUESTION_MESSAGE, null, level, level[2]);
				System.out.println(name);

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
				// System.out.println(choice);
				for (LevelObservator observator : observators) {
					observator.onLevelSelected(choice);
				}
			}
		});

		boutonPane.add(bouton2);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().add(boutonPane, BorderLayout.SOUTH);
		this.setVisible(true);
		System.out.println(choice);

	}

	public int getChoice() {
		return choice;
	}

}
