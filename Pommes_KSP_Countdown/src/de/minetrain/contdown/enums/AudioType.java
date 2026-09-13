package de.minetrain.contdown.enums;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import de.minetrain.contdown.main.KerbalCountMain;

public enum AudioType {
	//ENUM(isAktiv, fileDirectory, name)
	SPACE_X(true, "space_x", "SpaceX"),
	MINETRAIN(true, "minetrain", "MineTrain"),
	POMMES(false, "pommes", "Pömmes"),
	RANDOM(true, null, "Random");
	
	private static final Random RANDOMIZER = new Random();
	private boolean enabled;
	private String fileName;
	private String name;
	
	public boolean isEnabled(){
		return enabled;
	}
	
	private String getFileName(){
		return this == AudioType.RANDOM ? getRandom().fileName : this.fileName;
	}
	
	public String getFileDirectory(){
		return KerbalCountMain.FILE_DIRECTORY + "audio\\" + getFileName() + "\\";
	}
	
	public String getName(){
		return name;
	}
	

	private AudioType(boolean enabled, String fileName, String name) {
		this.enabled = enabled;
		this.fileName = fileName;
		this.name = name;
	}
	
	public AudioType getNext() {
		return (AudioType) Stream.of(values()).filter(AudioType::isEnabled).toArray()[(ordinal() + 1) % values().length];
	}
	
	public static final AudioType getRandom() {
		List<AudioType> types = Stream.of(values()).filter(type -> type != RANDOM && type.isEnabled()).toList();
		return types.get(RANDOMIZER.nextInt(types.size()));
	}
	
	public static final AudioType getDefault(){
		return SPACE_X;
	}
	

}
