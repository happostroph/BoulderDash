package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class TranslateMap implements ITranslateMap {
	private HashMap<Character, Image> translator = new HashMap<>();
	private Image map[][] = new Image[22][40];

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

		this.translator.put('#', ImageIO.read(new File("image/01.png")));
		this.translator.put('X', ImageIO.read(new File("image/02.png")));
		this.translator.put('_', ImageIO.read(new File("image/03.png")));
		this.translator.put('O', ImageIO.read(new File("image/04.png")));
		this.translator.put('V', ImageIO.read(new File("image/05.png")));
		this.translator.put('E', ImageIO.read(new File("image/06.png")));
		this.translator.put('M', ImageIO.read(new File("image/07.png")));
		this.translator.put('S', ImageIO.read(new File("image/08.png")));
		this.translator.put('m', ImageIO.read(new File("image/09.png")));

		/*
		 * Fill a two-dimensional Image table in terms of what contains tab
		 */

		int ligne = 0, colonne = 0;
		for (char sousTab[] : tab) {
			colonne = 0;
			for (char chr : sousTab) {
				if (this.translator.containsKey(chr)) {
					map[ligne][colonne] = this.translator.get(chr);
				} else {
					System.out.println("Error TranslateMap");
				}
				colonne++;
			}
			ligne++;
		}
	}

	/**
	 * @return map a two-dimensional Image table which contains the map in the
	 *         form of pictures
	 */
	public Image[][] getMap() {
		return map;
	}
}
