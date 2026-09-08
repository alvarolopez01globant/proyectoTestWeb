package com.globant.saucedo.tests;

import com.globant.saucedo.pages.CheckoutPage;
import com.globant.saucedo.pages.CheckoutStepOnePage;
import com.globant.saucedo.pages.CompletePage;
import com.globant.saucedo.pages.ProductsPage;
import com.globant.saucedo.pages.ShoppingCartPage;
import com.globant.saucedo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Prueba del flujo completo de compra.
 */
public class PurchaseTest extends BaseTest {

    /**
     * Agrega un producto aleatorio, completa checkout y valida mensaje final.
     */
    @Test
    public void shouldCompletePurchaseFlow() {
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addRandomProductToCart();

        ShoppingCartPage shoppingCartPage = productsPage.goToShoppingCart();
        CheckoutPage checkoutPage = shoppingCartPage.clickCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = checkoutPage.fillCheckoutForm("Alvaro", "Lopez", "110111");
        CompletePage completePage = checkoutStepOnePage.pressFinishButton();

        Assert.assertEquals(
                completePage.getConfirmationMessage(),
                "Thank you for your order!",
                "Purchase confirmation message does not match expected text."
        );
    }
}
