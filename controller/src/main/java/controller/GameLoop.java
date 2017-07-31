package controller;

import view.Audio;
import view.Gravity;
import view.IPanel;
import view.MapMaker;
import view.MonsterMove;

public class GameLoop {
	private MapMaker maker;
	private Gravity gravity;
	private Audio gravitySounds;
	private Audio gameOver;
	private Audio backSound;
	private MonsterMove monsterMove;
	private IPanel panel;
	private EndTheGame end;
	private boolean loop = true;

	public GameLoop(MapMaker maker, IPanel panel, EndTheGame end, Audio backSound) {
		this.maker = maker;
		this.panel = panel;
		this.end = end;
		this.backSound = backSound;
		gravity = new Gravity();
		gravitySounds = new Audio();
		monsterMove = new MonsterMove();
		gameOver = new Audio();
	}

	public void loop() throws InterruptedException {
		while (loop) {
			Thread.sleep(250);
			maker.setAllHasMovedToFalse(maker.getSprites());
			gravity.makeThemSlide(maker.getSprites());
			gravity.makeThemFall(maker.getSprites(), gravitySounds, this.panel);
			monsterMove.toMoveTheMonsters(maker.getSprites(), gravitySounds);
			if (gravity.isGameOver() || monsterMove.isGameOver()) {
				backSound.stopSound();
				end.gameOver(gameOver);
				loop = false;
			}
			panel.update();
		}
	}
}
