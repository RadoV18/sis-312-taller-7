package bo.edu.ucb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    @FindBy(xpath = "//a[@href='/payment']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//a[@href='/product_details/2']")
    private WebElement product;

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public boolean isProductOnCheckout() {
        return product.isDisplayed();
    }

    public String getProductName() {
        return product.getText();
    }
}
