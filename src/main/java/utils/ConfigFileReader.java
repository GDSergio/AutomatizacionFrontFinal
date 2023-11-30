package utils;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath;

    public ConfigFileReader(String filePath){
        propertyFilePath = filePath;
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            throw new RuntimeException("Properties file not found at path : " + propertyFilePath);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getPropertyByKey(String key) {
        String p = properties.getProperty(key);
        if (p != null){
            if (p.contains("${")) {
                String envVarValueInProp= p.substring(p.indexOf("{")+1,p.indexOf(":"));
                String envVarValue = System.getenv(envVarValueInProp);
                if(envVarValue != null){
                    p=envVarValue;
                }else{
                    p= p.substring(p.indexOf(":")+1,p.indexOf("}"));
                }
            }
        return p;
        }else
            throw new RuntimeException("Property not specified in the " + propertyFilePath + " file for the Key: " + key);
    }

    public static void changeProperty(String filename, String key, String value) throws IOException {
        Properties prop =new Properties();
        prop.load(new FileInputStream(filename));
        prop.setProperty(key, value);
        prop.store(new FileOutputStream(filename),null);
    }

    public void setProperties(String filename,String key, String value) throws IOException {
        properties.setProperty(key, value);
        properties.store(new FileOutputStream(filename),null);
    }
}
