public class CompletePage {

    @FindBy(data-test="checkout-complete-container")
    private WebElement completeHeader;

    public void assertCompleteHeaderIsDisplayed() {
        Assert.assertTrue(completeHeader.isDisplayed(), "The complete header is not displayed");
    }

}