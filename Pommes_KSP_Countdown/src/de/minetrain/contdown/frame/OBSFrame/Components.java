package de.minetrain.contdown.frame.OBSFrame;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;

public class Components {
	
	public static DisplayMode Screen() {
		DisplayMode screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		return screen;
	}
	
	public static Dimension FrameSize(){
		Dimension size = new Dimension();
		
		switch (Screen().getHeight()) {
		case 1080: size.setSize(305,55); break;
		default: size.setSize(305,55); break;}
		
		return size;
	}
}
