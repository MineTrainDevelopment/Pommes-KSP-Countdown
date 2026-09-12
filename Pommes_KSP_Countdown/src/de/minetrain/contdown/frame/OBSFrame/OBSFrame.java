package de.minetrain.contdown.frame.OBSFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import de.minetrain.contdown.main.Controller;

public class OBSFrame {
	public static JFrame frame;
	public static JLabel Timer;
	static JLabel border;
	static Point prevPt;
	static ImageIcon borderPNG =  new ImageIcon("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Countdown OBS Rand.png");
	static ImageIcon PNG = new ImageIcon("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Pommes.png");
	
	public static void Create(){
		frame = new JFrame("OBS countdown");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Components.FrameSize());
		frame.getContentPane().setBackground(new Color(000,000,000));
		frame.setAlwaysOnTop(true);
		frame.setFocusable(true);
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setIconImage(PNG.getImage());

		borderPNG = new ImageIcon("C:\\ProgramData\\MineTrainDev\\Pommes_KSP_Countdown\\Countdown OBS Rand.png");
		border = new JLabel();
		border.setLocation(0,0);
		border.setIcon(borderPNG);
		border.setSize(320,55);
		DragListener dragListener = new DragListener();
		ClickListener clickListener = new ClickListener();
		border.addMouseListener(clickListener);
		border.addMouseMotionListener(dragListener);
		
		Timer = new JLabel();
		Timer.setLocation(5,2);
		Timer.setSize(305,55);
		Timer.setFont(new Font("ARIAL",Font.PLAIN, 55));
		if(Controller.TimmerRunning==false){Timer.setForeground(new Color(200,000,000));} 
		if(Controller.TimmerRunning==true){Timer.setForeground(new Color(000,200,000));}
		if(Controller.TimmerPause==true){Timer.setForeground(new Color(255,136,000));}
		Timer.setText("T- 00:00:00");
		
		frame.add(border);
		frame.add(Timer);
		frame.setVisible(false);
	}
	
	public static void Visible(boolean state) {
		if(state==true){frame.setVisible(true);}else{frame.setVisible(false);}
	}
	

	private static class ClickListener extends MouseAdapter{
	public void mousePressed(MouseEvent e) {
	prevPt = e.getPoint();
	}}
	
	private static class DragListener extends MouseMotionAdapter{
		public void mouseDragged(MouseEvent e) {
		Point currentPt = e.getLocationOnScreen();
		frame.setLocation((int)currentPt.getX()-152, (int)currentPt.getY()-27);
		prevPt = currentPt;
		}
	}
}
