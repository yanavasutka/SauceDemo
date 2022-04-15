package pages;

import io.qameta.allure.Step;
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

    @Step("Opening CheckoutInformationPage")
    public void open() {
        driver.get(baseUrl + "/checkout-step-one.html" );
    }

    @Step("Filling the CHECKOUT fields using the first name {firstName}, the last name {lastName}, the postal code {postalCode}")
    public void fillTheCheckoutFields (String firstName, String lastName, String postalCode){
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }

    @Step("Click on the CONTINUE button")
    public void clickOnTheContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    @Step("Click on the CANCEL button")
    public void clickOnTheCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Getting the error message")
    public String getErrorMessage () {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Getting the CHECKOUT INFORMATION page title")
    public String getTheCheckoutInformationPageTitle () {
        return driver.findElement(CHECKOUT_INFORMATION_PAGE_TITLE).getText();
    }
}
