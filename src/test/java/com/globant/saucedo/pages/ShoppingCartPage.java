package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.By;
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

    private List<WebElement> getRemoveButtons() {
        return driver.findElements(By.cssSelector("button[data-test^='remove']"));
    }

    @FindBy(css = "#checkout")
    private WebElement checkoutButton;

    private int countCartItems() {
        return driver.findElements(By.cssSelector(".cart_item")).size();
    }

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
        Assert.assertTrue(countCartItems() == 0, "The shopping cart is not empty");
    }

    /**
     * Obtiene la cantidad de elementos actualmente visibles en el carrito.
     *
     * @return cantidad de artículos en el carrito
     */
    public int getCartItemsCount() {
        return countCartItems();
    }

    /**
     * Elimina un producto del carrito si existe al menos uno.
     */
    public void removeProductFromCart() {
        List<WebElement> buttons = getRemoveButtons();
        if (!buttons.isEmpty()) {
            click(buttons.get(0));
        }
    }

    /**
     * Elimina todos los productos del carrito.
     */
    public void removeAllProductsFromCart() {
        while (!getRemoveButtons().isEmpty()) {
            click(getRemoveButtons().get(0));
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