package de.minetrain.contdown.frame.MainFrame;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

public class Components{

	static final int i1080 = 1080;
	
	public static DisplayMode Screen() {
		DisplayMode screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		return screen;
	}
	
	public static Dimension FrameSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()) {
		case i1080: size.setSize(400, 150); break;
		default: size.setSize(1600,600); break;}
		return size;
	}
	
	
	
	

	public static Dimension StartButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()) {
		case i1080: size.setSize(50, 25); break;
		default: size.setSize(200,100); break;}
		return size;
	}

	public static Point StartButtonPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(5, 40); break;
		default: point.setLocation(20,150); break;}
		return point;
	}

	public static Font StartButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 8); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension ResetButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(50, 25); break;
		default: size.setSize(200,100); break;}
		return size;
	}

	public static Point ResetButtonPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(115,40); break;
		default: point.setLocation(440,150); break;}
		return point;
	}
	
	public static Font ResetButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 8); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension StopButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(50, 25); break;
		default: size.setSize(200,100); break;}
		return size;
	}

	public static Point StopButtonPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(60,40); break;
		default: point.setLocation(230,150); break;}
		return point;
	}
	
	public static Font StopButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 8); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension AudioButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(60,25); break;
		default: size.setSize(240,100); break;}
		return size;
	}

	public static Point AudioButtonPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(05,82); break;
		default: point.setLocation(20,450); break;}
		return point;
	}
	
	public static Font AudioButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 9); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension AudioModeButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(80,25); break;
		default: size.setSize(240,100); break;}
		return size;
	}

	public static Point AudioModeButtonPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(70,82); break;
		default: point.setLocation(280,450); break;}
		return point;
	}
	
	public static Font AudioModeButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 9); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension OBSButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(50,25); break;
		default: size.setSize(200,100); break;}
		return size;
	}

	public static Point OBSButtonPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(330,82); break;
		default: point.setLocation(1370,450); break;}
		return point;
	}
	
	public static Font OBSButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 8); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension TimerButtonSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(100,15); break;
		default: size.setSize(400,50); break;}
		return size;
	}

	public static Point TimerButtonPoint(int typ){
		Point point = new Point();
		
		switch (Screen().getHeight()) {
		case i1080:
			switch (typ) {
			case 1: point.setLocation(280,5); break;
			case 2: point.setLocation(280,25); break;
			case 3: point.setLocation(280,45); break;
			case 4: point.setLocation(175,5); break;
			case 5: point.setLocation(175,25); break;
			case 6: point.setLocation(175,45); break;
			default: break;}break;
			
		default:
			switch (typ) {
			case 1: point.setLocation(1170,20); break;
			case 2: point.setLocation(1170,90); break;
			case 3: point.setLocation(1170,160); break;
			case 4: point.setLocation(750,20); break;
			case 5: point.setLocation(750,90); break;
			case 6: point.setLocation(750,160); break;
			default: break;}break;}
		return point;
	}
	
	public static Font TimerButtonFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 10); break;
		default: font = new Font("ARIAL",Font.PLAIN, 30); break;}
		return font;
	}
	
	
	
	
	
	public static Dimension TimerSize(){
		Dimension size = new Dimension();
		switch (Screen().getHeight()){
		case i1080: size.setSize(305,30); break;
		default: size.setSize(1220,120); break;}
		return size;
	}

	public static Point TimerPoint(){
		Point point = new Point();
		switch (Screen().getHeight()) {
		case i1080: point.setLocation(5,2); break;
		default: point.setLocation(20,8); break;}
		return point;
	}
	
	public static Font TimerFont(){
		Font font;
		switch (Screen().getHeight()) {
		case i1080: font = new Font("ARIAL",Font.PLAIN, 30); break;
		default: font = new Font("ARIAL",Font.PLAIN, 120); break;}
		return font;
	}
	
	
	
	

}
