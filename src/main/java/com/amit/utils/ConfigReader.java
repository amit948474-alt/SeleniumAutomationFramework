package com.amit.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;
    static {
        properties = new Properties();

        try {
            InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
