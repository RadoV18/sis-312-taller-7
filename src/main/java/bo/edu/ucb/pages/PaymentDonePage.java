package bo.edu.ucb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentDonePage {

    private WebDriver driver;
    @FindBy(xpath = "//h2[@data-qa='order-placed']/b")
    private WebElement confirmationMessage;
    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    public PaymentDonePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public boolean isConfirmationMessageDisplayed() {
        return confirmationMessage.isDisplayed();
    }

    public boolean isContinueButtonDisplayed() {
        return continueButton.isDisplayed();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
