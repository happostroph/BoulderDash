package controller;

import java.io.File;

import model.dao.LaunchDBQuery;
import view.Audio;
import view.CreateMenu;
import view.LevelObservator;
import view.MapMaker;
import view.TranslateMap;
import view.Window;

public class Launcher implements LevelObservator {
	private static CreateMenu menu;
	private static MapMaker maker = null;
	static File music = null;
	private final static int SET_SIZE = 16;

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
				LaunchDBQuery launchDBQueries = new LaunchDBQuery(level);
				launchDBQueries.launchQueries();
				TranslateMap translate;

				try {

					translate = new TranslateMap(launchDBQueries.getTab());
					maker = new MapMaker(translate);
					maker.spritesCreation(SET_SIZE);

					
					BDKeyListener bdkeyListener = new BDKeyListener();
					Window window = new Window(maker, bdkeyListener, launchDBQueries.getFinalDiamonds(), level);
					EndTheGame end = new EndTheGame(window.getPanel(), window);
					Audio backSound = new Audio();
					Controller controller = new Controller(
							maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()), window.getPanel(),
							SET_SIZE, maker, launchDBQueries.getFinalDiamonds(), end, backSound);
					
					bdkeyListener.addObserver(controller);
					bdkeyListener.setController(controller);
					
					
					GameLoop gameLoop = new GameLoop(maker, window.getPanel(), end, backSound);
					gameLoop.loop();

				} catch (Exception e1) {
					e1.printStackTrace();

				}
			}
		})).start();
	}
}