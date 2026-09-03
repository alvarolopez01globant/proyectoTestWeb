import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {


       // Base page class for common functionality across all pages

    //**POM Practice
    //You are automating the https://www.saucedemo.com/ web application.
    //Create a new Selenium - Java - TestNG project, and configure it to launch and test the
    //required webpage on Chrome browser. Implement on your framework the following
    //scenarios, each one as a different test:

    //● Purchase a product: Follow the complete buyflow of the page, selecting a
    //random product, adding it to the cart, adding the personal data, and check you
    //are successfully arriving at the “Thank you for your purchase” page.
    //● Removing elements of the shopping cart: Add 3 different elements to the
    //shopping cart, enter to the cart page, remove them and check the shopping cart
    //is empty.

    //● Logout: try to log out and check if you are correctly redirected to the login page.



    //For this implementation, follow the rules described next:
    //● Page Object Model should be correctly implemented, making sure to reuse
    //certain elements and define base pages as needed for common methods and
    //elements.
    //● Page factory is required.
    //● Before annotations should be used to manage preconditions. Any other required
    //annotations can be implemented as needed**//

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver=driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    protected void click (WebElement element) {
        waitForVisibility(element);
        element.click();
    }

    protected void writeText(WebElement element, String text) {
        waitForVisibility(element);
        element.clear();
        element.sendKeys(text);
    }

    //menu hamburguesa
    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenuButton;

    @FindBy(data-test="inventory-sidebar-link")
    private WebElement inventorySidebarLink;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutSidebarLink;

    //presionar menu hamburguesa
    public void clickHamburgerMenuButton() {
        click(hamburgerMenuButton);
    }

    //salir de la aplicacion
    public void clickLogoutSidebarLink() {
        click(logoutSidebarLink);
        return new LoginPage(driver);
    }



}