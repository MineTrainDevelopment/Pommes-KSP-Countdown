package de.minetrain.contdown.frame.second_frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.minetrain.contdown.main.KerbalCountMain;
import de.minetrain.contdown.scheduler.Scheduler;

public class OBSFrame extends JFrame{
	private static final long serialVersionUID = -60212138807002291L;
	private JLabel timer;
	private JLabel border;

	private static final ImageIcon BORDER_PNG = new ImageIcon(
			KerbalCountMain.FILE_DIRECTORY + "icons\\Countdown OBS Rand.png");
	private static final ImageIcon ICON_PNG = new ImageIcon(
			KerbalCountMain.FILE_DIRECTORY + "icons\\Pommes.png");
	
	public OBSFrame(Scheduler scheduler) {
		super("OBS countdown");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(305, 55));
		getContentPane().setBackground(new Color(000, 000, 000));
		setAlwaysOnTop(true);
		setFocusable(true);
		setUndecorated(true);
		setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(ICON_PNG.getImage());
		
		border = new JLabel();
		border.setLocation(0, 0);
		border.setIcon(BORDER_PNG);
		border.setSize(320, 55);
		border.addMouseMotionListener(new DragListener());
		
		timer = new JLabel();
		timer.setLocation(5, 2);
		timer.setSize(305, 55);
		timer.setFont(new Font("ARIAL", Font.PLAIN, 55));
		timer.setForeground(scheduler.getState().getTimerColor());
		timer.setText(scheduler.getFormattedTimer());
		
		add(border);
		add(timer);
		setVisible(false);
	}
	

	private class DragListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			Point currentPt = e.getLocationOnScreen();
			setLocation((int) currentPt.getX() - 152, (int) currentPt.getY() - 27);
		}
	}
	
	public void updateTimeDisplay(Scheduler scheduler){
		timer.setText(scheduler.getFormattedTimer());
		timer.setForeground(scheduler.getState().getTimerColor());
	}
}
