package bo.edu.ucb;

import bo.edu.ucb.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CartTest extends BaseTest {
    private HomePage homePage;
    private SignUpPage signUpPage;
    private SignUpFormPage signUpFormPage;
    private AccountCreatedPage accountCreatedPage;
    private ViewCartPage viewCartPage;

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
    public void whenCartIsEmpty() throws Exception {
        // 1. Prepare the test
        TimeUnit.SECONDS.sleep(2);
        homePage = new HomePage(driver);
        // 2. Test Logic
        signUp();
        TimeUnit.SECONDS.sleep(2);
        homePage.clickCartButton();
        // 3. Check the results
        viewCartPage = new ViewCartPage(driver);
        Assert.assertTrue(viewCartPage.isCartEmpty());
        Assert.assertEquals(viewCartPage.getEmptyCartMessage(), "Cart is empty!");
    }

}
