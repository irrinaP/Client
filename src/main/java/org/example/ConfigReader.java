package org.example;

import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private final Properties properties;

    // Загружает параметры из конфигурационного файла
    public ConfigReader(String fileName) {
        properties = new Properties();
        try {
            properties.load(ConfigReader.class.getClassLoader().getResourceAsStream(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке конфигурации из файла: " + fileName, e);
        }
    }

    public String getServerHost() {
        return properties.getProperty("server.host");
    }

    public String getServerPort() {
        return properties.getProperty("server.port");
    }
}
