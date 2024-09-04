package org.pnm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pnm.support.BasePage;

public class Homepage extends BasePage {

    By toggle = By.cssSelector(".toggle");
    By homepageLink = By.linkText("HOMEPAGE");
    By accordionLink = By.linkText("ACCORDION");
    By browserTabsLink = By.linkText("BROWSER TABS");
    By buttonsLink = By.linkText("BUTTONS");
    By calculatorLink = By.linkText("CALCULATOR (JS)");
    By contactUsFormLink = By.linkText("CONTACT US FORM TEST");
    By dropdownCheckboxRadioLink = By.linkText("DROPDOWN CHECKBOX RADIO");
    By fileUploadLink = By.linkText("FILE UPLOAD");
    By hiddenElementsLink = By.linkText("HIDDEN ELEMENTS");
    By iFramesLink = By.linkText("IFRAMES");
    By loaderLink = By.linkText("LOADER");
    By loaderTwoLink = By.linkText("LOADER TWO");
    By loginPortalLink = By.linkText("LOGIN PORTAL");
    By mouseMovementLink = By.linkText("MOUSE MOVEMENT");
    By popUpsAndAlertsLink = By.linkText("POP UPS & ALERTS");
    By predictiveSearchLink = By.linkText("PREDICTIVE SEARCH");
    By tablesLink = By.linkText("TABLES");
    By testStoreLink = By.linkText("TEST STORE");
    By aboutMeLink = By.linkText("ABOUT ME");

    public Homepage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getToggle() {
        return driver.findElement(toggle);
    }

    public WebElement getHomepageLink() {
        return driver.findElement(homepageLink);
    }

    public WebElement getAccordionLink() {
        return driver.findElement(accordionLink);
    }

    public WebElement getBrowserTabsLink() {
        return driver.findElement(browserTabsLink);
    }

    public WebElement getButtonsLink() {
        return driver.findElement(buttonsLink);
    }

    public WebElement getCalculatorLink() {
        return driver.findElement(calculatorLink);
    }

    public WebElement getContactUsFormLink() {
        return driver.findElement(contactUsFormLink);
    }

    public WebElement getDropdownCheckboxRadioLink() {
        return driver.findElement(dropdownCheckboxRadioLink);
    }

    public WebElement getFileUploadLink() {
        return driver.findElement(fileUploadLink);
    }

    public WebElement getHiddenElementsLink() {
        return driver.findElement(hiddenElementsLink);
    }

    public WebElement getIFramesLink() {
        return driver.findElement(iFramesLink);
    }

    public WebElement getLoaderLink() {
        return driver.findElement(loaderLink);
    }

    public WebElement getLoaderTwoLink() {
        return driver.findElement(loaderTwoLink);
    }

    public WebElement getLoginPortalLink() {
        return driver.findElement(loginPortalLink);
    }

    public WebElement getMouseMovementLink() {
        return driver.findElement(mouseMovementLink);
    }

    public WebElement getPopUpsAndAlertsLink() {
        return driver.findElement(popUpsAndAlertsLink);
    }

    public WebElement getPredictiveSearchLink() {
        return driver.findElement(predictiveSearchLink);
    }

    public WebElement getTablesLink() {
        return driver.findElement(tablesLink);
    }

    public WebElement getTestStoreLink() {
        return driver.findElement(testStoreLink);
    }

    public WebElement getAboutMeLink() {
        return driver.findElement(aboutMeLink);
    }

}
