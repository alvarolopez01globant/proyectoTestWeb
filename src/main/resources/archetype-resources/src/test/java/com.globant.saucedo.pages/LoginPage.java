import org.openqa.selenium.support.FindBy;

public class LoginPage estends BasePage{

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage login(String username, String password) {
        writeText(userNameField, username);
        writeText(passwordField, password);
        click(loginButton);
        return new ProductsPage(driver);
    }
    public boolean isAtLoginPage() {
        waitForVisibility(loginButton);
        return loginButton.isDisplayed();
    }





}