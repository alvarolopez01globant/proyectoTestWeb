package com.globant.saucedo.tests;

import com.globant.saucedo.pages.ProductsPage;
import com.globant.saucedo.pages.ShoppingCartPage;
import com.globant.saucedo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Prueba de remoción de elementos del carrito.
 */
public class CartTest extends BaseTest {

    /**
     * Agrega 3 productos al carrito, los remueve y valida que quede vacío.
     */
    @Test
    public void shouldRemoveAllProductsFromCart() {
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        productsPage.addMultipleProductsToCart(3);

        ShoppingCartPage shoppingCartPage = productsPage.goToShoppingCart();
        shoppingCartPage.removeAllProductsFromCart();

        Assert.assertEquals(
                shoppingCartPage.getCartItemsCount(),
                0,
                "Shopping cart should be empty after removing all items."
        );
    }
}
