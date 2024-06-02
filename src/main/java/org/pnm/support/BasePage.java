package org.pnm.support;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage {

    public WebDriver driver;
    public String baseUrl;
    private Properties prop;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        prop = readPropertiesFile("src/main/resources/settings.properties");
        baseUrl = prop.getProperty("baseUrl");
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
