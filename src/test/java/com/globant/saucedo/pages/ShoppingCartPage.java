package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

/**
 * Page Object para la pantalla del carrito de compras.
 * Permite validar estado del carrito, remover artículos e iniciar checkout.
 */
public class ShoppingCartPage extends BasePage {

    @FindBy(css = "button[data-test^='remove']")
    private List<WebElement> removeButtons;

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    @FindBy(css = "[data-test='inventory-item']")
    private List<WebElement> cartItems;

    /**
     * Crea una nueva instancia de la página del carrito.
     *
     * @param driver instancia activa del navegador
     */
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifica que no existan artículos en el carrito.
     */
    public void assertCartIsEmpty() {
        Assert.assertTrue(cartItems.isEmpty(), "The shopping cart is not empty");
    }

    /**
     * Elimina un producto del carrito si existe al menos uno.
     */
    public void removeProductFromCart() {
        if (!removeButtons.isEmpty()) {
            click(removeButtons.get(0));
        }
    }

    /**
     * Elimina todos los productos del carrito.
     */
    public void removeAllProductsFromCart() {
        while (!removeButtons.isEmpty()) {
            click(removeButtons.get(0));
        }
    }

    /**
     * Continúa al formulario de checkout.
     *
     * @return instancia de la página de checkout
     */
    public CheckoutPage clickCheckoutButton() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }
}