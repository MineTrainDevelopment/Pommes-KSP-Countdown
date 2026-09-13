package de.minetrain.contdown.frame.scaling;

import java.awt.GraphicsEnvironment;

public class BaseScaling {

	protected static final double REFERENCE_HEIGHT = 1080;

	protected static final double getScaling() {
//		return (GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() * 2) / REFERENCE_HEIGHT;
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode().getHeight() / REFERENCE_HEIGHT;
	}

}
