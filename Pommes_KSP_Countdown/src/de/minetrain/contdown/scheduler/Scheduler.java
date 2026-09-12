package de.minetrain.contdown.scheduler;

import java.awt.Color;
import java.io.File;

import de.minetrain.contdown.audio.AudioResult;
import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.litesql.Database;
import de.minetrain.contdown.main.Controller;

public class Scheduler {
	public static String Countdown="00:00:00";
	public static int sec;
	public static int min;
	public static int h;
	public static int PREsec;
	public static int PREmin;
	public static int PREh;
	public static boolean TimerPlus=false;
	public static String Tplus="T- ";
	static int i=0;
	
	public static void StartScheduler(){
		new Thread(()->{
			while(true){
				i++;
				if(Controller.TimmerRunning==true && Controller.TimmerPause==false){TimerScheduler();}
				if(i>=60){i=0; Database.SaveSettings();}
				try{Thread.sleep(1000);}catch(InterruptedException e){ }
			}
		}).start();
	}
	
	
	public static void TimerScheduler(){
		if(TimerPlus == false) {
			if(min==0) {if(h>0 && sec==0){h--;}}
			if(sec==0) {sec=60; if(min!=0){min--;}else{min=59;}}
			sec--;
			if(sec==0 && min==0 && h==0) {TimerPlus=true; Tplus="T- ";}
			} else {
				Tplus="T+ ";
				if(sec<59) {sec++;} else {if(min<59) {min++; sec = 0;} else {h++; h = 0;}}
			}
		Scheduler.UpdateTimer(true);
	}
	
	
	public static void ResetCountdown(){
		Controller.TimmerRunning=false;
		sec=PREsec; min=PREmin; h=PREh; TimerPlus=false; Tplus="T- ";
		MainFrame.Timer.setText(Timer());
		OBSFrame.Timer.setText(Timer());
		MainFrame.Timer.setForeground(new Color(200,000,000));
		OBSFrame.Timer.setForeground(new Color(200,000,000));
	}
	
	public static void StartCountdown(){
		if(Controller.TimmerPause==true){ResumCountdown(); return;}
		Controller.TimmerRunning=true;
		MainFrame.Timer.setText(Timer());
		OBSFrame.Timer.setText(Timer());
		MainFrame.Timer.setForeground(new Color(000,200,000));
		OBSFrame.Timer.setForeground(new Color(000,200,000));
		

		AudioResult.CheckRandomMode();
		if(Controller.Audio==true){
			switch (Controller.TimerPreset){
			case 1: AudioResult.ReturnAudio(new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\"+Controller.AudioModus+"-15.wav")); break;
			case 2: AudioResult.ReturnAudio(new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\"+Controller.AudioModus+"-30.wav")); break;
			default: break;}
		}
	}
	
	public static void StopCountdown(){
		MainFrame.Timer.setForeground(new Color(255,136,000));
		OBSFrame.Timer.setForeground(new Color(255,136,000));
		if(Controller.TimmerPause==false && TimerPlus==false){
			AudioResult.ReturnAudio(new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\hold.wav"));}
		Controller.TimmerPause=true;
	}
	
	public static void ResumCountdown(){
		Controller.TimmerPause=false;
		MainFrame.Timer.setForeground(new Color(000,200,000));
		OBSFrame.Timer.setForeground(new Color(000,200,000));
	}
	
	public static String Timer(){
		String TimerS = String.format("%02d", sec);
		String TimerM = String.format("%02d", min);
		String TimerH = String.format("%02d", h);
		String Timer = Tplus+TimerH+":"+TimerM+":"+TimerS;
		Countdown=Timer;
		return Timer;}
	
	public static void UpdateTimer(boolean sound){
		MainFrame.Timer.setText(Timer());
		OBSFrame.Timer.setText(Timer());
		if(sound){AudioResult.PlaySound();}
	}
}
