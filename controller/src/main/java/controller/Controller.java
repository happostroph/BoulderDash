package controller;

import java.awt.Window;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import model.Permeability;
import model.UserOrder;
import view.IGravity;
import view.IMapMaker;
import view.IMonsterMove;
import view.IMove;
import view.IPanel;
import view.ISprite;
import view.SpriteType;

public class Controller implements IController, Observer {
	private UserOrder stackOrder = UserOrder.NOOP;
	private int i = 0, SET_SIZE = 0, colonne = 0, ligne = 0, finalDiamonds = 0;
	private IPanel panel;
	private ISprite sprite;
	private IMapMaker maker;
	private IMove move;
	private IGravity gravity;
	private Window window;
	private IMonsterMove monsterMove;
	
	/**
	 * Constructor of Controller
	 * 
	 * @param sprite
	 * @param panel
	 * @param SET_SIZE
	 * @param modifier
	 * @param maker
	 */

	public Controller(ISprite sprite, IPanel panel, int SET_SIZE, IMove move, IMapMaker maker, IGravity gravity, Window window, IMonsterMove monsterMove, int finalDiamonds) {
		this.panel = panel;
		this.sprite = sprite;
		this.SET_SIZE = SET_SIZE;
		this.move = move;
		this.maker = maker;
		this.gravity = gravity;
		this.window = window;
		this.monsterMove = monsterMove;
		this.finalDiamonds = finalDiamonds;
		move.setMapModifier(maker.getSprites(), SET_SIZE, panel);
	}

	/**
	 * move the character
	 */

	public final void directionControl() throws InterruptedException {
		if (sprite.getType() == SpriteType.CHARACTER) {
			Thread.sleep(100);
			maker.setAllHasMovedToFalse(maker.getSprites());
			monsterMove.toMoveTheMonsters(maker.getSprites());
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
	

			stackOrder = UserOrder.NOOP;
			if(gravity.isGameOver() || monsterMove.isGameOver() || move.isGameOver()){
				JOptionPane.showMessageDialog(null, "Game Over!");
				window.dispose();
			}
			if(panel.getDiamondsGet() == finalDiamonds){
				setExitToPermeable(maker.getSprites());
			}
			
			if(move.isVictory()){
//				maker.setDirtAndBackgroundToDiamond(maker.getSprites(), SET_SIZE);
//				panel.update();
				JOptionPane.showMessageDialog(null, "Victory!");
				window.dispose();
			}
			panel.update();
		}
	}

	public UserOrder getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

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
	
	public void setExitToPermeable(ISprite[][] sprites){
		for(ISprite[] sousSpit : sprites){
			for(ISprite spit : sousSpit){
				if(spit.getType() == SpriteType.EXIT){
					spit.setPermeability(Permeability.PERMEABLE);
				}
			}
		}
	}

}
