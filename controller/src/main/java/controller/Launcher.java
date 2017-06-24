package controller;

import java.io.File;
import java.sql.SQLException;

import model.dao.DAOTest;
import view.CreateMenu;
import view.LevelObservator;
import view.MapMaker;
import view.TranslateMap;
import view.Window;

public class Launcher implements LevelObservator {
	static CreateMenu menu;
	static MapMaker maker = null;
	static File music = null;
	static boolean test = true;
	final static int SET_SIZE = 16;

	/**
	 * Constructor of Launcher
	 */
	public Launcher() {
		menu = new CreateMenu();
		menu.getObservators().add(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see view.LevelObservator#onLevelSelected(int)
	 */

	@Override
	public void onLevelSelected(int level) {
		(new Thread(new Runnable() {
			@Override
			public void run() {
				DAOTest connectionBDD = new DAOTest();
				connectionBDD.connection();
				connectionBDD.executeQuery(level);
				connectionBDD.setQueryIntoTable();

				try {
					connectionBDD.executeDiamondQuery(level);
					connectionBDD.setQueryDiamondsInToInteger();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				TranslateMap translate;

				try {

					translate = new TranslateMap(connectionBDD.getTab());
					maker = new MapMaker(translate);
					maker.spritesCreation(SET_SIZE);

					BDKeyListener bdkeyListener = new BDKeyListener();
					Window window = new Window(maker, bdkeyListener, connectionBDD.getFinalDiamonds(), level);
					Controller controller = new Controller(
							maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()), window.getPanel(),
							SET_SIZE, maker, window, connectionBDD.getFinalDiamonds());

					bdkeyListener.addObserver(controller);
					bdkeyListener.setController(controller);

				} catch (Exception e1) {
					e1.printStackTrace();

				}
			}
		})).start();
	}
}
