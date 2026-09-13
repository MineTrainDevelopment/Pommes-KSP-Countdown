package de.minetrain.contdown.frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.minetrain.contdown.enums.DurationPresets;
import de.minetrain.contdown.enums.TimerActionButtonType;
import de.minetrain.contdown.frame.components.TimePresetButton;
import de.minetrain.contdown.frame.components.TimerActionButton;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.main.KerbalCountMain;
import de.minetrain.contdown.scheduler.Scheduler;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 7916532940790382122L;
	private ArrayList<TimePresetButton> timerButtons = new ArrayList<>();
	public JLabel timer;
	static ImageIcon PNG = new ImageIcon(KerbalCountMain.FILE_DIRECTORY + "icons\\Pommes.png");
	
	private Controller controller;
	
	public MainFrame(Controller controller) {
		super("Countdown");
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(400, 150));
		getContentPane().setBackground(new Color(00,80,80));
		setAlwaysOnTop(true);
		setFocusable(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(PNG.getImage());
		
		timer = new JLabel();
		timer.setLocation(new Point(5, 2));
		timer.setSize(new Dimension(305, 30));
		timer.setFont(new Font("ARIAL", Font.PLAIN, 30));
		timer.setForeground(controller.getScheduler().getState().getTimerColor());
		timer.setText(controller.getScheduler().getFormattedTimer());
		
		timerButtons.add(new TimePresetButton(DurationPresets.VERY_SHORT, this));
		timerButtons.add(new TimePresetButton(DurationPresets.SHORT, this));
		timerButtons.add(new TimePresetButton(DurationPresets.DEFAULT, this));
		timerButtons.add(new TimePresetButton(DurationPresets.LONG, this));
		timerButtons.add(new TimePresetButton(DurationPresets.VERY_LONG, this));
		timerButtons.add(new TimePresetButton(DurationPresets.EXTREM_LONG, this));
		setPresetButtonColors(controller.getDurationPresets());
		
		add(timer);
		timerButtons.forEach(button -> add(button));
		add(getStopButton());
		add(getResetButton());
		add(getStartButton());
		add(getAudioModeToggle());
		add(getAudioToggle());
		add(getToggleOBS());
		setVisible(true);
	}
	
	
	public void onTimePresetButton(DurationPresets presets){
		controller.setDurationPresets(presets);
		setPresetButtonColors(presets);
	}


	private void setPresetButtonColors(DurationPresets presets) {
		timerButtons.forEach(button -> button.setAktiv(button.getPreset() == presets));
	}
	
	
	public JButton getStopButton() {
		return new TimerActionButton(TimerActionButtonType.PAUSE).setAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getScheduler().pause();
			}
		});
	}
	
	public JButton getResetButton() {
		return new TimerActionButton(TimerActionButtonType.RESET).setAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.resetTimer();
			}
		});
	}
	
	
	public JButton getStartButton() {
		return new TimerActionButton(TimerActionButtonType.START).setAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.getScheduler().start();
			}
		});
	}
	
	
	public JButton getAudioModeToggle() {
		JButton button = new JButton();
		button.setFont(new Font("ARIAL",Font.PLAIN, 9));
		button.setText(controller.getAudioMode().getName());
		button.setSize(new Dimension(80, 25));
		button.setLocation(new Point(70, 82));
		button.setBackground(new Color(000, 200, 200));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setText(controller.nextAudioMode().getName());
			}
		});
		return button;
	}
	
	
	public JButton getAudioToggle() {
		JButton button = new JButton();
		button.setFont(new Font("ARIAL", Font.PLAIN, 9));
		button.setText("Audio");
		button.setSize(new Dimension(60, 25));
		button.setLocation(new Point(05, 82));
		button.setBackground(new Color(000, 200, 000));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.toggleMuteAudio()) {
					button.setBackground(new Color(200, 000, 000));
				} else {
					button.setBackground(new Color(000, 200, 000));
				}
			}
		});
		return button;
	}
	
	
	public JButton getToggleOBS() {
		JButton button = new JButton();
		button.setFont(new Font("ARIAL", Font.PLAIN, 8));
		button.setText("OBS");
		button.setSize(new Dimension(50, 25));
		button.setBackground(new Color(200, 000, 000));
		button.setLocation(new Point(330, 82));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (controller.getUserInterface().toggleOBSFrame()) {
					button.setBackground(new Color(000, 200, 000));
				} else {
					button.setBackground(new Color(200, 000, 000));
				}
			}
		});
		return button;
	}
	
	public ArrayList<TimePresetButton> getTimerButtons() {
		return timerButtons;
	}
	
	public void updateTimeDisplay(Scheduler scheduler){
		timer.setText(scheduler.getFormattedTimer());
		timer.setForeground(scheduler.getState().getTimerColor());
	}
	
}
