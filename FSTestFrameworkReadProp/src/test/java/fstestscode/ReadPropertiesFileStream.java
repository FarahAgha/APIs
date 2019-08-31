package fstestscode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesFileStream {
//	static Properties prop;
		
	public static Properties readProperties(String path){
		
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream(path)) {

	        // load a properties file
	        prop.load(input);
	} 		
		catch (IOException ex) {
	        ex.printStackTrace();
	    }
		return prop;
	}

	
	
}
