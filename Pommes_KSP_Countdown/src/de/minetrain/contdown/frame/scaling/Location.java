package de.minetrain.contdown.frame.scaling;

import java.awt.Point;

public class Location extends BaseScaling {
	
	public static final Point of(int x, int y){
		double scale = getScaling();
		return new Point((int) Math.round(x * scale), (int) Math.round(y * scale));
	}
	
}
