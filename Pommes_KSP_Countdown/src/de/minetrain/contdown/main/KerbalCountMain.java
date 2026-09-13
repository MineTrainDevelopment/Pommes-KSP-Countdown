package de.minetrain.contdown.main;

public class KerbalCountMain {
	public static final String FILE_DIRECTORY =  "C:\\ProgramData\\MineTrainDev\\KerbalCount_V3\\resources\\";
	
	public static void main(String[] args){
		new Controller();

		Runtime.getRuntime().addShutdownHook(new Thread(){
		    @Override
		    public void run(){
		    	//Currently unused
		    }
		});
	}
	
}

