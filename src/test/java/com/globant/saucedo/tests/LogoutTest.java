package com.globant.saucedo.tests;

import com.globant.saucedo.pages.LoginPage;
import com.globant.saucedo.pages.ProductsPage;
import com.globant.saucedo.utils.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Prueba de cierre de sesión.
 */
public class LogoutTest extends BaseTest {

    /**
     * Realiza logout y valida redirección a la pantalla de login.
     */
    @Test
    public void shouldLogoutAndRedirectToLoginPage() {
        ProductsPage productsPage = loginPage.login("standard_user", "secret_sauce");
        LoginPage returnedLoginPage = productsPage.logout();

        Assert.assertTrue(
                returnedLoginPage.isAtLoginPage(),
                "User was not redirected to login page after logout."
        );
    }
}
