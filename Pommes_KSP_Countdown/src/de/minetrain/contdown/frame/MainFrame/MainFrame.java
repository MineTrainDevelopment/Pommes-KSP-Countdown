package de.minetrain.contdown.frame.MainFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.scheduler.Scheduler;

public class MainFrame{
	public static JFrame frame;
	public static JButton OBSbutton;
	public static JButton Audio;
	public static JButton AudioMode;
	static JButton T1;
	static JButton T2;
	static JButton T3;
	static JButton T4;
	static JButton T5;
	static JButton T6;
	public static JLabel Timer;
	static ImageIcon PNG = new ImageIcon("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Pommes.png");
	static ImageIcon STARTPNG = new ImageIcon("C:\\Users\\justi\\OneDrive\\Desktop\\test.png");
	
	public static void create(){
		frame = new JFrame("Countdown");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Components.FrameSize());
		frame.getContentPane().setBackground(new Color(00,80,80));
		frame.setAlwaysOnTop(true);
		frame.setFocusable(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(PNG.getImage());
		//frame.setLocation(0,0);
		
		

		Timer = new JLabel();
		Timer.setLocation(Components.TimerPoint());
		Timer.setSize(Components.TimerSize());
		Timer.setFont(Components.TimerFont());
		//Timer.setForeground(new Color(255,136,000));
		Timer.setForeground(new Color(200,000,000));
		Timer.setText("T- 00:00:00");
		
		
		T1 = new JButton();
		T1.setFont(Components.TimerButtonFont());
		T1.setSize(Components.TimerButtonSize());
		T1.setLocation(Components.TimerButtonPoint(1));
		T1.setBackground(new Color(000,100,000));
		T1.setText("00:00:15");
		T1.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){UpdateTimmerPresetButton(1);}});
		
		T2 = new JButton();
		T2.setFont(Components.TimerButtonFont());
		T2.setSize(Components.TimerButtonSize());
		T2.setLocation(Components.TimerButtonPoint(2));
		T2.setBackground(new Color(000,255,000));
		T2.setText("00:00:30");
		T2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){UpdateTimmerPresetButton(2);}});
		
		T3 = new JButton();
		T3.setFont(Components.TimerButtonFont());
		T3.setSize(Components.TimerButtonSize());
		T3.setLocation(Components.TimerButtonPoint(3));
		T3.setBackground(new Color(000,100,000));
		T3.setText("00:01:00");
		T3.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){UpdateTimmerPresetButton(3);}});
		
		T4 = new JButton();
		T4.setFont(Components.TimerButtonFont());
		T4.setSize(Components.TimerButtonSize());
		T4.setLocation(Components.TimerButtonPoint(4));
		T4.setBackground(new Color(000,100,000));
		T4.setText("00:02:00");
		T4.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){UpdateTimmerPresetButton(4);}});
		
		T5 = new JButton();
		T5.setFont(Components.TimerButtonFont());
		T5.setSize(Components.TimerButtonSize());
		T5.setLocation(Components.TimerButtonPoint(5));
		T5.setBackground(new Color(000,100,000));
		T5.setText("00:05:00");
		T5.addActionListener(new ActionListener() {
		@Override

		public void actionPerformed(ActionEvent e){UpdateTimmerPresetButton(5);}});
		
		T6 = new JButton();
		T6.setFont(Components.TimerButtonFont());
		T6.setSize(Components.TimerButtonSize());
		T6.setLocation(Components.TimerButtonPoint(6));
		T6.setBackground(new Color(000,100,000));
		T6.setText("01:00:10");
		T6.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){UpdateTimmerPresetButton(6);}});
		
		
		frame.add(Timer);
		frame.add(T1);
		frame.add(T2);
		frame.add(T3);
		frame.add(T4);
		frame.add(T5);
		frame.add(T6);
		frame.add(StopButton());
		frame.add(ResetButton());
		frame.add(StartButton());
		frame.add(ToggleAudioMode());
		frame.add(ToggleAudio());
		frame.add(ToggleOBS());
		frame.setVisible(true);
	}
	
	public static JButton StopButton(){
		JButton Stop = new JButton();
		Stop.setFont(Components.StopButtonFont());
		Stop.setText("Stop");
		Stop.setSize(Components.StopButtonSize());
		Stop.setLocation(Components.StopButtonPoint());
		Stop.setBackground(new Color(255,136,000));
		Stop.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		if(Controller.TimmerRunning==true){
			Scheduler.StopCountdown();
		}}});
		
		return Stop;
	}
	
	
	public static JButton ResetButton(){
		JButton Reset = new JButton();
		Reset.setFont(Components.ResetButtonFont());
		Reset.setText("Reset");
		Reset.setSize(Components.ResetButtonSize());
		Reset.setLocation(Components.ResetButtonPoint());
		Reset.setBackground(new Color(255,000,000));
		Reset.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			Scheduler.ResetCountdown();
		}});
		return Reset;
	}
	
	
	public static JButton StartButton(){
		JButton Start = new JButton();
		Start.setFont(Components.StartButtonFont());
		Start.setText("Start");
		Start.setSize(Components.StartButtonSize());
		Start.setLocation(Components.StartButtonPoint());
		Start.setBackground(new Color(000,255,000));
		Start.setIcon(STARTPNG);
		Start.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			if(Controller.TimmerRunning==false || Controller.TimmerPause==true){
				Controller.TimmerRunning=true;
				Scheduler.StartCountdown();
			}
		}});
		return Start;
	}
	
	
	public static JButton ToggleAudioMode(){
		AudioMode = new JButton();
		AudioMode.setFont(Components.AudioModeButtonFont());
		AudioMode.setText(Controller.AudioModus);
		AudioMode.setSize(Components.AudioModeButtonSize());
		AudioMode.setLocation(Components.AudioModeButtonPoint());
		AudioMode.setBackground(new Color(000,200,200));
		AudioMode.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			switch (Controller.AudioModus) {
			case "SpaceX":
				Controller.Random=false;
				Controller.AudioModusInt=2;
				Controller.AudioModus="MineTrain";
				AudioMode.setText("MineTrain");
				break;
				
			case "MineTrain":
				Controller.Random=true;
				Controller.AudioModusInt=3;
				Controller.AudioModus="Random";
				AudioMode.setText("Random");
				break;
				
			case "Random":
				Controller.Random=false;
				Controller.AudioModusInt=1;
				Controller.AudioModus="SpaceX";
				AudioMode.setText("SpaceX");
				break;
				
			default:
				break;
			}
		}});
		return AudioMode;
	}
	
	
	public static JButton ToggleAudio(){
		Audio = new JButton();
		Audio.setFont(Components.AudioButtonFont());
		Audio.setText("Audio");
		Audio.setSize(Components.AudioButtonSize());
		Audio.setLocation(Components.AudioButtonPoint());
		Audio.setBackground(new Color(000,200,000));
		Audio.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(Controller.Audio==false){
				Controller.Audio=true;
				Audio.setBackground(new Color(000,200,000));
			}else{
				Controller.Audio=false;
				Audio.setBackground(new Color(200,000,000));
			}
		}});
		return Audio;
	}
	
	
	public static JButton ToggleOBS(){
		OBSbutton = new JButton();
		OBSbutton.setFont(Components.OBSButtonFont());
		OBSbutton.setText("OBS");
		OBSbutton.setSize(Components.OBSButtonSize());
		OBSbutton.setBackground(new Color(200,000,000));
		OBSbutton.setLocation(Components.OBSButtonPoint());
		OBSbutton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e){
			if(Controller.OBS==true){
				OBSbutton.setBackground(new Color(200,000,000));
				Controller.OBS=false;
				OBSFrame.Visible(false);
			}else{
				OBSbutton.setBackground(new Color(000,200,000));
				Controller.OBS=true;
				OBSFrame.Visible(true);
			}
		}});
		return OBSbutton;
	}
	
	public static void UpdateTimmerPresetButton(int ButtonID){
		switch (ButtonID) {
		case 0:
			Controller.TimerPreset=0;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case 1:
			Scheduler.PREsec=15;
			Scheduler.PREmin=0;
			Scheduler.PREh=0;
			Controller.TimerPreset=1;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,255,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case 2:
			Scheduler.PREsec=30;
			Scheduler.PREmin=0;
			Scheduler.PREh=0;
			Controller.TimerPreset=2;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,255,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case 3:
			Scheduler.PREsec=00;
			Scheduler.PREmin=1;
			Scheduler.PREh=0;
			Controller.TimerPreset=3;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,255,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case 4:
			Scheduler.PREsec=0;
			Scheduler.PREmin=2;
			Scheduler.PREh=0;
			Controller.TimerPreset=4;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,255,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case 5:
			Scheduler.PREsec=0;
			Scheduler.PREmin=5;
			Scheduler.PREh=0;
			Controller.TimerPreset=5;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,255,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case 6:
			Scheduler.PREsec=10;
			Scheduler.PREmin=0;
			Scheduler.PREh=1;
			Controller.TimerPreset=6;
			if(Controller.TimmerRunning==false){Scheduler.ResetCountdown();}
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,255,000));
			break;
			
		default:
			break;
		}
	}
	
}
