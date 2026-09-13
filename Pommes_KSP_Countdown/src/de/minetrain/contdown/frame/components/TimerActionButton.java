package de.minetrain.contdown.frame.components;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.minetrain.contdown.enums.TimerActionButtonType;
import de.minetrain.contdown.frame.scaling.Dimension;
import de.minetrain.contdown.frame.scaling.Location;
import de.minetrain.contdown.frame.scaling.Size;

public class TimerActionButton extends JButton {
	private static final long serialVersionUID = 323154578110594916L;
	private static final Font FONT = new Font("ARIAL", Font.PLAIN, Size.of(8));
	private static final java.awt.Dimension SIZE = Dimension.of(50, 25);

	public TimerActionButton(TimerActionButtonType type) {
		super(type.getName());
		setFont(FONT);
		setSize(SIZE);
		setBackground(type.getButtonColor());
		
		switch (type) {
		case START:
			setLocation(Location.of(5, 40));
			break;
			
		case PAUSE:
			setLocation(Location.of(60, 40));
			break;
			
		case RESET:
			setLocation(Location.of(115, 40));
			break;

		default:
			break;
		}
	}
	
	public TimerActionButton setAction(ActionListener action){
		addActionListener(action);
		return this;
	}

}
