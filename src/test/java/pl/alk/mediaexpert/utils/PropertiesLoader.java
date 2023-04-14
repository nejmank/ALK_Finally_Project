package pl.alk.mediaexpert.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static String loadProperty(String propertyName) throws IOException{
        InputStream inputStream = new FileInputStream("/home/student/IdeaProjects/ALKProjektZaliczeniowy/config.properties");
        Properties properties = new Properties();
        properties.load(inputStream);

        return properties.getProperty(propertyName);
    }
}
