package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("d MMMM u - H:mm:ss" )));
	}

}
