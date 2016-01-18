package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Properties {
	Map<String, String> props = new HashMap<>();
	
	public Properties(String filePath) throws FileNotFoundException {
		File file = new File(filePath);
		if (!file.isFile() && !file.exists()) {
			throw new FileNotFoundException("File not found!");
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()))) {
			String line;
			while((line = br.readLine()) != null) {
				int index = line.indexOf("=");
				if(index > 0) {
					String key = line.substring(0, index).trim().toLowerCase();
					String value = line.substring(index + 1, line.length()).trim().toLowerCase();
					props.put(key, value);
				}
			}
		} catch(IOException exc) {
			exc.printStackTrace();
		}
		
	}

	public String get(String property) {
		try {
			if(!props.containsKey(property.toLowerCase())) {
				throw new PropertyNotFound("Could not find property with key: " + property);
			}
		} catch(PropertyNotFound exc) {
			exc.printStackTrace();
		}
		return props.get(property.toLowerCase());
	}
}