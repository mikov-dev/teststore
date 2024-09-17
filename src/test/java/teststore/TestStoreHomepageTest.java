package teststore;

import org.openqa.selenium.WebElement;
import org.pnm.pageobjects.TestStoreHomePage;
import org.pnm.support.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestStoreHomepageTest extends BaseTest {

    TestStoreHomePage testStoreHomePage;

    @BeforeClass
    public void setUp() {
        //setUpChoosingDriverFromProperties();
        setUpWithChrome();
        testStoreHomePage = new TestStoreHomePage(driver);
        driver.get(testStoreHomePage.getTestStoreUrl());
    }

    @DataProvider
    public WebElement[] elementsDataProvider() {
        WebElement[] elements = new WebElement[6];
        elements[0] = testStoreHomePage.getProductThree();
        elements[1] = testStoreHomePage.getProductFour();
        elements[2] = testStoreHomePage.getProductFive();
        elements[3] = testStoreHomePage.getProductSix();
        elements[4] = testStoreHomePage.getProductSeven();
        elements[5] = testStoreHomePage.getProductEight();
        return elements;
    }

    @Test(dataProvider = "elementsDataProvider")
    public void testProductsAreDisplayed(WebElement element) {
        verify.elementIsDisplayed(element);
    }

    @Test
    public void testAllProductsLink() {
        verify.elementIsDisplayed(testStoreHomePage.getAllProductsLink());
    }

    @Test
    public void testAllProductsLinkClick() {
        testStoreHomePage.getAllProductsLink().click();
        verify.elementIsDisplayed(testStoreHomePage.getHomeHeader());
    }

//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//    }

}
