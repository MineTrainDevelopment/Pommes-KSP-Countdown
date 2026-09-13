package de.minetrain.contdown.scheduler;

import java.time.Duration;
import java.util.Optional;

import de.minetrain.contdown.enums.AudioFiles;
import de.minetrain.contdown.enums.SchedulerState;
import de.minetrain.contdown.main.Controller;

public class Scheduler {
	private boolean running = false;
	private Duration duration;
	private Controller controller;
	private SchedulerState schedulerState;
	
	public Scheduler(Controller controller) {
		this.controller = controller;
		this.duration = controller.getDurationPresets().getDuration();
		this.schedulerState = SchedulerState.RESET;
		createThread();
	}
	
	private void createThread() {
		new Thread(() -> {
			while (true) {
				if (running) {
					setState(SchedulerState.RUNNING);
					Optional<AudioFiles> audioFile = AudioFiles.getByDuration(duration);
					if(audioFile.isPresent()){
						audioFile.get().playSound(controller.getAudioMode());
					}
					
					duration = duration.plusSeconds(1);
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.err.println(e);
				}
			}
		}).start();
	}
	
	
	/**
	 * @return T- 00:00:00
	 */
	public String getFormattedTimer(){
		Duration absDuration = duration.abs();
		return String.format("%s%02d:%02d:%02d",
				duration.isNegative() ? "T- " : "T+ ",
				absDuration.toHoursPart(),
				absDuration.toMinutesPart(),
				absDuration.toSecondsPart());
	}
	
	
	public void reset(Duration duration){
		this.running = false;
		this.duration = duration;
		setState(SchedulerState.RESET);

//		MainFrame.Timer.setText(Timer());
//		OBSFrame.Timer.setText(Timer());
//		MainFrame.Timer.setForeground(new Color(200,000,000));
//		OBSFrame.Timer.setForeground(new Color(200,000,000));
	}
	
	public void start() {
		this.running = true;
		setState(SchedulerState.RUNNING);
	}
	
	public void pause() {
		if(getState() == SchedulerState.RESET){
			return;
		}
		
		this.running = false;
		setState(SchedulerState.PAUSED);
		AudioFiles.HOLD.playSound(controller.getAudioMode());
	}
	
	public void resume(){
		this.running = true;
	}
	
	public SchedulerState getState() {
		return schedulerState;
	}

	public void setState(SchedulerState state) {
		this.schedulerState = state;
		controller.getMainFrame().updateTimeDisplay(state);
	}

}
