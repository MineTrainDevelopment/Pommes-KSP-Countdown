package de.minetrain.contdown.enums;

import java.time.Duration;

public enum DurationPresets {
	///0 Seconds
	NONE(Duration.ofSeconds(0)),
	///15 Seconds
	VERY_SHORT(Duration.ofSeconds(-15)),
	///30 Seconds
	SHORT(Duration.ofSeconds(-30)),
	///60 Seconds | 1 Minute
	DEFAULT(Duration.ofSeconds(-60)),
	///120 Seconds | 2 Minutes
	LONG(Duration.ofSeconds(-120)),
	///300 Seconds | 5 Minutes
	VERY_LONG(Duration.ofSeconds(-300)),
	///1 Hour
	EXTREM_LONG(Duration.ofHours(-1));
	
	private Duration duration;
	
	public Duration getDuration(){
		return duration;
	}

	public String getButtonText() {
		Duration absDuration = duration.abs();
		return String.format("%02d:%02d:%02d",
				absDuration.toHoursPart(),
				absDuration.toMinutesPart(),
				absDuration.toSecondsPart());
	}
	
	private DurationPresets(Duration duration) {
		this.duration = duration;
	}
	
	
}
