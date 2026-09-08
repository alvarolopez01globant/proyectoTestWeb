package com.globant.saucedo.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigurationManager {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigurationManager.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input != null) {
                properties.load(input);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar el archivo config.properties", e);
        }
    }

    public static String getUrl() {
        return System.getProperty("url", properties.getProperty("url"));
    }

    public static String getUsername() {
        return System.getProperty("username", properties.getProperty("username"));
    }

    public static String getPassword() {
        return System.getProperty("password", properties.getProperty("password"));
    }

    public static int getTimeout() {
        return Integer.parseInt(properties.getProperty("timeout", "10"));
    }
}
