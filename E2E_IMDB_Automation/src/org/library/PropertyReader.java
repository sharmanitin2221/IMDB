package org.library;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {
	
	public static String applicationconfigReader(String Key) {
	try
	{
		File f = new File("./Configurationfiles/ApplciationConfig.properties");
		FileReader fr = new FileReader(f);
		Properties prop =new Properties();
		prop.load(fr);
		return prop.get(Key).toString();
	}
	catch (Exception e) {
		return null;
	}
	}

	public static String elementLocatorReader(String Key) {
	
		try
		{

		File f = new File("./ElementLocator/Locator.properties");
		FileReader fr = new FileReader(f);
		Properties prop =new Properties();
		prop.load(fr);
		return prop.get(Key).toString();
		}
		catch (Exception e) {
			 return null;
		}
		
		
	}
}
