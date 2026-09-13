package de.minetrain.contdown.frame.scaling;

import java.awt.GraphicsEnvironment;

public class BaseScaling {

	protected static final double REFERENCE_WIDTH = 1920;

	protected static final double getScaling() {
//		return (GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() * 2) / REFERENCE_WIDTH;
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getWidth() / REFERENCE_WIDTH;
	}

}
