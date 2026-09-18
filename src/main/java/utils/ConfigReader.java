package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader 
{
	Properties prop;

    public ConfigReader() {

        prop = new Properties();

        try 
        {
        	File file = new File("src/test/resources/config.properties");
            FileInputStream fis = new FileInputStream(file);

            prop.load(fis);

        } catch (IOException e)
         {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {

        return prop.getProperty(key);
    }

    public void setProperty(String key, String value) {

        prop.setProperty(key, value);
    }
}
