package logic;

import java.io.File;

public class Settings {
	
	public final static boolean LOGGER_ON = true;
	public final static String ERROR_LOG_PATH = System.getProperty("user.dir") + File.separator + "logs"
			+ File.separator + "error_log.txt";
	public final static String INFO_LOG_PATH = System.getProperty("user.dir") + File.separator + "logs"
			+ File.separator + "info_log.txt";
	public final static String PROPERTIES_PATH = System.getProperty("user.dir") + File.separator
			+ "properties" + File.separator +  "properties.properties";
}
