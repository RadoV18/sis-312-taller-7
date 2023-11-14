package bo.edu.ucb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private WebElement nameInput;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private WebElement emailInput;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private WebElement signUpButton;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setName(String name) {
        nameInput.sendKeys(name);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
