package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(css = "[data-test='first-name']")
    private WebElement firstNameInput;

    @FindBy(css = "[data-test='last-name']")
    private WebElement lastNameInput;

    @FindBy(css = "[data-test='postal-code']")
    private WebElement postalCodeInput;

    @FindBy(css = "[data-test='continue']")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutStepOnePage fillCheckoutForm(String firstName, String lastName, String postalCode) {
        writeText(firstNameInput, firstName);
        writeText(lastNameInput, lastName);
        writeText(postalCodeInput, postalCode);
        click(continueButton);
        return new CheckoutStepOnePage(driver);
    }
}