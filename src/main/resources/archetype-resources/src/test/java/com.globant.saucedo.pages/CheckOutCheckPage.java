import org.openqa.selenium.support.FindBy;

public class CheckOutCheckPage {

    @FindBy(data-test = "finish")
    private WebElement finishButton;

    public void PressFinishButton() {
        click(finishButton);
        return new CompletePage(driver);
    }

}