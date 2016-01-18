package utils;

public class Settings {
	
	public final static boolean LOGGER_ON = true;
	public final static String ERROR_LOG_PATH = System.getProperty("user.dir") + System.lineSeparator() + "logs"
			+ System.lineSeparator() + "errorLogPath.txt";
	public final static String INFO_LOG_PATH = System.getProperty("user.dir") + System.lineSeparator() + "logs"
			+ System.lineSeparator() + "infoLogPath.txt";
	public final static String PROPERTIES_PATH = System.getProperty("user.dir") + System.lineSeparator() + "properties.txt"
			+ System.lineSeparator() + "properties.properties";
}
