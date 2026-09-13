package de.minetrain.contdown.frame.MainFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.minetrain.contdown.enums.DurationPresets;
import de.minetrain.contdown.enums.SchedulerState;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.main.KerbalCountMain;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 7916532940790382122L;
	public JButton OBSbutton;
	public JButton Audio;
	public JButton audioModeButton;
	static JButton T1;
	static JButton T2;
	static JButton T3;
	static JButton T4;
	static JButton T5;
	static JButton T6;
	public JLabel Timer;
	static ImageIcon PNG = new ImageIcon(KerbalCountMain.FILE_DIRECTORY + "icons\\Pommes.png");
//	static ImageIcon STARTPNG = new ImageIcon("C:\\Users\\justi\\OneDrive\\Desktop\\test.png");
	
	Controller controller;
	OBSFrame obsFrame;
	
	public MainFrame(Controller controller, OBSFrame obsFrame) {
		super("Countdown");
		this.controller = controller;
		this.obsFrame = obsFrame;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Components.FrameSize());
		getContentPane().setBackground(new Color(00,80,80));
		setAlwaysOnTop(true);
		setFocusable(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(PNG.getImage());
		
		
		Timer = new JLabel();
		Timer.setLocation(Components.TimerPoint());
		Timer.setSize(Components.TimerSize());
		Timer.setFont(Components.TimerFont());
		Timer.setForeground(controller.getSchedulerState().getTimerColor());
		Timer.setText("T- " + controller.getDurationPresets().getButtonText());
		
		
		T1 = new JButton();
		T1.setFont(Components.TimerButtonFont());
		T1.setSize(Components.TimerButtonSize());
		T1.setLocation(Components.TimerButtonPoint(1));
		T1.setBackground(new Color(000,100,000));
		T1.setText(DurationPresets.VERY_SHORT.getButtonText());
		T1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateTimmerPresetButton(DurationPresets.VERY_SHORT);
			}
		});
		
		T2 = new JButton();
		T2.setFont(Components.TimerButtonFont());
		T2.setSize(Components.TimerButtonSize());
		T2.setLocation(Components.TimerButtonPoint(2));
		T2.setBackground(new Color(000,255,000));
		T2.setText(DurationPresets.SHORT.getButtonText());
		T2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateTimmerPresetButton(DurationPresets.SHORT);
			}
		});
		
		T3 = new JButton();
		T3.setFont(Components.TimerButtonFont());
		T3.setSize(Components.TimerButtonSize());
		T3.setLocation(Components.TimerButtonPoint(3));
		T3.setBackground(new Color(000,100,000));
		T3.setText(DurationPresets.DEFAULT.getButtonText());
		T3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateTimmerPresetButton(DurationPresets.DEFAULT);
			}
		});

		T4 = new JButton();
		T4.setFont(Components.TimerButtonFont());
		T4.setSize(Components.TimerButtonSize());
		T4.setLocation(Components.TimerButtonPoint(4));
		T4.setBackground(new Color(000,100,000));
		T4.setText(DurationPresets.LONG.getButtonText());
		T4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateTimmerPresetButton(DurationPresets.LONG);
			}
		});
		
		T5 = new JButton();
		T5.setFont(Components.TimerButtonFont());
		T5.setSize(Components.TimerButtonSize());
		T5.setLocation(Components.TimerButtonPoint(5));
		T5.setBackground(new Color(000,100,000));
		T5.setText(DurationPresets.VERY_LONG.getButtonText());
		T5.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {
				UpdateTimmerPresetButton(DurationPresets.VERY_LONG);
			}
		});

		T6 = new JButton();
		T6.setFont(Components.TimerButtonFont());
		T6.setSize(Components.TimerButtonSize());
		T6.setLocation(Components.TimerButtonPoint(6));
		T6.setBackground(new Color(000,100,000));
		T6.setText(DurationPresets.EXTREM_LONG.getButtonText());
		T6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdateTimmerPresetButton(DurationPresets.EXTREM_LONG);
			}
		});
		
		add(Timer);
		add(T1);
		add(T2);
		add(T3);
		add(T4);
		add(T5);
		add(T6);
		add(StopButton());
		add(ResetButton());
		add(StartButton());
		add(ToggleAudioMode());
		add(ToggleAudio());
		add(ToggleOBS());
		setVisible(true);
	}
	
	
	public JButton StopButton() {
		JButton Stop = new JButton();
		Stop.setFont(Components.StopButtonFont());
		Stop.setText("Stop");
		Stop.setSize(Components.StopButtonSize());
		Stop.setLocation(Components.StopButtonPoint());
		Stop.setBackground(new Color(255, 136, 000));
		
		Stop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getScheduler().pause();
			}
		});

		return Stop;
	}
	
	
	public JButton ResetButton() {
		JButton Reset = new JButton();
		Reset.setFont(Components.ResetButtonFont());
		Reset.setText("Reset");
		Reset.setSize(Components.ResetButtonSize());
		Reset.setLocation(Components.ResetButtonPoint());
		Reset.setBackground(new Color(255, 000, 000));
		Reset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetTimer();
			}
		});
		return Reset;
	}
	
	
	public JButton StartButton() {
		JButton Start = new JButton();
		Start.setFont(Components.StartButtonFont());
		Start.setText("Start");
		Start.setSize(Components.StartButtonSize());
		Start.setLocation(Components.StartButtonPoint());
		Start.setBackground(new Color(000, 255, 000));
//		Start.setIcon(STARTPNG);
		Start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getScheduler().start();
			}
		});
		return Start;
	}
	
	
	public JButton ToggleAudioMode() {
		audioModeButton = new JButton();
		audioModeButton.setFont(Components.AudioModeButtonFont());
		audioModeButton.setText(controller.getAudioMode().getName());
		audioModeButton.setSize(Components.AudioModeButtonSize());
		audioModeButton.setLocation(Components.AudioModeButtonPoint());
		audioModeButton.setBackground(new Color(000, 200, 200));
		audioModeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				audioModeButton.setText(controller.nextAudioMode().getName());
			}
		});
		return audioModeButton;
	}
	
	
	public JButton ToggleAudio() {
		Audio = new JButton();
		Audio.setFont(Components.AudioButtonFont());
		Audio.setText("Audio");
		Audio.setSize(Components.AudioButtonSize());
		Audio.setLocation(Components.AudioButtonPoint());
		Audio.setBackground(new Color(000, 200, 000));
		Audio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.toggleMuteAudio()) {
					Audio.setBackground(new Color(200, 000, 000));
				} else {
					Audio.setBackground(new Color(000, 200, 000));
				}
			}
		});
		return Audio;
	}
	
	
	public JButton ToggleOBS() {
		OBSbutton = new JButton();
		OBSbutton.setFont(Components.OBSButtonFont());
		OBSbutton.setText("OBS");
		OBSbutton.setSize(Components.OBSButtonSize());
		OBSbutton.setBackground(new Color(200, 000, 000));
		OBSbutton.setLocation(Components.OBSButtonPoint());
		OBSbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.toggleOBSFrame()) {
					OBSbutton.setBackground(new Color(000, 200, 000));
				} else {
					OBSbutton.setBackground(new Color(200, 000, 000));
				}
			}
		});
		return OBSbutton;
	}
	
	public void UpdateTimmerPresetButton(DurationPresets preset){
		controller.setDurationPresets(preset);
		
		switch (preset) {
		case NONE:
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case VERY_SHORT:
			T1.setBackground(new Color(000,255,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case SHORT:
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,255,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case DEFAULT:
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,255,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case LONG:
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,255,000));
			T5.setBackground(new Color(000,100,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case VERY_LONG:
			T1.setBackground(new Color(000,100,000));
			T2.setBackground(new Color(000,100,000));
			T3.setBackground(new Color(000,100,000));
			T4.setBackground(new Color(000,100,000));
			T5.setBackground(new Color(000,255,000));
			T6.setBackground(new Color(000,100,000));
			break;
			
		case EXTREM_LONG:
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
	
	public void updateTimeDisplay(){
		String timerText = controller.getScheduler().getFormattedTimer();
		SchedulerState state = controller.getSchedulerState();
		
		Timer.setText(timerText);
		Timer.setForeground(state.getTimerColor());
		
		obsFrame.Timer.setText(timerText);
		obsFrame.Timer.setForeground(state.getTimerColor());
	}
	
}
