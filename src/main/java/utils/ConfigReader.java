package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties configProp;
	private static Properties credentialProp;

	static {
		try {
			configProp = new Properties();
//			FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
//			configProp.load(fis);
			configProp.load(new FileInputStream("src/test/resources/config.properties"));

			credentialProp = new Properties();
			credentialProp.load(new FileInputStream("src/test/resources/credentials.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getConfigProperty(String key) {
		return configProp.getProperty(key);
	}
	
	public static String getCredential(String key) {
		return credentialProp.getProperty(key);
	}
}