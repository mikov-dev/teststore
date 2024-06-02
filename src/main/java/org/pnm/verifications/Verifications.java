package org.pnm.verifications;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.logging.Logger;

public class Verifications {

    Logger logger = Logger.getLogger("Verifications");


    public void textContains(WebElement element, String text) {
        try {
            Assert.assertTrue(element.getText().contains(text));
        } catch (AssertionError e) {
            logger.warning(e.getMessage());
            throw new AssertionError(e);
        }
    }

    public void textDoesNotContain(WebElement element, String text) {
        try {
            Assert.assertFalse(element.getText().contains(text));
        } catch (AssertionError e) {
            logger.warning(e.getMessage());
            throw new AssertionError(e);
        }
    }

    public void alertTextEquals(Alert alert, String text) {
        try {
            Assert.assertEquals(alert.getText(), text);
        } catch (AssertionError e) {
            logger.warning(e.getMessage());
            throw new AssertionError(e);
        }
    }

    public void textEquals(WebElement element, String text) {
        try {
            Assert.assertEquals(element.getText(), text);
        } catch (AssertionError e) {
            logger.warning(e.getMessage());
            throw new AssertionError(e);
        }
    }

    public void elementIsDisplayed(WebElement element) {
        try {
            Assert.assertTrue(element.isDisplayed());
        } catch (AssertionError e) {
            logger.warning(e.getMessage());
            throw new AssertionError(e);
        }
    }

    public void elementContainsText(WebElement element, String text) {
        try {
            Assert.assertTrue(element.getText().contains(text));
        } catch (AssertionError e) {
            logger.warning(e.getMessage());
            throw new AssertionError(e);
        }
    }

}
