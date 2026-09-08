package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

/**
 * Page Object para la pantalla final de compra completada.
 * Expone validaciones del estado exitoso del flujo de compra.
 */
public class CompletePage extends BasePage {

    @FindBy(css = "[data-test='checkout-complete-container']")
    private WebElement completeHeader;

    /**
     * Crea una nueva instancia de la página de compra completada.
     *
     * @param driver instancia activa del navegador
     */
    public CompletePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifica que el contenedor de confirmación de compra esté visible.
     */
    public void assertCompleteHeaderIsDisplayed() {
        waitForVisibility(completeHeader);
        Assert.assertTrue(completeHeader.isDisplayed(), "The complete header is not displayed");
    }
}