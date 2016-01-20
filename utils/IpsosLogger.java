package utils;
import java.io.FileNotFoundException;

import logic.Settings;


public class IpsosLogger {

	private final static IpsosLogger INSTANCE = new IpsosLogger();
	IpsosFileWriter fw;

	private IpsosLogger() {}

	public static IpsosLogger getInstance() {
		return INSTANCE;
	}

	private synchronized void log(LogLevel level, String message) {
		try {
			switch (level) {
			case ERROR:
				fw = new IpsosFileWriter(Settings.ERROR_LOG_PATH);
				fw.write(level.toString() + ": " + message);
			case INFO:
				fw = new IpsosFileWriter(Settings.INFO_LOG_PATH);
				fw.write(level.toString() + ": " + message);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}

	}
	
	public void error(Exception exception) {
		String message = LogFormatter.formatException(exception);
		log(LogLevel.ERROR, message);
	}
	
	public void info(String message) {
		log(LogLevel.INFO, message);
	}

}
