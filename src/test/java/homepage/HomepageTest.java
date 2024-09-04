package homepage;

import org.pnm.pageobjects.Homepage;
import org.pnm.support.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

    Homepage homepage;

    @BeforeClass
    public void setUp() {
        setUpWithChrome();
        homepage = new Homepage(driver);
        driver.get(homepage.getHomepageUrl());
    }

    @Test
    public void testHomepage() {
        homepage.getToggle().click();
    }

}
