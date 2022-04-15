package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;
    MenuPage menuPage;

    public static final String USERNAME = "standard_user",
            PASSWORD = "secret_sauce";

    @Parameters({"browser"})
    @BeforeMethod(description = "Opening the browser")
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        menuPage = new MenuPage(driver);

        testContext.setAttribute("driver", driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
