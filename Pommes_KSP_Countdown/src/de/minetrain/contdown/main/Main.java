package de.minetrain.contdown.main;

//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;

import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.litesql.Database;
import de.minetrain.contdown.scheduler.Scheduler;

public class Main {

	public static void main(String[] args){
		OBSFrame.Create();
		MainFrame.create();
		
		Scheduler.StartScheduler();
		Scheduler.ResetCountdown();

		Database.Connect();
		Database.LoadSettings();
		
		//System.out.println(executePost("minetrainlp"));
		
		Runtime.getRuntime().addShutdownHook(new Thread(){
		    @Override
		    public void run(){
		    	Database.SaveSettings();
		    	Database.Disconnect();
		    }
		});
	}
	
//	public static String executePost(String channelName){
//	    URL url;
//	    HttpURLConnection connection = null;
//
//	    try{
//	        //create connection
//	        url = new URL(("https://api.twitch.tv/kraken/search/channels?query="+channelName+"&client_id=10zk426oqfbz0hfp4dacsffky31wly"));
//	        connection = (HttpURLConnection)url.openConnection();
//	        connection.setRequestMethod("POST");
//	        connection.setRequestProperty("Content-Type",
//	                "application/x-www-form-urlencoded");
//
//	        connection.setUseCaches(false);
//	        connection.setDoInput(true);
//	        connection.setDoOutput(true);
//
//	        //Send request
//	        DataOutputStream wr = new DataOutputStream(
//	                connection.getOutputStream());
//
//	        //Get response
//	        InputStream is = connection.getInputStream();
//	        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
//	        String line;
//	        StringBuffer response = new StringBuffer();
//	        while((line = rd.readLine()) != null){
//	            response.append(line);
//	            response.append('\r');
//	        }
//	        rd.close();
//	        return response.toString();
//	    } catch (Exception e){
//	        e.printStackTrace();
//	        return null;
//	    } finally {
//	        if (connection != null) {
//	            connection.disconnect();
//	        }
//	    }
//	}

}

