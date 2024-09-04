package logintests;

import org.pnm.pageobjects.TestStoreLoginPage;
import org.pnm.support.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreLoginTest extends BaseTest {

    TestStoreLoginPage loginPage;

    @BeforeClass
    public void setUp() {
       setUpWithChrome();
       //loginPage = new TestStoreLoginPage(driver);
       driver.get(loginPage.getTestStoreUrl());
    }

    @Test
    public void testLogin() {
        loginPage.navigateToLoginPage();
        loginPage.login("pmikov@yahoo.com", "Fury@2025");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
