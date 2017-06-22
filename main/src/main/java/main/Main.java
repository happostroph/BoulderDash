package main;

import java.io.File;
import java.io.IOException;

import controller.BDKeyListener;
import controller.Controller;
import model.dao.DAOTest;
import view.Audio;
import view.CreateMenu;
import view.Gravity;
import view.LevelObservator;
import view.MapMaker;
import view.MapModifier;
import view.TranslateMap;
import view.Window;

public class Main implements LevelObservator {
	static MapMaker maker = null;
	static File music = null;
	static boolean test = true;

	final static int SET_SIZE = 16;

	static CreateMenu menu;

	public static void main(String[] args) throws IOException {
		menu = new CreateMenu();
		Main toto = new Main();
		menu.getObservators().add(toto);

	}

	@Override
	public void onLevelSelected(int level) {
		(new Thread(new Runnable() {

			@Override
			public void run() {
				menu.dispose();
				DAOTest connectionBDD = new DAOTest();

				music = new File("music/pokemon.wav");

				connectionBDD.connection();
				System.out.println("test");
				connectionBDD.executeQuery(level);
				connectionBDD.setQueryIntoTable();

				TranslateMap translate;
				try {
					translate = new TranslateMap(connectionBDD.getTab());
					maker = new MapMaker(translate);
					maker.spritesCreation(SET_SIZE);

					Audio.PlaySound(music);

					BDKeyListener bdkeyListener = new BDKeyListener();
					Window window = new Window(maker, bdkeyListener);

					MapModifier modifier = new MapModifier();
					Gravity gravity = new Gravity();
					Controller controller = new Controller(
							maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()), window.getPanel(),
							SET_SIZE, modifier, maker, gravity);

					bdkeyListener.setController(controller);

					controller.directionControl();

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		})).start();
	}
}
