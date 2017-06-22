package main;

import java.io.File;
import java.io.IOException;

import controller.BDKeyListener;
import controller.Controller;
import model.dao.DAOTest;
import view.Audio;
import view.Gravity;
import view.MapMaker;
import view.MapModifier;
import view.TranslateMap;
import view.Window;

public class Main {
	static MapMaker maker = null;
	static File music = null;

	final static int SET_SIZE = 16;

	public static void main(String[] args) throws IOException {

		DAOTest connectionBDD = new DAOTest();
		music = new File("music/pokemon.wav");
		
		connectionBDD.connection();
		connectionBDD.executeQuery();
		connectionBDD.setQueryIntoTable();
		
		TranslateMap translate = new TranslateMap(connectionBDD.getTab());
		maker = new MapMaker(translate);
		maker.spritesCreation(SET_SIZE);
		
		Audio.PlaySound(music);
		
		BDKeyListener bdkeyListener = new BDKeyListener();
		Window window = new Window(maker, bdkeyListener);
		
		MapModifier modifier = new MapModifier();
		Gravity gravity = new Gravity();
		Controller controller = new Controller(maker.getCharacter(translate.getCharacterX(), translate.getCharacterY()), window.getPanel(), SET_SIZE, modifier, maker, gravity);
		
		bdkeyListener.setController(controller);
		
		
		
		try {
			controller.directionControl();
		} 
		
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		

	}

}
