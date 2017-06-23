package main;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import controller.BDKeyListener;
import controller.Controller;
import model.dao.DAOTest;
import view.*;


public class Main implements LevelObservator {
	static MapMaker maker = null;
	static File music = null;
	static boolean test = true;

	final static int SET_SIZE = 16;

	static CreateMenu menu;

	public static void main(String[] args) throws IOException {
		menu = new CreateMenu();
		Main game = new Main();
		menu.getObservators().add(game);
	}

	@Override
	public void onLevelSelected(int level) {
		(new Thread(new Runnable() {

			@Override
			public void run() {
				DAOTest connectionBDD = new DAOTest();

				music = new File("music/pokemon.wav");

				connectionBDD.connection();
				connectionBDD.executeQuery(level);
				connectionBDD.setQueryIntoTable();
				try {
					
					connectionBDD.executeDiamondQuery(level);
					connectionBDD.setQueryDiamonds();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				TranslateMap translate;
				try {
					translate = new TranslateMap(connectionBDD.getTab());
					maker = new MapMaker(translate);
					maker.spritesCreation(SET_SIZE);

					Audio.PlaySound(music);

					BDKeyListener bdkeyListener = new BDKeyListener();
					
					Window window = new Window(maker, bdkeyListener, connectionBDD.getFinalDiamonds());

					Move move = new Move();
					Gravity gravity = new Gravity();
					Controller controller = new Controller(
							maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()), window.getPanel(),
							SET_SIZE, move, maker, gravity, window);
					bdkeyListener.addObserver(controller);
					bdkeyListener.setController(controller);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		})).start();
	}
}
