package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import model.IDAOTest;

public class TranslateMap implements ITranslateMap {
	private HashMap<Character, Image> translator = new HashMap<>();
	private Image image[] = new Image[9];
	private Image map[][] = new Image[22][40];

	/**
	 * Fill a Image table with the differents sprites which are possible
	 */

	{
		try {
			image[0] = ImageIO.read(new File("01.png"));
			image[1] = ImageIO.read(new File("02.png"));
			image[2] = ImageIO.read(new File("03.png"));
			image[3] = ImageIO.read(new File("04.png"));
			image[4] = ImageIO.read(new File("05.png"));
			image[5] = ImageIO.read(new File("06.png"));
			image[6] = ImageIO.read(new File("07.png"));
			image[7] = ImageIO.read(new File("08.png"));
			image[8] = ImageIO.read(new File("09.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * The constructor of TranslateMap
	 * 
	 * @param tab
	 *            the character table which contains the map in the form of
	 *            characters
	 */
	public TranslateMap(char[][] tab) {

		/*
		 * Fill translator with the pictures which correspond to the characters
		 */

		this.translator.put('#', image[0]);
		this.translator.put('X', image[1]);
		this.translator.put('_', image[2]);
		this.translator.put('O', image[3]);
		this.translator.put('V', image[4]);
		this.translator.put('E', image[5]);
		this.translator.put('M', image[6]);
		this.translator.put('S', image[7]);
		this.translator.put('m', image[8]);


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
 * @return map
 * 				a two-dimensional Image table which contains the map in the form of pictures
 */
	public Image[][] getMap() {
		return map;
	}
}
