package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {

    public static final By FIRST_NAME = By.id("first-name"),
            LAST_NAME = By.id("last-name"),
            POSTAL_CODE = By.id("postal-code"),
            CONTINUE_BUTTON = By.id("continue"),
            CANCEL_BUTTON = By.id ("cancel"),
            ERROR_MESSAGE = By.xpath("//div[@class='error-message-container error']/h3"),
            CHECKOUT_INFORMATION_PAGE_TITLE = By.cssSelector(".title");

    public CheckoutInformationPage(WebDriver driver) {
        super (driver);
    }

    public void open() {
        driver.get(baseUrl + "/checkout-step-one.html" );
    }

    public void fillTheCheckoutFields (String firstName, String lastName, String postalCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }

    public void clickOnTheContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickOnTheCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getErrorMessage () {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public String getTheCheckoutInformationPageTitle () {
        return driver.findElement(CHECKOUT_INFORMATION_PAGE_TITLE).getText();
    }
}
