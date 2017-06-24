package controller;

import javax.swing.JOptionPane;

import view.Audio;
import view.IPanel;
import view.Window;

public class EndTheGame {
	private IPanel panel;
	private Window window;
	private Audio audio;
	
	public EndTheGame(IPanel panel, Window window, Audio audio){
		this.panel = panel;
		this.window = window;
		this.audio = audio;
	}
	
	public void gameOver(){
		panel.update();
		JOptionPane.showMessageDialog(null, "Game Over!");
		window.dispose();
		audio.stopSound();
	}
	
	public void victory(){
		
		panel.update();
		JOptionPane.showMessageDialog(null, "Victory!");
		window.dispose();
		audio.stopSound();
	}
}
