package bo.edu.ucb.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cartButton;

    @FindBy(xpath = "//div[@class='features_items']//div[@class='productinfo text-center']//a[@data-product-id='2']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='modal-body']//a[@href='/view_cart']")
    private WebElement viewCartButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickViewCartButton() {
        viewCartButton.click();
    }

    public boolean isModalDisplayed() {
        WebElement modal =  driver.findElement(By.xpath("//div[@id='cartModal']/div[@class='modal-dialog modal-confirm']"));
        return modal.isDisplayed();
    }

    public void addProductToCart() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addToCartButton);
        addToCartButton.click();
    }
}
