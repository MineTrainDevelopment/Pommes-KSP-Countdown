package de.minetrain.contdown.main;

import de.minetrain.contdown.enums.AudioType;
import de.minetrain.contdown.enums.DurationPresets;
import de.minetrain.contdown.enums.SchedulerState;
import de.minetrain.contdown.frame.UserInterface;
import de.minetrain.contdown.scheduler.Scheduler;

public class Controller {
	private boolean muteAudio = false;
	private AudioType audioMode = AudioType.getDefault();
	private DurationPresets durationPresets = DurationPresets.SHORT;
	
	private Scheduler scheduler;
	private UserInterface userInterface;
	
	public Controller() {
		this.scheduler = new Scheduler(this);
		this.userInterface = new UserInterface(this);
	}
	
	public Scheduler getScheduler() {
		return scheduler;
	}
	
	public UserInterface getUserInterface() {
		return userInterface;
	}
	
	/**
	 * @return returns new {@link AudioType}
	 */
	public AudioType nextAudioMode(){
		this.audioMode = this.audioMode.getNext();
		return audioMode;
	}
	
	public AudioType getAudioMode() {
		return audioMode;
	}
	
	public boolean toggleMuteAudio() {
		this.muteAudio = !this.muteAudio;
		return muteAudio;
	}
	
	public boolean isMuteAudio() {
		return muteAudio;
	}
	
	public DurationPresets getDurationPresets() {
		return durationPresets;
	}

	public void setDurationPresets(DurationPresets durationPresets) {
		this.durationPresets = durationPresets;
		if(scheduler.getState() == SchedulerState.RESET){
			resetTimer();
		}
	}
	
	public void resetTimer(){
		scheduler.reset(durationPresets.getDuration());
	}
	

	
	
}
