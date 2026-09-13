package de.minetrain.contdown.enums;

import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Optional;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum AudioFiles {
	T0(Duration.ofSeconds(0), "0"),
	T1(Duration.ofSeconds(-1), "1"),
	T2(Duration.ofSeconds(-2), "2"),
	T3(Duration.ofSeconds(-3), "3"),
	T4(Duration.ofSeconds(-4), "4"),
	T5(Duration.ofSeconds(-5), "5"),
	T6(Duration.ofSeconds(-6), "6"),
	T7(Duration.ofSeconds(-7), "7"),
	T8(Duration.ofSeconds(-8), "8"),
	T9(Duration.ofSeconds(-9), "9"),
	T10(Duration.ofSeconds(-10), "10"),
	T15(Duration.ofSeconds(-15), "15"),
	T30(Duration.ofSeconds(-30), "30"),
	IGNITION(Duration.ofSeconds(1), "ignition"),
	LIFTOFF(Duration.ofSeconds(2), "liftoff"),
	NORMAL(Duration.ofSeconds(19), "normal"),
	DOWNRANGE(Duration.ofSeconds(24), "downrange"),
	MAX_Q(Duration.ofSeconds(60), "maxq"),
	HOLD(null, "hold");
	
	private static final Logger log = LoggerFactory.getLogger(AudioFiles.class);
	
	private Duration duration;
	private String audioFile;
	
	
	public Duration getDuration(){
		return duration;
	}
	
	private AudioFiles(Duration duration, String audioFile) {
		this.duration = duration;
		this.audioFile = audioFile;
	}
	
	
	public void playSound(AudioType audioType) {
		File file = new File(audioType.getFileDirectory() + audioFile + ".wav");
		
		try {
			if(file.exists()){
				AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
				
				Clip clip = AudioSystem.getClip();
				clip.open(audioStream);
				clip.start();
			}
		} catch (Exception e) {
			log.warn("Unable to load audio -> " + file.getAbsolutePath(), e);
		}
	}
	
	public static Optional<AudioFiles> getByDuration(Duration byDuration) {
	    return Arrays.stream(values())
	            .filter(audio -> audio.getDuration() != null)
	            .filter(audio -> audio.getDuration().toMillis() == byDuration.toMillis())
	            .findFirst();
	}
}
