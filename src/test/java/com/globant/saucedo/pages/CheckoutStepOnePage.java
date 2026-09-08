package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object del paso final del checkout antes de completar la compra.
 * Permite confirmar la operación presionando el botón Finish.
 */
public class CheckoutStepOnePage extends BasePage {

    @FindBy(css = "[data-test='finish']")
    private WebElement finishButton;

    /**
     * Crea una nueva instancia de la página de checkout step one.
     *
     * @param driver instancia activa del navegador
     */
    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Finaliza la compra y navega a la pantalla de confirmación.
     *
     * @return instancia de la página de compra completada
     */
    public CompletePage pressFinishButton() {
        click(finishButton);
        return new CompletePage(driver);
    }
}