package view;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TranslateMap implements ITranslateMap {
	private Map<Character, SpriteType> translator = new HashMap<>();
	private int characterX = 0, characterY = 0;
	private SpriteType map[][] = new SpriteType[22][40];

	/**
	 * The constructor of TranslateMap
	 * 
	 * @param tab
	 *            the character table which contains the map in the form of
	 *            characters
	 * @throws IOException
	 */
	public TranslateMap(char[][] tab) throws IOException {

		/*
		 * Fill translator with the pictures which correspond to the characters
		 */
		this.translator.put('#', SpriteType.UNBREAKABLE);// ('#',
															// SpriteType.UNBREAKABLE);
		this.translator.put('X', SpriteType.DIRT);
		this.translator.put('_', SpriteType.BACKGROUND);
		this.translator.put('O', SpriteType.ROCK);
		this.translator.put('V', SpriteType.DIAMOND);
		this.translator.put('E', SpriteType.EXIT);
		this.translator.put('M', SpriteType.MONSTER);
		this.translator.put('S', SpriteType.CHARACTER);
		this.translator.put('m', SpriteType.MONSTER);

		/*
		 * Fill a two-dimensional Image table in terms of what contains tab
		 */
		int ligne = 0, colonne = 0;
		for (char sousTab[] : tab) {
			colonne = 0;
			for (char chr : sousTab) {
				if (this.translator.containsKey(chr)) {
					map[ligne][colonne] = this.translator.get(chr);
					if (chr == 'S') {
						characterX = colonne;
						characterY = ligne;
					}
				} else {
					System.out.println("Error TranslateMap");
				}
				colonne++;
			}
			ligne++;
		}
	}

	/**
	 * @return map a two-dimensional SpriteType table which contains the map in
	 *         the form of enum
	 */
	public SpriteType[][] getMap() {
		return map;
	}

	/* (non-Javadoc)
	 * @see view.ITranslateMap#getCharacterX()
	 */
	public int getCharacterX() {
		return characterX;
	}

	/* (non-Javadoc)
	 * @see view.ITranslateMap#getCharacterY()
	 */
	public int getCharacterY() {
		return characterY;
	}
}