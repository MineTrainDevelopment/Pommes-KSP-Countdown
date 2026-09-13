package de.minetrain.contdown.frame.OBSFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.minetrain.contdown.enums.SchedulerState;
import de.minetrain.contdown.main.Controller;
import de.minetrain.contdown.main.KerbalCountMain;

public class OBSFrame extends JFrame{
	private static final long serialVersionUID = -60212138807002291L;
	public JLabel Timer;
	private JLabel border;

	private static final ImageIcon BORDER_PNG = new ImageIcon(
			KerbalCountMain.FILE_DIRECTORY + "icons\\Countdown OBS Rand.png");
	private static final ImageIcon ICON_PNG = new ImageIcon(
			KerbalCountMain.FILE_DIRECTORY + "icons\\Pommes.png");
	
	public OBSFrame(Controller controller) {
		super("OBS countdown");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Components.FrameSize());
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
		
		Timer = new JLabel();
		Timer.setLocation(5, 2);
		Timer.setSize(305, 55);
		Timer.setFont(new Font("ARIAL", Font.PLAIN, 55));
		if (controller.getScheduler().getState() == SchedulerState.RESET) {
			Timer.setForeground(new Color(200, 000, 000));
		}
		if (controller.getScheduler().getState() == SchedulerState.RUNNING) {
			Timer.setForeground(new Color(000, 200, 000));
		}
		if (controller.getScheduler().getState() == SchedulerState.PAUSED) {
			Timer.setForeground(new Color(255, 136, 000));
		}
		Timer.setText("T- 00:00:00");
		
		add(border);
		add(Timer);
		setVisible(false);
		
	}

	private class DragListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			Point currentPt = e.getLocationOnScreen();
			setLocation((int) currentPt.getX() - 152, (int) currentPt.getY() - 27);
		}
	}
}
