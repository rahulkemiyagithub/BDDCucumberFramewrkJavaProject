package Utilities;

import java.io.FileInputStream;
import java.util.Properties;


public class ReadConfigPropertiesFile {

	Properties properties;
	String configFilePath = "config.properties";
	
	//constructor
	public ReadConfigPropertiesFile()
	{
		properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(configFilePath);
			properties.load(inputStream);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String getBrowser()
	{
		String value = properties.getProperty("browser");
		
		if(value!=null)
			return value;
		else
			throw new RuntimeException("browser not specified in config file");
	}
}
