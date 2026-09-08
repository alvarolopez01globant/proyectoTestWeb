package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object para el primer formulario del checkout.
 * Gestiona los datos personales previos al resumen de compra.
 */
public class CheckoutPage extends BasePage {

    @FindBy(css = "[data-test='first-name']")
    private WebElement firstNameInput;

    @FindBy(css = "[data-test='last-name']")
    private WebElement lastNameInput;

    @FindBy(css = "[data-test='postal-code']")
    private WebElement postalCodeInput;

    @FindBy(css = "[data-test='continue']")
    private WebElement continueButton;

    /**
     * Crea una nueva instancia de la página de checkout.
     *
     * @param driver instancia activa del navegador
     */
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Completa el formulario de checkout y avanza al paso siguiente.
     *
     * @param firstName nombre del comprador
     * @param lastName apellido del comprador
     * @param postalCode código postal del comprador
     * @return instancia de la página de confirmación previa a finalizar compra
     */
    public CheckoutStepOnePage fillCheckoutForm(String firstName, String lastName, String postalCode) {
        writeText(firstNameInput, firstName);
        writeText(lastNameInput, lastName);
        writeText(postalCodeInput, postalCode);
        click(continueButton);
        return new CheckoutStepOnePage(driver);
    }
}