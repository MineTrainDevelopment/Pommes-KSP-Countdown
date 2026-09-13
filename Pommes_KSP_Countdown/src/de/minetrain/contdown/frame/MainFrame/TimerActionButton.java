package de.minetrain.contdown.frame.MainFrame;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import de.minetrain.contdown.enums.TimerActionButtonType;

public class TimerActionButton extends JButton {
	private static final long serialVersionUID = 323154578110594916L;
	private static final Font FONT = new Font("ARIAL", Font.PLAIN, 8);
	private static final Dimension SIZE = new Dimension(50, 25);

	public TimerActionButton(TimerActionButtonType type) {
		super(type.getName());
		setFont(FONT);
		setSize(SIZE);
		setBackground(type.getButtonColor());
		
		switch (type) {
		case START:
			setLocation(new Point(5, 40));
			break;
			
		case PAUSE:
			setLocation(new Point(60, 40));
			break;
			
		case RESET:
			setLocation(new Point(115, 40));
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
