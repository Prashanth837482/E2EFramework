package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    public static void loadConfig() {
        try {
        	String projectPath = System.getProperty("user.dir");
        	//https://chatgpt.com/c/69230a1a-70c0-8320-b750-3f1f1265ecb7   -> link for file path generation and reason for file.separator usage
            //FileInputStream fis = new FileInputStream(projectPath+"/config/configuration.properties");
        	FileInputStream fis = new FileInputStream(projectPath + File.separator + "config"+ File.separator +"configuration.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
