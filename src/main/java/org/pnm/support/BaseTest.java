package org.pnm.support;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pnm.verifications.Verifications;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    FileInputStream fis;
    public Properties prop;
    Actions actions;
    JavascriptExecutor js;
    WebElement element;
    ChromeOptions options;
    String chromedriverLocation = "src/main/resources/webdrivers/chromedriver.exe";
    String geckoDriverLocation = "src/main/resources/webdrivers/geckodriver.exe";
    String edgeDriverLocation = "src/main/resources/webdrivers/msedgedriver.exe";

    public Verifications verify = new Verifications();

    public BaseTest() {
        prop = new Properties();
        try {
            fis = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    WebDriver choseDriver() {
        if (prop.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", chromedriverLocation);
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
            driver = new FirefoxDriver();
        } else if (prop.getProperty("browser").equals("edge")) {
            System.setProperty("webdriver.edge.driver", edgeDriverLocation);
            driver = new EdgeDriver();
        }
        return driver;
    }

    public void setUpChoosingDriverFromProperties() {
        driver = choseDriver();
        driver.manage().window().maximize();
    }

    public void setUpWithChrome() {
        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void setUpWithChromeOptions(List<String> chromeOptions) {
        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        options = new ChromeOptions();
        options.addArguments(chromeOptions);
        driver = new ChromeDriver(options);
    }

    public void setUpWithBraveBrowser() {
        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(options);
    }

    public void setUpWithChromeOptionsAndDesiredCapabilities(List<String> chromeOptions, DesiredCapabilities desiredCapabilities) {
        System.setProperty("webdriver.chrome.driver", chromedriverLocation);
        options = new ChromeOptions();
        options.merge(desiredCapabilities);
        options.addArguments(chromeOptions);
        driver = new ChromeDriver(options);
    }

    public void setUpWithFirefox() {
        System.setProperty("webdriver.gecko.driver", geckoDriverLocation);
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void scrollIntoView(WebDriver driver, By by) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
    }

    public void scrollIntoView(WebDriver driver, WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void clickUsingJavaScript(WebDriver driver, By by) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(by));
    }

    public void clickUsingJavaScript(WebDriver driver, WebElement element) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void clickTwoElementsUsingJavascript(WebDriver driver, WebElement element, WebElement element2) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click(), arguments[1].click()", element, element2);
    }

    public void dragAndDrop(WebDriver driver, By from, By to) {
        actions = new Actions(driver);
        actions.dragAndDrop(driver.findElement(from), driver.findElement(to)).build().perform();
    }

    public void clickAndHold(WebDriver driver, By by) {
        actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(by)).build().perform();
    }

    public void pressAndHoldShift(WebDriver driver, By by) {
        actions = new Actions(driver);
        actions.keyDown(driver.findElement(by), Keys.SHIFT).build().perform();
    }

    public void holdShiftAndClick(WebDriver driver, By by) {
        actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(driver.findElement(by)).keyUp(Keys.SHIFT).build().perform();
    }

    public void releaseClick(WebDriver driver, By by) {
        actions = new Actions(driver);
        actions.release(driver.findElement(by)).build().perform();
    }

    public void doubleClick(WebDriver driver, By by) {
        actions = new Actions(driver);
        actions.doubleClick(driver.findElement(by)).build().perform();
    }

    public void switchToTab(int tabNumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNumber));
    }

    public void closeCurrentTab() {
        driver.close();
    }

    public void hoverElement(WebDriver driver, By by) {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void clickButton(By by) {
        driver.findElement(by).click();
    }

    public void moveToAndClick(By button) {
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(button)).click().perform();
    }

    public void clickUsingJavaScript(By button) {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(button));
    }

    public void enableElement(By button) {
        element = driver.findElement(button);
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')", element);
    }

    public void clickToSelectElement(By element) {
        driver.findElement(element).click();
    }

    public WebElement waitForElement(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void deleteAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }

    public Properties readPropertiesFile(String fileName) {
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return prop;
    }

}
