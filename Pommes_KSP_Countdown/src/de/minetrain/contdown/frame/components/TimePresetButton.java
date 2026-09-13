package de.minetrain.contdown.frame.components;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.minetrain.contdown.enums.DurationPresets;
import de.minetrain.contdown.frame.MainFrame;
import de.minetrain.contdown.frame.scaling.Dimension;
import de.minetrain.contdown.frame.scaling.Location;
import de.minetrain.contdown.frame.scaling.Size;

public class TimePresetButton extends JButton {
	private static final long serialVersionUID = -7368057525502275053L;
	
	private static final Font FONT = new Font("ARIAL", Font.PLAIN, Size.of(10));
	private static final java.awt.Dimension SIZE = Dimension.of(100, 15);
	
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
		switch (preset) {
		case VERY_SHORT:
			return Location.of(280, 5);
			
		case SHORT:
			return Location.of(280, 25);
			
		case DEFAULT:
			return Location.of(280, 45);
			
		case LONG:
			return Location.of(175, 5);
			
		case VERY_LONG:
			return Location.of(175, 25);
			
		case EXTREM_LONG:
			return Location.of(175, 45);
			
		default:
			return Location.of(0, 0);
		}
	}
	
	
}
