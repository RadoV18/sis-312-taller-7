package bo.edu.ucb;

import bo.edu.ucb.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PurchaseTest extends BaseTest {

    private HomePage homePage;
    private SignUpPage signUpPage;
    private SignUpFormPage signUpFormPage;
    private AccountCreatedPage accountCreatedPage;
    private ViewCartPage viewCartPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private PaymentDonePage paymentDonePage;

    public void signUp() throws Exception {
        homePage.clickLoginButton();

        TimeUnit.SECONDS.sleep(2);
        signUpPage = new SignUpPage(driver);
        signUpPage.setName("John Doe");
        signUpPage.setEmail("john.doe" + System.currentTimeMillis() + "@gmail.com");
        signUpPage.clickSignUpButton();

        TimeUnit.SECONDS.sleep(2);
        signUpFormPage = new SignUpFormPage(driver);
        signUpFormPage.clickMrRadioButton();
        signUpFormPage.setPassword("123456");
        signUpFormPage.setFirstName("John");
        signUpFormPage.setLastName("Doe");
        signUpFormPage.setAddress("123 Main St");
        signUpFormPage.setCountry("United States");
        signUpFormPage.setState("New York");
        signUpFormPage.setCity("New York");
        signUpFormPage.setZipCode("10001");
        signUpFormPage.setMobileNumber("1234567890");
        TimeUnit.SECONDS.sleep(2);
        signUpFormPage.clickCreateAccountButton();

        accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertTrue(accountCreatedPage.isConfirmationMessageDisplayed());
        Assert.assertEquals(accountCreatedPage.getConfirmationMessage(), "ACCOUNT CREATED!");
        accountCreatedPage.clickContinueButton();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void testProductPurchase() throws Exception {
        // 1. Prepare the test
        TimeUnit.SECONDS.sleep(2);
        homePage = new HomePage(driver);
        signUp();
        TimeUnit.SECONDS.sleep(2);

        // 2. Test Logic
        homePage.addProductToCart();
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(homePage.isModalDisplayed());
        homePage.clickViewCartButton();
        TimeUnit.SECONDS.sleep(1);

        viewCartPage = new ViewCartPage(driver);
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(viewCartPage.isProductOnCart());
        Assert.assertEquals(viewCartPage.getProductName(), "Men Tshirt");
        viewCartPage.clickCheckoutButton();
        TimeUnit.SECONDS.sleep(1);

        checkoutPage = new CheckoutPage(driver);
        TimeUnit.SECONDS.sleep(1);
        Assert.assertTrue(checkoutPage.isProductOnCheckout());
        Assert.assertEquals(checkoutPage.getProductName(), "Men Tshirt");
        checkoutPage.clickPlaceOrderButton();
        TimeUnit.SECONDS.sleep(1);

        paymentPage = new PaymentPage(driver);
        paymentPage.setNameOnCard("John Doe");
        paymentPage.setCardNumber("1234123412341234");
        paymentPage.setCvc("123");
        paymentPage.setExpiryMonth("01");
        paymentPage.setExpiryYear("2026");
        paymentPage.clickSubmitButton();
        TimeUnit.SECONDS.sleep(1);

        // 3. Check the results
        paymentDonePage = new PaymentDonePage(driver);
        Assert.assertTrue(paymentDonePage.isContinueButtonDisplayed());
        Assert.assertTrue(paymentDonePage.isConfirmationMessageDisplayed());
        Assert.assertEquals(paymentDonePage.getConfirmationMessage(), "ORDER PLACED!");
        paymentDonePage.clickContinueButton();
    }
}
