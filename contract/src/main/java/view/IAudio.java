package view;

import java.io.File;

public interface IAudio {
	/**
	 * Play the sound which correspond the the File
	 * 
	 * @param Sound
	 */
	public void playSound(File Sound);

	public void stopSound();
}
