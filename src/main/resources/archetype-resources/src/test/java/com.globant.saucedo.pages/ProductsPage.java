public class ProductsPage extends BasePage{

    //BOTTON DE ACCESO AL CARRITO DE COMPRAS
    @FindBy(css = ".shopping_cart_link")

    private WebElement shoppingCartButton;
    //BOTONES DE AÑADIR Y REMOVER PRODUCTOS DEL CARRITO DE COMPRAS
    // Lista de botones que están en estado "Add to Cart" en la vista principal
    @FindBy(css = "button[data-test^='add-to-cart-sauce-labs']")
    private List<WebElement> addToCartButtons;

    // Lista de botones que están en estado "Remove" en la vista principal
    @FindBy(css = "button[data-test^='remove-sauce-labs']")
    private List<WebElement> removeButtons;




    // añade una cantidad especifica de elementos al carrito de compras, haciendo clic en los botones "Add to Cart" disponibles

    public void addMultipleProductsToCart(int count) {
        for (int i = 0; i < count && !addToCartButtons.isEmpty(); i++) {
            // Siempre hace clic en el primer botón "Add to cart" disponible
            click(addToCartButtons.get(0));
        }}



        public void addProductToCart() {
            if (!addToCartButtons.isEmpty()) {
                click(addToCartButtons.get(0));
            }
        }

        // Elimina el primer producto que encuentre en estado 'Remove' en la tienda
        public void removeProductFromInventory() {
            if (!removeButtons.isEmpty()) {
                click(removeButtons.get(0));
            }
        }

        // Comprueba si hay productos agregados (en estado 'Remove') en la tienda
        public boolean isProductAdded(int expectedCount) {
            return removeButtons.size() == expectedCount;
        }

        //agrega un elemento especifico que sera la maleta
        public void addSpecificProductToCart(String productId) {
            WebElement specificAddButton = driver.findElement(By.id(productId));
            click(specificAddButton);
        }


        //MODULOS DE ACCESO AL CARRITO DE COMPRAS
        public void goToShoppingCart() {
            click(shoppingCartButton);
        }






}