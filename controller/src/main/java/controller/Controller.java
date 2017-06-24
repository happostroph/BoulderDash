package controller;

import java.awt.Window;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import model.Permeability;
import model.UserOrder;
import view.Audio;
import view.Gravity;
import view.IAudio;
import view.IGravity;
import view.IMapMaker;
import view.IMonsterMove;
import view.IMove;
import view.IPanel;
import view.ISprite;
import view.IVictoryDiamonds;
import view.MonsterMove;
import view.SpriteType;
import view.VictoryDiamonds;
import view.move.Move;

public class Controller implements IController, Observer {
	private UserOrder stackOrder = UserOrder.NOOP;
	private int SET_SIZE = 0, colonne = 0, ligne = 0, finalDiamonds = 0;
	private IPanel panel;
	private ISprite sprite;
	private IMapMaker maker;
	 private IMove move;
	 private IGravity gravity;
	private Window window;
	 private IMonsterMove monsterMove;
	 private IVictoryDiamonds victoryDiamonds;
	 private IAudio audio;

	/**
	 * Constructor of Controller
	 * 
	 * @param sprite
	 * @param panel
	 * @param SET_SIZE
	 * @param move
	 * @param maker
	 * @param gravity
	 * @param window
	 * @param monsterMove
	 * @param finalDiamonds
	 * @param victoryDiamonds
	 * @param audio
	 */
	public Controller(ISprite sprite, IPanel panel, int SET_SIZE, IMapMaker maker, Window window, int finalDiamonds, Move move) {
		

		this.panel = panel;
		this.sprite = sprite;
		this.SET_SIZE = SET_SIZE;
		this.maker = maker;
		this.window = window;
		this.finalDiamonds = finalDiamonds;
		this.move = move;
		

		gravity = new Gravity();
		monsterMove = new MonsterMove();
		victoryDiamonds = new VictoryDiamonds();
		audio = new Audio();
		audio.playSound(new File("music/pokemon.wav"));
	}

	/**
	 * move the character
	 */

	public final void directionControl() throws InterruptedException {
		if (sprite.getType() == SpriteType.CHARACTER) {

			Thread.sleep(100);
			maker.setAllHasMovedToFalse(maker.getSprites());
			move.setVictory(false);
			move.gameOver(false);

			colonne = sprite.getX() / SET_SIZE;
			ligne = sprite.getY() / SET_SIZE;

			switch (this.getStackOrder()) {
			case RIGHT:
				maker.setSprites(move.digRight(colonne, ligne, sprite));
				break;
			case LEFT:
				maker.setSprites(move.digLeft(colonne, ligne, sprite));
				break;
			case DOWN:
				maker.setSprites(move.digDown(colonne, ligne, sprite));
				break;
			case UP:
				maker.setSprites(move.digUp(colonne, ligne, sprite));
				break;
			case NOOP:
			default:
				break;
			}
			gravity.makeThemSlide(maker.getSprites());
			gravity.makeThemFall(maker.getSprites());

			if (move.isGameOver()) {
				panel.update();
				JOptionPane.showMessageDialog(null, "Game Over!");
				window.dispose();
				audio.stopSound();
			}

			monsterMove.toMoveTheMonsters(maker.getSprites());

			if (gravity.isGameOver() || monsterMove.isGameOver()) {
				panel.update();
				JOptionPane.showMessageDialog(null, "Game Over!");
				window.dispose();
				audio.stopSound();
			}

			if (panel.getDiamondsGet() >= finalDiamonds) {
				setExitToPermeable(maker.getSprites());
			}

			if (move.isVictory()) {
				victoryDiamonds.setDirtAndBackgroundToDiamond(maker.getSprites(), SET_SIZE);
				panel.update();
				JOptionPane.showMessageDialog(null, "Victory!");
				window.dispose();
				audio.stopSound();
			}
			stackOrder = UserOrder.NOOP;
			panel.update();
		}
	}

	/**
	 * @return stackOrder
	 */
	public UserOrder getStackOrder() {
		return stackOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.IController#setStackOrder(model.UserOrder)
	 */
	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable obs, Object obj) {
		if (obs instanceof BDKeyListener) {
			try {
				directionControl();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Permit to exit
	 * 
	 * @param sprites
	 */
	public void setExitToPermeable(ISprite[][] sprites) {
		for (ISprite[] sousSpit : sprites) {
			for (ISprite spit : sousSpit) {
				if (spit.getType() == SpriteType.EXIT) {
					spit.setPermeability(Permeability.PERMEABLE);
				}
			}
		}
	}
}
