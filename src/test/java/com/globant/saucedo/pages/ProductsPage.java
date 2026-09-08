package com.globant.saucedo.pages;


import com.globant.saucedo.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Clase que representa la página principal del catálogo de productos (Inventory/Products)
 * en la aplicación SauceDemo. Contiene la interacción con los artículos, gestión del carrito
 * y el menú de navegación general.
 *
 * @author Alvaro Lopez
 * @version 1.0
 */
public class ProductsPage extends BasePage {

    // ==========================================
    // LOCALIZADORES DE LA PÁGINA (PAGE FACTORY)
    // ==========================================

    /** Botón icono para acceder al carrito de compras */
    @FindBy(css = ".shopping_cart_link")
    private WebElement shoppingCartButton;

    /** Lista dinámica de botones que se encuentran actualmente en estado "Add to Cart" */
    @FindBy(css = "button[data-test^='add-to-cart']")
    private List<WebElement> addToCartButtons;

    /** Lista dinámica de botones que se encuentran actualmente en estado "Remove" */
    @FindBy(css = "button[data-test^='remove']")
    private List<WebElement> removeButtons;

    /** Botón para desplegar el menú hamburguesa lateral */
    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenuButton;

    /** Enlace dentro del menú lateral para cerrar la sesión actual */
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutSidebarLink;

    // ==========================================
    // CONSTRUCTOR
    // ==========================================

    /**
     * Inicializa los elementos web de la página de productos utilizando {@link PageFactory}.
     *
     * @param driver Instancia activa de {@link WebDriver}
     */
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    // ==========================================
    // MÉTODOS DE INTERACCIÓN
    // ==========================================

    /**
     * Añade una cantidad determinada de productos al carrito de compras.
     * Selecciona consecutivamente los primeros botones "Add to cart" disponibles.
     *
     * @param count Número de productos a agregar
     */
    public void addMultipleProductsToCart(int count) {
        for (int i = 0; i < count; i++) {
            if (!addToCartButtons.isEmpty()) {
                click(addToCartButtons.get(0));
            } else {
                break;
            }
        }
    }

    /**
     * Agrega el primer producto disponible en la tienda al carrito de compras.
     */
    public void addProductToCart() {
        if (!addToCartButtons.isEmpty()) {
            click(addToCartButtons.get(0));
        }
    }

    /**
     * Elimina del catálogo el primer producto que se encuentre actualmente en estado "Remove".
     */
    public void removeProductFromInventory() {
        if (!removeButtons.isEmpty()) {
            click(removeButtons.get(0));
        }
    }

    /**
     * Comprueba si la cantidad de productos agregados (en estado "Remove")
     * coincide con la cantidad esperada.
     *
     * @param expectedCount Número esperado de elementos agregados
     * @return {@code true} si coincide el conteo, de lo contrario {@code false}
     */
    public boolean isProductAdded(int expectedCount) {
        return removeButtons.size() == expectedCount;
    }

    /**
     * Agrega un producto específico al carrito de compras mediante su ID o selector dinámico.
     *
     * @param productId Identificador (ID HTML) del botón del producto a agregar
     */
    public void addSpecificProductToCart(String productId) {
        WebElement specificAddButton = driver.findElement(By.id(productId));
        click(specificAddButton);
    }

    /**
     * Navega a la página del carrito de compras.
     *
     * @return Una nueva instancia de {@link ShoppingCartPage}
     */
    public ShoppingCartPage goToShoppingCart() {
        click(shoppingCartButton);
        return new ShoppingCartPage(driver);
    }

    /**
     * Despliega el menú hamburguesa lateral.
     */
    public void clickHamburgerMenuButton() {
        click(hamburgerMenuButton);
    }

    /**
     * Realiza el proceso de logout cerrando el menú lateral y redirigiendo a la pantalla de inicio de sesión.
     *
     * @return Una nueva instancia de {@link LoginPage}
     */
    public LoginPage logout() {
        clickHamburgerMenuButton();
        click(logoutSidebarLink);
        return new LoginPage(driver);
    }

    public LoginPage clickLogoutSidebarLink() {
        return logout();
    }
}