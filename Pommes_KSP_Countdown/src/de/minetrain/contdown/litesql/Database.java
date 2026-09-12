package de.minetrain.contdown.litesql;

import java.awt.Color;
import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.scheduler.Scheduler;

public class Database{
	public static FileConfiguration config;
	
	public static void Connect(){
		try{
			File file = new File("database.yml");
			config = YamlConfiguration.loadConfiguration(file);
			if(!file.exists()){
				file.createNewFile();
				System.out.println("Database doesn't´s exists");
				try{Thread.sleep(1000);}catch(InterruptedException e){ }
				
				config.set("Settings .MainFrameX", MainFrame.frame.getLocation().x);
				config.set("Settings .MainFrameY", MainFrame.frame.getLocation().y);
				config.set("Settings .OBSFrameX", OBSFrame.frame.getLocation().x);
				config.set("Settings .OBSFrameY", OBSFrame.frame.getLocation().y);
				config.set("Settings .OBSState", Controller.OBS);
				config.set("Settings .TimerSec", Scheduler.sec);
				config.set("Settings .TimerMin", Scheduler.min);
				config.set("Settings .TimerH", Scheduler.h);
				config.set("Settings .TimerPlus", Scheduler.TimerPlus);
				config.set("Settings .TimerRunning", Controller.TimmerRunning);
				config.set("Settings .TimerSetting", Controller.TimerPreset);
				config.set("Settings .AudioState", Controller.Audio);
				config.set("Settings .AudioMode", Controller.AudioModus);

				config.set(" ", " ");
				config.set("  ", " ");
				config.set("   ", " ");
				
				config.set("Default .MainFrameX", MainFrame.frame.getLocation().x);
				config.set("Default .MainFrameY", MainFrame.frame.getLocation().y);
				config.set("Default .OBSFrameX", OBSFrame.frame.getLocation().x);
				config.set("Default .OBSFrameY", OBSFrame.frame.getLocation().y);
				config.set("Default .OBSState", Controller.OBS);
				config.set("Default .TimerSec", Scheduler.sec);
				config.set("Default .TimerMin", Scheduler.min);
				config.set("Default .TimerH", Scheduler.h);
				config.set("Default .TimerPlus", Scheduler.TimerPlus);
				config.set("Default .TimerRunning", Controller.TimmerRunning);
				config.set("Default .TimerSetting", Controller.TimerPreset);
				config.set("Default .AudioState", Controller.Audio);
				config.set("Default .AudioMode", Controller.AudioModus);
				
				config.save(file);
				System.out.println("Database created");
			}
			
			
			System.out.println("Database Connected!");
			
		}catch(IOException e){e.printStackTrace();}
	}
	
	
	public static void Disconnect(){
		System.out.println("Database Disconnected!");
	}
	
	
	public static void SaveSettings(){
		File file = new File("database.yml");
		config.set("Settings .MainFrameX", MainFrame.frame.getLocation().x);
		config.set("Settings .MainFrameY", MainFrame.frame.getLocation().y);
		config.set("Settings .OBSFrameX", OBSFrame.frame.getLocation().x);
		config.set("Settings .OBSFrameY", OBSFrame.frame.getLocation().y);
		config.set("Settings .OBSState", Controller.OBS);
		config.set("Settings .TimerSec", Scheduler.sec);
		config.set("Settings .TimerMin", Scheduler.min);
		config.set("Settings .TimerH", Scheduler.h);
		config.set("Settings .TimerPlus", Scheduler.TimerPlus);
		config.set("Settings .TimerRunning", Controller.TimmerRunning);
		config.set("Settings .TimerSetting", Controller.TimerPreset);
		config.set("Settings .AudioState", Controller.Audio);
		config.set("Settings .AudioMode", Controller.AudioModus);
		try{config.save(file);}catch(IOException e){ }
		System.out.println("Database Updatet!");
	}
	
	public static void LoadSettings(){
		MainFrame.frame.setLocation((int) config.get("Settings .MainFrameX"), (int) config.get("Settings .MainFrameY"));
		OBSFrame.frame.setLocation((int) config.get("Settings .OBSFrameX"), (int) config.get("Settings .OBSFrameY"));
		
		if((boolean) config.get("Settings .OBSState")==true){ 
		MainFrame.OBSbutton.setBackground(new Color(000,200,000)); Controller.OBS=true; OBSFrame.Visible(true);
		}else{MainFrame.OBSbutton.setBackground(new Color(200,000,000)); Controller.OBS=false; OBSFrame.Visible(false);}
		
		if((boolean) config.get("Settings .TimerRunning")==true){
			Scheduler.sec = (int) config.get("Settings .TimerSec");
			Scheduler.min = (int) config.get("Settings .TimerMin");
			Scheduler.h = (int) config.get("Settings .TimerH");
			Scheduler.TimerPlus = (boolean) config.get("Settings .TimerPlus");
			if((boolean) config.get("Settings .TimerPlus")==true){Scheduler.Tplus="T+ ";}
			MainFrame.Timer.setForeground(new Color(255,136,000));
			OBSFrame.Timer.setForeground(new Color(255,136,000));
			Controller.TimmerRunning=true;
			Controller.TimmerPause=true;
			Scheduler.UpdateTimer(false);
		}
		
		MainFrame.UpdateTimmerPresetButton((int) config.get("Settings .TimerSetting"));
		
		if((boolean) config.get("Settings .AudioState")==true){
		Controller.Audio=true; MainFrame.Audio.setBackground(new Color(000,200,000));
		}else{Controller.Audio=false; MainFrame.Audio.setBackground(new Color(200,000,000));}
		
		Controller.AudioModus = (String) config.get("Settings .AudioMode");
		switch (Controller.AudioModus) {
		case "MineTrain":
			Controller.Random=false;
			Controller.AudioModusInt=2;
			Controller.AudioModus="MineTrain";
			MainFrame.AudioMode.setText("MineTrain");
			break;
			
		case "Random":
			Controller.Random=true;
			Controller.AudioModusInt=3;
			Controller.AudioModus="Random";
			MainFrame.AudioMode.setText("Random");
			break;
			
		case "SpaceX":
			Controller.Random=false;
			Controller.AudioModusInt=1;
			Controller.AudioModus="SpaceX";
			MainFrame.AudioMode.setText("SpaceX");
			break;
			
		default:
			break;
		}
	}
	
}