package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFormatter {
	
	
	
	public static String formatException(Exception exception) {
		
		String output = "[" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMMM u - H:mm:ss")) + "]"
		+ exception.getMessage() + System.lineSeparator();
		return output;
	}
}
