package bo.edu.ucb.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewCartPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//a[@href='/product_details/2']")
    private WebElement product;

    public ViewCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public boolean isProductOnCart() {
        return product.isDisplayed();
    }

    public String getProductName() {
        return product.getText();
    }

}
