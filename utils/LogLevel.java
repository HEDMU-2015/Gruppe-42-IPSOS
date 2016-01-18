package utils;

public enum LogLevel {
	INFO("INFO"), ERROR("ERROR");
	private String levelName;
	
	private LogLevel(String levelName) {
		this.levelName = levelName;
		
		
	}
}
