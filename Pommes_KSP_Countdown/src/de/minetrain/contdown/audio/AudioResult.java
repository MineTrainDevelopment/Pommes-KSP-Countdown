package de.minetrain.contdown.audio;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.scheduler.Scheduler;

public class AudioResult {
	
	public static void PlaySound(){
		int sec = Scheduler.sec;
		int min = Scheduler.min;
		int h = Scheduler.h;
		boolean TimerPlus = Scheduler.TimerPlus;
		File file;
		if(min!=0 || h!=0){return;}
		if(Controller.Audio==false){return;}
		
		AudioResult.CheckRandomMode();
		
		if(TimerPlus==false){
			file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\"+Controller.AudioModus+"-"+sec+".wav");
		}else{
			switch (sec){
			case 1: file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\egni.wav"); break;
			case 2: file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\liftoff.wav"); break;
			case 19: file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\normal.wav"); break;
			case 24: file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\downrange.wav"); break;
			case 59: file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\maxq.wav"); break;
			default: file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\"+Controller.AudioModus+"+"+sec+".wav"); break;}
		}
		
		ReturnAudio(file);
	}
	
	
	/**
	* @param  ReturnAudio (new File("C:\\ProgramData\\audio.wav"));
	* @return      Play the audio if your File exist
	*/
	public static void ReturnAudio(File file){try{
		if(file.exists()){
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			clip.start();
		}
		}catch(UnsupportedAudioFileException | IOException | LineUnavailableException e){e.printStackTrace();}
	}
	
	public static void CheckRandomMode(){
		if(Controller.Random==true){
			Random random = new Random();
			int i = random.nextInt(2);
			System.out.println(i);
			
			switch (i){
			case 1: Controller.AudioModus="SpaceX"; break;
			default: Controller.AudioModus="MineTrain"; break;}
		}
	}

}
