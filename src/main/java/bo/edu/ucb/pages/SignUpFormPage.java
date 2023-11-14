package bo.edu.ucb.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class SignUpFormPage {

    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "address1")
    private WebElement addressInput;

    @FindBy(xpath = "//select[@data-qa='country']")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipCodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;

    public SignUpFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickMrRadioButton() {
        mrRadioButton.click();
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void setFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void setCountry(String country) {
        Select countrySelect = new Select(this.countrySelect);
        countrySelect.selectByVisibleText(country);
    }

    public void setState(String state) {
        stateInput.sendKeys(state);
    }

    public void setCity(String city) {
        cityInput.sendKeys(city);
    }

    public void setZipCode(String zipCode) {
        zipCodeInput.sendKeys(zipCode);
    }

    public void setMobileNumber(String mobileNumber) {
        mobileNumberInput.sendKeys(mobileNumber);
    }

    public void clickCreateAccountButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", createAccountButton);
        createAccountButton.click();
    }
}
