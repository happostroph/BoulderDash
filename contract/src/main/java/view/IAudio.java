package view;

import java.io.File;

public interface IAudio {
	/**
	 * Play the sound which correspond the the File
	 * 
	 * @param Sound
	 * @param gain
	 */
	public void playSound(File Sound, float gain);

	public void stopSound();
}
