package main;

import java.io.File;

import model.dao.*;
import view.Audio;
import view.*;

public class Main implements Runnable{
	
	static MapMaker maker = null;
	static File music = null;
	
	final int SET_SIZE = 16;
	
	/**
	 * Multi-threading for the window, to get better perform, and for playing the sound in the same times of the launch time of the window
	 */
	public void run(){
		maker.spritesCreation(SET_SIZE);
		Window window = new Window(maker);
		
		Audio.PlaySound(music);
	}
		
	public static void main(String[] args) {
		
		
		DAOTest connectionBDD = new DAOTest();
		
		connectionBDD.connection();
		connectionBDD.executeQuery();
		connectionBDD.setQueryIntoTable();
		
		TranslateMap translate = new TranslateMap(connectionBDD.getTab());
		maker = new MapMaker(translate.getMap());
		music = new File("music/pokemon.wav");
		
		Main m1 = new Main();
		Thread t1 =new Thread(m1);  
		t1.start();
		
	}
}

