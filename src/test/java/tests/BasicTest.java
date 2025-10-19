package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTest extends BaseTest {

    @Test
    public void verifyTitle() {
        page.navigate("https://www.google.com/");
        // Optional: Handle cookie popup
        if (page.isVisible("button:has-text('Accept all')")) {
            page.click("button:has-text('Accept all')");
        }
        Assert.assertEquals(page.title(),"Google");

    }
}
