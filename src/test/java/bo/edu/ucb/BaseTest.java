package bo.edu.ucb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    String driverPath = "C:\\chrome-win64\\chrome.exe";

    WebDriver driver;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }
}
