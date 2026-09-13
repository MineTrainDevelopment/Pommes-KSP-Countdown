package de.minetrain.contdown.main;

import de.minetrain.contdown.enums.AudioType;
import de.minetrain.contdown.enums.SchedulerState;
import de.minetrain.contdown.enums.DurationPresets;
import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.scheduler.Scheduler;

public class Controller {
	private boolean muteAudio = false;
	private AudioType audioMode = AudioType.getDefault();
	private DurationPresets durationPresets = DurationPresets.SHORT;
	
	private Scheduler scheduler;
	private OBSFrame obsFrame;
	private MainFrame mainFrame;
	
	public Controller() {
		this.scheduler = new Scheduler(this);
		this.obsFrame = new OBSFrame(this);
		this.mainFrame = new MainFrame(this, obsFrame);
	}
	
	public Scheduler getScheduler() {
		return scheduler;
	}
	
	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	public boolean toggleOBSFrame(){
		obsFrame.setVisible(!obsFrame.isVisible());
		return obsFrame.isVisible();
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
