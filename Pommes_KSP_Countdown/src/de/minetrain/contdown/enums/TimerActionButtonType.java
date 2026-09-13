package de.minetrain.contdown.enums;

import java.awt.Color;

public enum TimerActionButtonType {
	START("Start", new Color(000, 255, 000)),
	PAUSE("Stop", new Color(255, 136, 000)),
	RESET("Reset", new Color(255, 000, 000));
	
	private String name;
	private Color buttonColor;
	
	public String getName() {
		return name;
	}
	
	public Color getButtonColor() {
		return buttonColor;
	}
	
	private TimerActionButtonType(String name, Color buttonColor) {
		this.name = name;
		this.buttonColor = buttonColor;
	}
}