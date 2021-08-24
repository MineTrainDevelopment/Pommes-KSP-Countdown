import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame4K implements ActionListener{
	
	JFrame frame;
	JFrame OBSframe;
	JFrame OBSMover;
	
	JLabel Timer;
	JLabel TimerOBS;
	JLabel border;
	JButton Start;
	JButton Stop;
	JButton Reset;
	JButton Audio;
	JButton OBS;
	JButton OBStop;
	JButton T1;
	JButton T2;
	JButton T3;
	JButton T4;
	JButton T5;
	JButton T6;
	JButton Uninstal;
	JButton Button1080P;
	int TimerS_Preset=30;
	int TimerM_Preset=0;
	int TimerH_Preset=0;
	int TimerS=30;
	int TimerM=0;
	int TimerH=0;
	int Status = 0;					 //0=rot | 1=grün | 2=orange
	int Tx=1;
	ImageIcon borderPNG;
	ImageIcon PNG = new ImageIcon("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Pommes.png");
	boolean TimerRunning;
	boolean TimerPlus;
	boolean TimerReset=true;
	boolean AudiO=true;
	boolean OBs;
	boolean OBStoP=true;
	boolean Random;
	boolean MineTrainSound;
	String TimerS_String;
	String TimerM_String;
	String TimerH_String;
	
	File file;
	Clip clip;
	
	MyFrame4K(){
		TimerS_String = String.format("%02d", TimerS_Preset);
		TimerM_String = String.format("%02d", TimerM_Preset);
		TimerH_String = String.format("%02d", TimerH_Preset);
		
		
		
		frame = new JFrame("Pommes Countdown");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1600,600);
		frame.getContentPane().setBackground(new Color(00,80,80));
		//frame.setAlwaysOnTop(true);
		frame.setFocusable(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(PNG.getImage());
		
		OBSframe = new JFrame("Countdown OBS");
		OBSframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		OBSframe.setSize(0,0);
		OBSframe.setAlwaysOnTop(true);
		OBSframe.setUndecorated(true);
		OBSframe.setFocusable(true);
		//OBSframe.getContentPane().setBackground(new Color(00,80,80));;
		OBSframe.getContentPane().setBackground(new Color(000,000,000));
		OBSframe.setLayout(null);
		OBSframe.setIconImage(PNG.getImage());
		OBSframe.setVisible(true);
		
		borderPNG = new ImageIcon("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Countdown OBS Rand.png");
		border = new JLabel();
		border.setLocation(0,0);
		border.setIcon(borderPNG);
		border.setSize(320,55);
		
		OBS = new JButton();
		OBS.setFont(new Font("ARIAL",Font.PLAIN, 30));
		OBS.setText("OBS");
		OBS.setSize(new Dimension(200,100));
		OBS.setBackground(new Color(200,000,000));
		OBS.setLocation(1370,450);
		OBS.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(OBs==false) {
		OBs=true;
		int frameX = (int) frame.getLocation().getX();
		int frameY = (int) frame.getLocation().getY();
		OBSframe.setLocation(frameX+647, frameY+620);
		OBSframe.setSize(305,55);
		StartMove();
		}else{
		OBs=false;
		OBSframe.setSize(new Dimension(0,0));
		StopMove();
		}
		if(OBs==false) {OBS.setBackground(new Color(200,000,000));}else{OBS.setBackground(new Color(000,200,000));}
		}});
		
		TimerOBS = new JLabel();
		TimerOBS.setSize(305,55);
		TimerOBS.setLocation(5,0);
		TimerOBS.setFont(new Font("ARIAL",Font.PLAIN, 55));
		TimerOBS.setForeground(new Color(255,136,000));
		TimerOBS.setText("Scrubbed :(");
		
		Timer = new JLabel();
		Timer.setLocation(20,8);
		Timer.setSize(1220,120);
		Timer.setFont(new Font("ARIAL",Font.PLAIN, 120));
		Timer.setForeground(new Color(255,136,000));
		Timer.setText("Scrubbed :(");
		
		OBStop = new JButton();
		OBStop.setFont(new Font("ARIAL",Font.PLAIN, 30));
		OBStop.setText("OBS-TOP");
		OBStop.setSize(new Dimension(200,100));
		OBStop.setLocation(1150,450);
		OBStop.setBackground(new Color(000,200,000));
		OBStop.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(OBStoP==false) {
		OBStoP=true;
		OBSframe.setVisible(false);
		OBSframe.setAlwaysOnTop(true);
		OBSframe.setVisible(true);
		}else{
		OBStoP=false;
		OBSframe.setVisible(false);
		OBSframe.setAlwaysOnTop(false);
		OBSframe.setVisible(true);}
		if(OBStoP==false) {OBStop.setBackground(new Color(200,000,000));}else{OBStop.setBackground(new Color(000,200,000));}
		}});
		
		Audio = new JButton();
		Audio.setFont(new Font("ARIAL",Font.PLAIN, 30));
		Audio.setText("Audio");
		Audio.setSize(new Dimension(240,100));
		Audio.setLocation(20,450);
		Audio.setBackground(new Color(000,200,000));
		Audio.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(AudiO==false) {AudiO=true;}else{AudiO=false;}
		if(AudiO==false) {Audio.setBackground(new Color(200,000,000));}else{Audio.setBackground(new Color(000,200,000));}
		}});
		
		Start = new JButton();
		Start.setFont(new Font("ARIAL",Font.PLAIN, 30));
		Start.setText("Start");
		Start.setSize(new Dimension(200,100));
		Start.setLocation(20,150);
		Start.setBackground(new Color(000,255,000));
		Start.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Status=1;
		if(Status==0){Timer.setForeground(new Color(200,000,000));} else if(Status==2){Timer.setForeground(new Color(255,136,000));} else if(Status==1){Timer.setForeground(new Color(000,200,000));}
		if(Status==0){TimerOBS.setForeground(new Color(200,000,000));} else if(Status==2){TimerOBS.setForeground(new Color(255,136,000));} else if(Status==1){TimerOBS.setForeground(new Color(000,200,000));}
		if(TimerRunning==false && TimerReset==true){
		Random wuerfel = new Random();
		int augenZahl;
		for (int i=0; i<1; i++){
		augenZahl = 1 + wuerfel.nextInt(20);
		System.out.println(augenZahl);
		if(augenZahl==1){MineTrainSound=true;}}
		
		for (int i=0; i<1; i++){
		augenZahl = 1 + wuerfel.nextInt(50);
		System.out.println(augenZahl);
		if(augenZahl==42){Random=true; MineTrainSound=false;}}}
		if(TimerReset==true){
		TimerReset=false;
		TimerS=TimerS_Preset;
		TimerM=TimerM_Preset;
		TimerH=TimerH_Preset;}
		TimerS_String = String.format("%02d", TimerS);
		TimerM_String = String.format("%02d", TimerM);
		TimerH_String = String.format("%02d", TimerH);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		if(TimerS==30 && TimerRunning==false && MineTrainSound==false && AudiO==true){try {Dreisieg();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}}
		if(TimerS==30 && TimerRunning==false && MineTrainSound==true && AudiO==true){try {Dreisieg2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}}
		if(TimerS==15 && TimerRunning==false && MineTrainSound==false && AudiO==true){try {funfzehn();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}}
		if(TimerS==15 && TimerRunning==false && MineTrainSound==true && AudiO==true){try {funfzehn2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}}
		TimerRunning=true;
		}});
		
		Stop = new JButton();
		Stop.setFont(new Font("ARIAL",Font.PLAIN, 30));
		Stop.setText("Stop");
		Stop.setSize(new Dimension(200,100));
		Stop.setLocation(230,150);
		Stop.setBackground(new Color(255,136,000));
		Stop.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(TimerRunning==true) {
		Status=2;
		if(AudiO==true && TimerPlus==false){try {hold();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}}
		if(Status==0){Timer.setForeground(new Color(200,000,000));} else if(Status==2){Timer.setForeground(new Color(255,136,000));} else if(Status==1){Timer.setForeground(new Color(000,200,000));}
		if(Status==0){TimerOBS.setForeground(new Color(200,000,000));} else if(Status==2){TimerOBS.setForeground(new Color(255,136,000));} else if(Status==1){TimerOBS.setForeground(new Color(000,200,000));}
		TimerRunning=false;
		}}});
		
		Reset = new JButton();
		Reset.setFont(new Font("ARIAL",Font.PLAIN, 30));
		Reset.setText("Reset");
		Reset.setSize(new Dimension(200,100));
		Reset.setLocation(440,150);
		Reset.setBackground(new Color(255,000,000));
		Reset.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		Status=0;
		if(Status==0){Timer.setForeground(new Color(200,000,000));} else if(Status==2){Timer.setForeground(new Color(255,136,000));} else if(Status==1){Timer.setForeground(new Color(000,200,000));}
		if(Status==0){TimerOBS.setForeground(new Color(200,000,000));} else if(Status==2){TimerOBS.setForeground(new Color(255,136,000));} else if(Status==1){TimerOBS.setForeground(new Color(000,200,000));}
		TimerRunning=false;
		TimerPlus=false;
		TimerReset=true;
		Random=false;
		MineTrainSound=false;
		TimerS=TimerS_Preset;
		TimerM=TimerM_Preset;
		TimerH=TimerH_Preset;
		TimerS_String = String.format("%02d", TimerS_Preset);
		TimerM_String = String.format("%02d", TimerM_Preset);
		TimerH_String = String.format("%02d", TimerH_Preset);
		TimerOBS.setLocation(5,0);
		TimerOBS.setFont(new Font("ARIAL",Font.PLAIN, 55));
		TimerOBS.setForeground(new Color(255,136,000));
		TimerOBS.setText("Scrubbed :(");
		Timer.setLocation(5,0);
		Timer.setForeground(new Color(255,136,000));
		Timer.setText("Scrubbed :(");
		}});
		
		T1 = new JButton();
		T1.setFont(new Font("ARIAL",Font.BOLD, 30));
		T1.setSize(new Dimension(400,50));
		T1.setLocation(1170,20);
		T1.setBackground(new Color(000,100,000));
		T1.setText("00:00:15");
		T1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TimerS_Preset=15;
		TimerM_Preset=0;
		TimerH_Preset=0;
		Tx=1;
		T1.setBackground(new Color(000,255,000));
		T2.setBackground(new Color(000,100,000));
		T3.setBackground(new Color(000,100,000));
		T4.setBackground(new Color(000,100,000));
		T5.setBackground(new Color(000,100,000));
		T6.setBackground(new Color(000,100,000));
		}});
		
		T2 = new JButton();
		T2.setFont(new Font("ARIAL",Font.BOLD, 30));
		T2.setSize(new Dimension(400,50));
		T2.setLocation(1170,90);
		T2.setBackground(new Color(000,255,000));
		T2.setText("00:00:30");
		T2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TimerS_Preset=30;
		TimerM_Preset=0;
		TimerH_Preset=0;
		Tx=2;
		T1.setBackground(new Color(000,100,000));
		T2.setBackground(new Color(000,255,000));
		T3.setBackground(new Color(000,100,000));
		T4.setBackground(new Color(000,100,000));
		T5.setBackground(new Color(000,100,000));
		T6.setBackground(new Color(000,100,000));
		}});
		
		T3 = new JButton();
		T3.setFont(new Font("ARIAL",Font.BOLD, 30));
		T3.setSize(new Dimension(400,50));
		T3.setLocation(1170,160);
		T3.setBackground(new Color(000,100,000));
		T3.setText("00:01:00");
		T3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TimerS_Preset=0;
		TimerM_Preset=1;
		TimerH_Preset=0;
		Tx=3;
		T1.setBackground(new Color(000,100,000));
		T2.setBackground(new Color(000,100,000));
		T3.setBackground(new Color(000,255,000));
		T4.setBackground(new Color(000,100,000));
		T5.setBackground(new Color(000,100,000));
		T6.setBackground(new Color(000,100,000));
		}});
		
		T4 = new JButton();
		T4.setFont(new Font("ARIAL",Font.BOLD, 30));
		T4.setSize(new Dimension(400,50));
		T4.setLocation(750,20);
		T4.setBackground(new Color(000,100,000));
		T4.setText("00:02:00");
		T4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TimerS_Preset=0;
		TimerM_Preset=2;
		TimerH_Preset=0;
		Tx=4;
		T1.setBackground(new Color(000,100,000));
		T2.setBackground(new Color(000,100,000));
		T3.setBackground(new Color(000,100,000));
		T4.setBackground(new Color(000,255,000));
		T5.setBackground(new Color(000,100,000));
		T6.setBackground(new Color(000,100,000));
		}});
		
		T5 = new JButton();
		T5.setFont(new Font("ARIAL",Font.BOLD, 30));
		T5.setSize(new Dimension(400,50));
		T5.setLocation(750,90);
		T5.setBackground(new Color(000,100,000));
		T5.setText("00:05:00");
		T5.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TimerS_Preset=0;
		TimerM_Preset=5;
		TimerH_Preset=0;
		Tx=5;
		T1.setBackground(new Color(000,100,000));
		T2.setBackground(new Color(000,100,000));
		T3.setBackground(new Color(000,100,000));
		T4.setBackground(new Color(000,100,000));
		T5.setBackground(new Color(000,255,000));
		T6.setBackground(new Color(000,100,000));
		}});
		
		T6 = new JButton();
		T6.setFont(new Font("ARIAL",Font.BOLD, 30));
		T6.setSize(new Dimension(400,50));
		T6.setLocation(750,160);
		T6.setBackground(new Color(000,100,000));
		T6.setText("01:00:10");
		T6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TimerS_Preset=10;
		TimerM_Preset=0;
		TimerH_Preset=1;
		Tx=6;
		T1.setBackground(new Color(000,100,000));
		T2.setBackground(new Color(000,100,000));
		T3.setBackground(new Color(000,100,000));
		T4.setBackground(new Color(000,100,000));
		T5.setBackground(new Color(000,100,000));
		T6.setBackground(new Color(000,255,000));
		}});
		
		
		Uninstal = new JButton();
		Uninstal.setFont(new Font("ARIAL",Font.BOLD, 10));
		Uninstal.setSize(new Dimension(20,40));
		Uninstal.setLocation(8,80);
		Uninstal.setBackground(new Color(100,000,000));
		Uninstal.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		File file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\unins000.exe");
		try {Desktop.getDesktop().open(file);} catch (IOException e1) {System.out.println("");e1.printStackTrace();}
		System.exit(0);
		}});
		
		
		Button1080P = new JButton();
		Button1080P.setFont(new Font("ARIAL",Font.PLAIN, 30));
		Button1080P.setText("1080P");
		Button1080P.setSize(new Dimension(240,100));
		Button1080P.setLocation(280,450);
		Button1080P.setBackground(new Color(190,136,000));
		Button1080P.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		File file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Pommes_KSP_Countdown.jar");
		try {Desktop.getDesktop().open(file);} catch (IOException e1) {System.out.println("");e1.printStackTrace();}
		System.exit(0);
		}});
		
		
		frame.add(Button1080P);
		frame.add(Uninstal);
		frame.add(T1);
		frame.add(T2);
		frame.add(T3);
		frame.add(T4);
		frame.add(T5);
		frame.add(T6);
		frame.add(Audio);
		frame.add(Reset);
		frame.add(Stop);
		frame.add(Start);
		frame.add(OBStop);
		frame.add(Timer);
		frame.add(OBS);
		frame.setVisible(true);
		
		OBSframe.add(TimerOBS);
		OBSframe.add(border);
		Start();
	}
	
	public void Start() {
		while(true) {
			if(TimerRunning == true) {
			if(TimerPlus == false) {
				if(TimerM==0) {if(TimerH>0 && TimerS==0){TimerH--;}}
				if(TimerS==0) {TimerS=60; if(TimerM!=0){TimerM--;}else{TimerM=59;}}
				TimerS--;
				if(TimerS==0 && TimerM==0 && TimerH==0) {TimerPlus=true;}
				} else {
				if(TimerS<59) {TimerS++;} else {if(TimerM<59) {TimerM++; TimerS = 0;} else {TimerH++; TimerM = 0;}}
				}
				
				
				
				TimerS_String = String.format("%02d", TimerS);
				TimerM_String = String.format("%02d", TimerM);
				TimerH_String = String.format("%02d", TimerH);
				
				if(Status==0){TimerOBS.setForeground(new Color(200,000,000));} else if(Status==2){TimerOBS.setForeground(new Color(255,136,000));} else if(Status==1){TimerOBS.setForeground(new Color(000,200,000));}
				if(Status==0){Timer.setForeground(new Color(200,000,000));} else if(Status==2){Timer.setForeground(new Color(255,136,000));} else if(Status==1){Timer.setForeground(new Color(000,200,000));}
				
				if(TimerPlus==false) {
				TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
				Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
				}else if(TimerS==0 && TimerM==0 && TimerH==0) {
				TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
				Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
				}else{
				TimerOBS.setText("T+ " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
				Timer.setText("T+ " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
				}
			}
			
			if(TimerM==0 && TimerH==0 && TimerPlus==false && TimerRunning==true && AudiO==true && Random==false && MineTrainSound==false){
				switch (TimerS) {
				case 32:
					try {Dreisieg();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 15:
					try {funfzehn();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 10:
					try {Zehn();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 9:
					try {Neun();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 8:
					try {Acht();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 7:
					try {Sieben();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 6:
					try {Sechs();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 5:
					try {Fuenf();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 4:
					try {Vier();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 3:
					try {Drei();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 2:
					try {Zwei();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 1:
					try {Eins();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 0:
					try {Null();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				default:
					break;
				}
			}else if(TimerM==0 && TimerH==0 && TimerPlus==false && TimerRunning==true && AudiO==true && Random==true){
				switch (TimerS) {
				case 30:
					try {Sechs();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 15:
					try {Neun();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 10:
					try {Acht();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 9:
					try {Eins();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 8:
					try {Fuenf();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 7:
					try {Null();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 6:
					try {Vier();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 5:
					try {Zwei();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 4:
					try {AltZehn();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 3:
					try {Neun();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 2:
					try {Liftoff();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 1:
					try {Sieben();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 0:
					try {Neun();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				default:
					break;
				}
			}else if(TimerM==0 && TimerH==0 && TimerPlus==false && TimerRunning==true && AudiO==true && Random==false && MineTrainSound==true){
				switch (TimerS) {
				case 30:
					try {Dreisieg2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 15:
					try {funfzehn2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 10:
					try {Zehn2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 9:
					try {Neun2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 8:
					try {Acht2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 7:
					try {Sieben2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 6:
					try {Sechs2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 5:
					try {Fuenf2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 4:
					try {Vier2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 3:
					try {Drei2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 2:
					try {Zwei2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 1:
					try {Eins2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 0:
					try {Null2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				default:
					break;
				}
			}
			if(TimerM==0 && TimerH==0 && TimerPlus==true && TimerRunning==true && AudiO==true && MineTrainSound==false){
				switch (TimerS) {
				case 59:
					try {MaxQ();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 24:
					try {downrange();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 19:
					try {norminal();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 2:
					try {Liftoff();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 1:
					try {Egni();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 0:
					try {Null();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				default:
					break;
				}
			}else if(TimerM==0 && TimerH==0 && TimerPlus==true && TimerRunning==true && AudiO==true && MineTrainSound==true){
				switch (TimerS) {
				case 59:
					try {MaxQ2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				case 0:
					try {Null2();} catch (UnsupportedAudioFileException e1) {e1.printStackTrace();} catch (IOException e1) {e1.printStackTrace();} catch (LineUnavailableException e1) {e1.printStackTrace();}
					break;
				default:
					break;
				}
			}
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	public void Dreisieg() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\30.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void funfzehn() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\15.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Zehn() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\10.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Neun() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\9.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 9);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Acht() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\8.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 8);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Sieben() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\7.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 7);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Sechs() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\6.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 6);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Fuenf() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\5.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 5);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Vier() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\4.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 4);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Drei() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\3.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 3);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Zwei() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 2);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Eins() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\1.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 1);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Null() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\0.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 0);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void AltZehn() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\10.alt.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
		TimerS_String = String.format("%02d", 10);
		TimerOBS.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
		Timer.setText("T- " + TimerH_String + ":" + TimerM_String + ":" + TimerS_String);
	}
	public void Dreisieg2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\30.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void funfzehn2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\15.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Zehn2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\10.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Neun2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\9.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Acht2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\8.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Sieben2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\7.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Sechs2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\6.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Fuenf2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\5.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Vier2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\4.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Drei2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\3.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Zwei2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\2.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Eins2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\1.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Null2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\0.2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Egni() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\egni.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void Liftoff() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\liftoff.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void MaxQ() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\maxq.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void MaxQ2() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\maxq2.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void norminal() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\normal.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void downrange() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\downrange.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	public void hold() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		file = new File("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\hold.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();
	}
	
	public void StartMove() {
		OBSMover = new JFrame("OBS Mover");
		OBSMover.setSize(400,150);
		OBSMover.getContentPane().setBackground(new Color(00,80,80));
		OBSMover.setFocusable(true);
		OBSMover.setLayout(null);
		OBSMover.setResizable(false);
		int frameX = (int) frame.getLocation().getX();
		int frameY = (int) frame.getLocation().getY();
		OBSMover.setLocation(frameX, frameY-150); 
		OBSMover.setIconImage(PNG.getImage());
		
		JButton left = new JButton();
		left.setFont(new Font("ARIAL",Font.PLAIN, 50));
		left.setText("<");
		left.setSize(new Dimension(70,35));
		left.setLocation(100,50);
		left.setBackground(new Color(000,200,000));
		left.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		int FrameX = (int) OBSframe.getLocation().getX();
		int FrameY = (int) OBSframe.getLocation().getY();
		OBSframe.setLocation(FrameX-40, FrameY);
		}});
		
		JButton right = new JButton();
		right.setFont(new Font("ARIAL",Font.PLAIN, 50));
		right.setText(">");
		right.setSize(new Dimension(70,35));
		right.setLocation(250,50);
		right.setBackground(new Color(000,200,000));
		right.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		int FrameX = (int) OBSframe.getLocation().getX();
		int FrameY = (int) OBSframe.getLocation().getY();
		OBSframe.setLocation(FrameX+40, FrameY);
		}});
		
		JButton down = new JButton();
		down.setFont(new Font("ARIAL",Font.PLAIN, 35));
		down.setText("V");
		down.setSize(new Dimension(70,35));
		down.setLocation(175,50);
		down.setBackground(new Color(000,200,000));
		down.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		int FrameX = (int) OBSframe.getLocation().getX();
		int FrameY = (int) OBSframe.getLocation().getY();
		OBSframe.setLocation(FrameX, FrameY+40);
		}});
		
		JButton up = new JButton();
		up.setFont(new Font("ARIAL",Font.PLAIN, 35));
		up.setText("^");
		up.setSize(new Dimension(70,35));
		up.setLocation(175,10);
		up.setBackground(new Color(000,200,000));
		up.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		int FrameX = (int) OBSframe.getLocation().getX();
		int FrameY = (int) OBSframe.getLocation().getY();
		OBSframe.setLocation(FrameX, FrameY-40);
		}});

		OBSMover.add(left);
		OBSMover.add(right);
		OBSMover.add(down);
		OBSMover.add(up);
		OBSMover.setVisible(true);
		}

		public void StopMove() {
		OBSMover.setVisible(false);
		}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
