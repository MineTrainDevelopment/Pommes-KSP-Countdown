package de.minetrain.contdown.frame.scaling;

public class Size extends BaseScaling {
	
	public static final int of(int i){
		return (int) Math.round(i * getScaling());
	}
	
}
