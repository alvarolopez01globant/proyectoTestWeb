import org.openqa.selenium.support.FindBy;

public class CheckoutPage {

    @FindBy(data-test = "first-name")
    private WebElement firstNameInput;

    @FindBy(data-test = "last-name")
    private WebElement lastNameInput;

    @FindBy(data-test = "postal-code")
    private WebElement postalCodeInput;

    @FindBy(data-test = "continue")
    private WebElement continueButton;

    //metodo para rellenar los datos del formulario de checkout
    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        writeText(firstNameInput, firstName);
        writeText(lastNameInput, lastName);
        writeText(postalCodeInput, postalCode);
        click(continueButton);
        return new CheckoutCheckPage(driver);
    }



}