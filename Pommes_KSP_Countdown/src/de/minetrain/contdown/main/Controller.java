package de.minetrain.contdown.main;

import de.minetrain.contdown.enums.AudioType;
import de.minetrain.contdown.enums.SchedulerState;
import de.minetrain.contdown.enums.DurationPresets;
import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.OBSFrame.OBSFrame;
import de.minetrain.contdown.scheduler.Scheduler;

public class Controller {
	private boolean muteAudio = false;
	private SchedulerState schedulerState = SchedulerState.RESET;
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
	
	public void resetTimer(){
		scheduler.reset(durationPresets.getDuration());
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
	
	public boolean toggleOBSFrame(){
		obsFrame.setVisible(!obsFrame.isVisible());
		return obsFrame.isVisible();
	}

	public DurationPresets getDurationPresets() {
		return durationPresets;
	}

	public void setDurationPresets(DurationPresets durationPresets) {
		this.durationPresets = durationPresets;
		if(schedulerState == SchedulerState.RESET){
			resetTimer();
		}
	}

	public SchedulerState getSchedulerState() {
		return schedulerState;
	}

	public void setSchedulerState(SchedulerState counterState) {
		this.schedulerState = counterState;
		getMainFrame().updateTimeDisplay();
	}

	public MainFrame getMainFrame() {
		return mainFrame;
	}
	
	
	
}
