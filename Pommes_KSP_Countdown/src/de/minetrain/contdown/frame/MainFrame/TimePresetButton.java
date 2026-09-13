package de.minetrain.contdown.frame.MainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.minetrain.contdown.enums.DurationPresets;

public class TimePresetButton extends JButton {
	private static final long serialVersionUID = -7368057525502275053L;
	
	private static final Font FONT = new Font("ARIAL", Font.PLAIN, 10);
	private static final Dimension SIZE = new Dimension(100, 15);
	
	private final DurationPresets preset;
	
	public TimePresetButton(DurationPresets preset, MainFrame frame) {
		this.preset = preset;
		
		setFont(FONT);
		setSize(SIZE);
		setLocation(timerButtonPoint());
		setBackground(new Color(000,100,000));
		setText(preset.getButtonText());
		
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.onTimePresetButton(preset);
			}
		});
	}
	
	public TimePresetButton setAction(ActionListener listner) {
		super.addActionListener(listner);
		return this;
	}
	
	public void setAktiv(boolean state){
		setBackground(state ? new Color(000, 255, 000) : new Color(000, 100, 000));
	}
	
	public DurationPresets getPreset() {
		return preset;
	}
	
	public Point timerButtonPoint(){
		Point point = new Point();

		switch (preset) {
		case VERY_SHORT:
			point.setLocation(280, 5);
			break;
			
		case SHORT:
			point.setLocation(280, 25);
			break;
			
		case DEFAULT:
			point.setLocation(280, 45);
			break;
			
		case LONG:
			point.setLocation(175, 5);
			break;
			
		case VERY_LONG:
			point.setLocation(175, 25);
			break;
			
		case EXTREM_LONG:
			point.setLocation(175, 45);
			break;
			
		default:
			break;
		};
		
		return point;
	}
	
	
}
