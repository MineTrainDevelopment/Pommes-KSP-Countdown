package de.minetrain.contdown.litesql;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.scheduler.Scheduler;

public class DatabaseBagUp{
	private static Connection connection;
	private static Statement statement;
	
	public static void Connect(){
		Disconnect();
		connection=null;
		
		try{
			File file = new File("database.db");
			if(!file.exists()){file.createNewFile();}
			
			String url = "jdbc:sqlite:"+file.getPath();
			connection= DriverManager.getConnection(url);
			statement=connection.createStatement();
			
			System.out.println("Database Connected!");
			
		}catch(SQLException | IOException e){e.printStackTrace();}
	}
	
	
	public static void Disconnect(){
		try{
			if(connection==null){return;}
			connection.close();
			System.out.println("Database Disconnected!");
			
		}catch(SQLException e){e.printStackTrace();}
	}
	
	
	public static void onUpdate(String sql){
		try {statement.execute(sql);}catch(SQLException e){e.printStackTrace();}
	}
	
	
	public static ResultSet onQuery(String sql){
		try{return statement.executeQuery(sql);}catch(SQLException e){e.printStackTrace();}
		return null;
	}
	

	/**
	* @return      Create table if not exists
	*/
	public static void onCreate(){
		//MainFrameX	MainFrameY	OBSFrameX	OBSFrameY	OBSState	TimerSec	TimerMin	TimerH	TimerPlus	TimerSetting	AudioState	AudioMode
		System.out.println("Databases createt if not exists");
		DatabaseBagUp.onUpdate("CREATE TABLE IF NOT EXISTS settings("
				+ "MainFrameX INTEGER NOT NULL, "
				+ "MainFrameY INTEGER NOT NULL, "
				+ "OBSFrameX INTEGER NOT NULL, "
				+ "OBSFrameY INTEGER NOT NULL, "
				+ "OBSState INTEGER NOT NULL, "
				+ "TimerSec INTEGER NOT NULL, "
				+ "TimerMin INTEGER NOT NULL, "
				+ "TimerH INTEGER NOT NULL, "
				+ "TimerPlus INTEGER NOT NULL, "
				+ "TimerSetting INTEGER NOT NULL, "
				+ "AudioState INTEGER NOT NULL, "
				+ "AudioMode TEXT NOT NULL)");
	}
	

	/**
	* @return      Save the settings
	*/
	public static void SaveSettings(){
		System.out.println("Database Updatet!");
		int OBSstate;
		int TimerPlus;
		int AudioState;
		
		if(Controller.OBS==true){OBSstate=1;}else{OBSstate=0;}
		if(Scheduler.TimerPlus==true){TimerPlus=1;}else{TimerPlus=0;}
		if(Controller.Audio==true){AudioState=1;}else{AudioState=0;}
		
		DatabaseBagUp.onUpdate("INSERT INTO settings("
				+ "MainFrameX, "
				+ "MainFrameY, "
				+ "OBSFrameX, "
				+ "OBSFrameY, "
				+ "OBSState, "
				+ "TimerSec, "
				+ "TimerMin, "
				+ "TimerH, "
				+ "TimerPlus, "
				+ "TimerSetting, "
				+ "AudioState, "
				+ "AudioMode "
				+ ")VALUES("
				+ MainFrame.frame.getLocation().x+", "
				+ MainFrame.frame.getLocation().y+", "
				+ OBSFrame.frame.getLocation().x+", "
				+ OBSFrame.frame.getLocation().y+", "
				+ OBSstate+", "
				+ Scheduler.sec+", "
				+ Scheduler.min+", "
				+ Scheduler.h+", "
				+ TimerPlus+", "
				+ Controller.TimerPreset+", "
				+ AudioState+", "
				+ Controller.AudioModusInt
				+ ")");
		
	}
	
	public static void LoadSettings(){
		ResultSet test = DatabaseBagUp.onQuery("SELECT MainFrameX FROM settings");
		try{test.getInt("MainFrameX");}catch(SQLException e1){SaveSettings();}
		
		try{ResultSet MainFrameX = DatabaseBagUp.onQuery("SELECT MainFrameX FROM settings"); int X=MainFrameX.getInt("MainFrameX");
			ResultSet MainFrameY = DatabaseBagUp.onQuery("SELECT MainFrameY FROM settings"); int Y=MainFrameY.getInt("MainFrameY");
			MainFrame.frame.getLocation().setLocation(X,Y);
			System.out.println(X+" "+Y);
		}catch(SQLException e){e.printStackTrace();}
		
		try{ResultSet OBSFrameX = DatabaseBagUp.onQuery("SELECT OBSFrameX FROM settings"); int X=OBSFrameX.getInt("OBSFrameX");
			ResultSet OBSFrameY = DatabaseBagUp.onQuery("SELECT OBSFrameY FROM settings"); int Y=OBSFrameY.getInt("OBSFrameY");
			OBSFrame.frame.getLocation().setLocation(X,Y);
		}catch(SQLException e){e.printStackTrace();}
		
		try{ResultSet OBSState = DatabaseBagUp.onQuery("SELECT OBSState FROM settings"); int i=OBSState.getInt("OBSState");
			if(i==1){Controller.OBS=true;}else{Controller.OBS=false;}
		}catch(SQLException e){e.printStackTrace();}

		try{ResultSet TimerSec = DatabaseBagUp.onQuery("SELECT TimerSec FROM settings"); int sec=TimerSec.getInt("TimerSec");
			ResultSet TimerMin = DatabaseBagUp.onQuery("SELECT TimerMin FROM settings"); int min=TimerMin.getInt("TimerMin");
			ResultSet TimerH = DatabaseBagUp.onQuery("SELECT TimerH FROM settings"); int h=TimerH.getInt("TimerH");
			Scheduler.sec=sec;
			Scheduler.min=min;
			Scheduler.h=h;
		}catch(SQLException e){e.printStackTrace();}
	}
	
}