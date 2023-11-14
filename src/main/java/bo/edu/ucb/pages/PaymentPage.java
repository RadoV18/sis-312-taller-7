package bo.edu.ucb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@data-qa='name-on-card']")
    private WebElement nameOnCardInput;

    @FindBy(xpath = "//input[@data-qa='card-number']")
    private WebElement cardNumberInput;

    @FindBy(xpath = "//input[@data-qa='cvc']")
    private WebElement cvcInput;

    @FindBy(xpath = "//input[@data-qa='expiry-month']")
    private WebElement expiryMonthInput;

    @FindBy(xpath = "//input[@data-qa='expiry-year']")
    private WebElement expiryYearInput;

    @FindBy(id = "submit")
    private WebElement submitButton;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setNameOnCard(String nameOnCard) {
        nameOnCardInput.sendKeys(nameOnCard);
    }

    public void setCardNumber(String cardNumber) {
        cardNumberInput.sendKeys(cardNumber);
    }

    public void setCvc(String cvc) {
        cvcInput.sendKeys(cvc);
    }

    public void setExpiryMonth(String expiryMonth) {
        expiryMonthInput.sendKeys(expiryMonth);
    }

    public void setExpiryYear(String expiryYear) {
        expiryYearInput.sendKeys(expiryYear);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
