package org.pnm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pnm.support.BasePage;

public class TestStoreHomePage extends BasePage {

    By productThree = By.linkText("The Best Is Yet To Come'...");
    By productFour = By.linkText("The Adventure Begins Framed...");
    By productFive = By.linkText("Today Is A Good Day Framed...");
    By productSix = By.linkText("Mug The Best Is Yet To Come");
    By productSeven = By.linkText("Mug The Adventure Begins");
    By productEight = By.linkText("Mug Today Is A Good Day");

    By allProductsLink = By.cssSelector("#content section:nth-child(2) .all-product-link");
    By homeHeader = By.cssSelector(".h1");

    public TestStoreHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductThree() {
        return driver.findElement(productThree);
    }

    public WebElement getProductFour() {
        return driver.findElement(productFour);
    }

    public WebElement getProductFive() {
        return driver.findElement(productFive);
    }

    public WebElement getProductSix() {
        return driver.findElement(productSix);
    }

    public WebElement getProductSeven() {
        return driver.findElement(productSeven);
    }

    public WebElement getProductEight() {
        return driver.findElement(productEight);
    }

    public WebElement getAllProductsLink() {
        return driver.findElement(allProductsLink);
    }

    public WebElement getHomeHeader() {
        return driver.findElement(homeHeader);
    }

    //methods

    public void clickAllProductsLink() {
        getAllProductsLink().click();
    }

}
