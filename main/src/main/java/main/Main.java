package main;

import model.dao.DAOTest;
import view.MapMaker;
import view.TranslateMap;
import view.Window;

public class Main {

	public static void main(String[] args) {
		
		DAOTest connectionBDD = new DAOTest();
		
		connectionBDD.connection();
		connectionBDD.executeQuery();
		connectionBDD.setQueryIntoTable();
		
		TranslateMap translate = new TranslateMap(connectionBDD);
		MapMaker maker = new MapMaker(translate);
		maker.spritesCreation();
		Window window = new Window(maker);
		
	}
}

