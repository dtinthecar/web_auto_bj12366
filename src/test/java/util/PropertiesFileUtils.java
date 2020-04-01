package util;

import java.io.IOException;
import java.util.Properties;

import base.BaseTester;

public class PropertiesFileUtils {
	private static Properties urlProperties = new Properties();

	static {
		try {
			urlProperties.load(PropertiesFileUtils.class.getResourceAsStream("/url.properties"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String get (String urlKey) {
		return urlProperties.getProperty(urlKey);
	}
}
