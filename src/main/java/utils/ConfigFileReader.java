package utils;

import java.io.*;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath;

    public ConfigFileReader(String filePath) {
        propertyFilePath = filePath;
        try (BufferedReader reader = new BufferedReader(new FileReader(propertyFilePath))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            throw new ConfigFileReaderException("Error reading properties file at path: " + propertyFilePath, e);
        }
    }

    public Properties getProperties() {
        return properties;
    }

    public String getPropertyByKey(String key) {
        String p = properties.getProperty(key);
        if (p != null) {
            if (p.contains("${")) {
                String envVarValueInProp = p.substring(p.indexOf("{") + 1, p.indexOf(":"));
                String envVarValue = System.getenv(envVarValueInProp);
                if (envVarValue != null) {
                    p = envVarValue;
                } else {
                    p = p.substring(p.indexOf(":") + 1, p.indexOf("}"));
                }
            }
            return p;
        } else

            throw new PropertyNotFoundException("Property not specified in the " + propertyFilePath + " file for the Key: " + key);
    }

    public static void changeProperty(String filename, String key, String value) throws IOException {
        Properties prop = new Properties();
        try (FileInputStream input = new FileInputStream(filename)) {
            prop.load(input);
            prop.setProperty(key, value);
        }

        try (FileOutputStream output = new FileOutputStream(filename)) {
            prop.store(output, null);
        }
    }

    public void setProperties(String filename, String key, String value) throws IOException {
        properties.setProperty(key, value);
        try (FileOutputStream output = new FileOutputStream(filename)) {
            properties.store(output, null);
        }
    }

    class ConfigFileReaderException extends RuntimeException {
        public ConfigFileReaderException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    class PropertyNotFoundException extends RuntimeException {
        public PropertyNotFoundException(String message) {
            super(message);
        }
    }
}
