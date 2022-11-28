package utilities;

import java.io.FileReader;
import java.util.Properties;

public class Config {
	static FileReader file;
	static Properties properties;

	public static Properties getProperties() {
		try {
			file = new FileReader(System.getProperty("user.dir") + "//config.properties");
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Properties getLogins() {
		try {
			file = new FileReader(System.getProperty("user.dir") + "//logins.properties");
			Properties properties = new Properties();
			properties.load(file);
			return properties;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
