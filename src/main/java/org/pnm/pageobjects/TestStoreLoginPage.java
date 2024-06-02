package org.pnm.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.pnm.support.BasePage;

public class TestStoreLoginPage extends BasePage {

    public TestStoreLoginPage(WebDriver driver) {
        super(driver);
        super.baseUrl
    }

    public By signInLink = By.cssSelector(".user-info span");
    By email = By.id("field-email");
    By password = By.id("field-password");
    By loginButton = By.id("submit-login");

    public void login(String email, String password) {
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();
    }

    public boolean isLoginPageDisplayed() {
        return driver.findElement(email).isDisplayed() &&
                driver.findElement(password).isDisplayed() &&
                driver.findElement(loginButton).isDisplayed();
    }

    public void navigateToLoginPage() {
        driver.findElement(signInLink).click();
    }
}
