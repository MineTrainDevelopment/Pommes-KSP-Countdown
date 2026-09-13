package de.minetrain.contdown.frame;

import de.minetrain.contdown.frame.MainFrame.MainFrame;
import de.minetrain.contdown.frame.second_frame.OBSFrame;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.scheduler.Scheduler;

public class UserInterface {
	
	private OBSFrame obsFrame;
	private MainFrame mainFrame;
	
	public UserInterface(Controller controller) {
		this.obsFrame = new OBSFrame(controller.getScheduler());
		this.mainFrame = new MainFrame(controller);
	}
	
	public void updateTimeDisplay(Scheduler scheduler){
		mainFrame.updateTimeDisplay(scheduler);
		obsFrame.updateTimeDisplay(scheduler);
	}
	
	public boolean toggleOBSFrame(){
		obsFrame.setVisible(!obsFrame.isVisible());
		return obsFrame.isVisible();
	}
	

}
