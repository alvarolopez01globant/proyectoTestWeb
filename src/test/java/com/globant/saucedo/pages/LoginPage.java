package com.globant.saucedo.pages;

import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page Object para la pantalla de inicio de sesión de SauceDemo.
 * Gestiona el ingreso de credenciales y la validación de carga de la página.
 */
public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    /**
     * Crea una nueva instancia de la página de login.
     *
     * @param driver instancia activa del navegador
     */
    public LoginPage(WebDriver driver) { super(driver); }

    /**
     * Inicia sesión con las credenciales indicadas.
     *
     * @param username nombre de usuario
     * @param password contraseña
     * @return instancia de la página de productos tras autenticación exitosa
     */
    public ProductsPage login(String username, String password) {
        writeText(userNameField, username);
        writeText(passwordField, password);
        click(loginButton);
        return new ProductsPage(driver);
    }

    /**
     * Verifica que el botón de login esté visible para confirmar que la página cargó.
     *
     * @return {@code true} si la página de login está visible
     */
    public boolean isAtLoginPage() {
        waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }
}