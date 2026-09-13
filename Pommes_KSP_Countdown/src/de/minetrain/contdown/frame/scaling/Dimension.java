package de.minetrain.contdown.frame.scaling;

public class Dimension extends BaseScaling {
	
	public static final java.awt.Dimension of(int width, int height){
		double scale = getScaling();
		
		return new java.awt.Dimension((int) Math.round(width * scale), (int) Math.round(height * scale));
	}
	
}
