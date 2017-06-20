package view;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Audio implements IAudio{
 /**
  * Play a sound in wav formats
  * @param Sound
  * 			String which contain the path to the sound
  */
	
	 public static void PlaySound(File Sound) {
		try{
			
		Clip clip = AudioSystem.getClip();
		clip.open(AudioSystem.getAudioInputStream(Sound));
		clip.start();
		
		FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		volume.setValue(-20.0f);
		
		}
		
		catch(Exception e){
			
		}
	}
	
}
