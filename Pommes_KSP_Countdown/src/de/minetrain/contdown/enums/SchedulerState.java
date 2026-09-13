package de.minetrain.contdown.enums;

import java.awt.Color;

public enum SchedulerState {
	RUNNING(new Color(000,200,000)),
	PAUSED(new Color(255, 136, 000)),
	RESET(new Color(225, 000,000));
	
	private Color timerColor;
	public Color getTimerColor(){
		return timerColor;
	}
	
	private SchedulerState(Color timerColor) {
		this.timerColor = timerColor;
	}
	
}
