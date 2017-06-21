package main;

import java.io.File;
import java.io.IOException;

import controller.BDKeyListener;
import controller.Controller;
import model.dao.DAOTest;
import view.Audio;
import view.MapMaker;
import view.MapModifier;
import view.TranslateMap;
import view.Window;

public class Main implements Runnable {
//	Image image;
	static MapMaker maker = null;
	static File music = null;

	final static int SET_SIZE = 16;

	/**
	 * Multi-threading for the window, to get better perform, and for playing
	 * the sound in the same times of the launch time of the window
	 */

//	public void run() {
//		try {
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}

	public static void main(String[] args) throws IOException {
//		image = ImageIO.read(new File("image/01.png"));
//		Sprite sprite = new Sprite(image, 0, 0);
		DAOTest connectionBDD = new DAOTest();

		connectionBDD.connection();
		connectionBDD.executeQuery();
		connectionBDD.setQueryIntoTable();
		TranslateMap translate = new TranslateMap(connectionBDD.getTab());
		maker = new MapMaker(translate);
		maker.spritesCreation(SET_SIZE);
		BDKeyListener bdkeyListener = new BDKeyListener();
		Window window = new Window(maker, bdkeyListener);
		MapModifier modifier = new MapModifier();
		Controller controller = new Controller(maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()), window.getPanel(), SET_SIZE, modifier, maker);
		bdkeyListener.setController(controller);
		
		Audio.PlaySound(music);
		try {
			controller.play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		music = new File("music/pokemon.wav");
//		Main m1 = new Main();
//		Thread t1 = new Thread(m1);
//		t1.start();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
