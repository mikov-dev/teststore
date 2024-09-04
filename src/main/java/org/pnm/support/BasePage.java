package org.pnm.support;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public String baseUrl;
    private Properties prop;

    public String getTestStoreUrl() {
        prop = readPropertiesFile("src/main/resources/config.properties");
        return prop.getProperty("baseUrl");
    }

    public String getHomepageUrl() {
        prop = readPropertiesFile("src/main/resources/config.properties");
        return prop.getProperty("homepageUrl");
    }

    public Properties readPropertiesFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return prop;
    }

}
