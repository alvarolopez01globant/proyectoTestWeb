package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CompletePage extends BasePage {

    @FindBy(css = "[data-test='checkout-complete-container']")
    private WebElement completeHeader;

    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public void assertCompleteHeaderIsDisplayed() {
        waitForVisibility(completeHeader);
        Assert.assertTrue(completeHeader.isDisplayed(), "The complete header is not displayed");
    }
}