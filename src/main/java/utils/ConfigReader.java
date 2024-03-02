package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * 
 * @author Pritam Singh
 *
 */
public class ConfigReader {

	public static String getProperty(String key){
		FileInputStream fis;
		String value = null;
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");    
			Properties prop=new Properties();
			prop.load(fis);
			value= (String)prop.get(key.toLowerCase().trim());
			System.out.println(value);
		} catch (Exception e) {
			try {
				throw new Exception("Key Is Not Present: "+key);
			} catch (Exception e1) {
			}
		}
		return value;
	}
}
