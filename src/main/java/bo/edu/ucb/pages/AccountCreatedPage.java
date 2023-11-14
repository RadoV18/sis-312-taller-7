package bo.edu.ucb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(xpath = "//h2[@data-qa='account-created']/b")
    private WebElement confirmationMessage;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isConfirmationMessageDisplayed() {
        return confirmationMessage.isDisplayed();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}
