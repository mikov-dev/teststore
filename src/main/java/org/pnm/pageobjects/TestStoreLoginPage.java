package org.pnm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pnm.support.BasePage;

public class TestStoreLoginPage extends BasePage {

    public TestStoreLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By signInLink = By.cssSelector(".user-info span");
    By emailInput = By.id("field-email");
    By passwordInput = By.id("field-password");
    By loginButton = By.id("submit-login");

    public WebElement getEmailInput() {
        return driver.findElement(emailInput);
    }

    public WebElement getPasswordInput() {
        return driver.findElement(passwordInput);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }


    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(emailInput).isDisplayed() &&
                driver.findElement(passwordInput).isDisplayed() &&
                driver.findElement(loginButton).isDisplayed();
    }

    public void navigateToLoginPage() {
        driver.findElement(signInLink).click();
    }
}
