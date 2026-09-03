public class ShopingCarPage extends BasePage {

    // Lista de botones que están en estado "Remove" en la vista principal
    @FindBy(css = "button[data-test^='remove-sauce-labs']")
    private List<WebElement> removeButtons;

    @FindBy(css="#checkout")
    private WebElement checkoutButton;

    @FindBy(data-test="inventory-item")
    private List<WebElement> cartItems;

    // validar que la lista de compras esta vacia
    public void assertCartIsEmpty() {
        Assert.assertTrue(cartItems.isEmpty(), "The shopping cart is not empty");
    }

    //eliminar un producto del carrito de compras
    public void removeProductFromCart() {
        if (!removeButtons.isEmpty()) {
            click(removeButtons.get(0));
        }
    }

    // eliminar todos los productos del carrito de compras
    public void removeAllProductsFromCart() {
        for (WebElement button : removeButtons) {
            click(button);
        }
    }

    // hacer click en el boton de checkout
    public void clickCheckoutButton() {
        click(checkoutButton);
        return new CheckoutPage(driver);
    }


}