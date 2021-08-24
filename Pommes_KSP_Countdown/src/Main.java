import java.io.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Main {

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, InterruptedException {
		
		System.out.println("Check data...");
		System.out.println("");
		
		try{
		BufferedReader Leser = new BufferedReader(new FileReader("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\settings.txt"));
		System.out.println("Files check complete");
		System.out.println("initiating Java.io: "+Leser);
		Leser.close();
		}catch (Exception e) {try{
		BufferedWriter Schreiber = new BufferedWriter(new FileWriter("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\settings.txt"));
		System.out.println("Start Creating files...");
		Schreiber.write("Main window X/Y:\n");
		Schreiber.write("760\n");
		Schreiber.write("465\n");
		Schreiber.write("OBS window X/Y:\n");
		Schreiber.write("807\n");
		Schreiber.write("620\n");
		Schreiber.write("Voreinstellungen: Zeit:\n");
		Schreiber.write("2\n");
		Schreiber.write("Voreinstellungen: OBS_Satus:\n");
		Schreiber.write("false\n");
		Schreiber.write("Voreinstellungen: OBS_TOP:\n");
		Schreiber.write("true\n");
		Schreiber.write("Voreinstellungen: Audio:\n");
		Schreiber.write("true\n");
		Schreiber.write("Voreinstellungen: 4K:\n");
		Schreiber.write("false\n");
		Schreiber.close();

		System.out.println("");
		System.out.println("----------------------------");
		System.out.println("Main window X/Y:");
		System.out.println("760");
		System.out.println("465");
		System.out.println("OBS window X/Y:");
		System.out.println("807");
		System.out.println("620");
		System.out.println("Voreinstellungen: Zeit:");
		System.out.println("2");
		System.out.println("Voreinstellungen: OBS_Satus:");
		System.out.println("false");
		System.out.println("Voreinstellungen: OBS_TOP:");
		System.out.println("true");
		System.out.println("Voreinstellungen: Audio:");
		System.out.println("true");
		System.out.println("Voreinstellungen: 4K :");
		System.out.println("false");
		System.out.println("----------------------------");
		System.out.println("");
		System.out.println("Checking...");
		System.out.println("");
		System.out.println("29%");
		System.out.println("69%");
		System.out.println("84%");
		System.out.println("100%");
		System.out.println("");
		System.out.println("Check complete");
		System.out.println("");
		System.out.println("initiating Java.io: java.io.BufferedReader@54bedef2");
		
		}catch (Exception e1) {System.out.println();}}
		
		new MyFrame();
		//new MyFrame4K();
	}

}
