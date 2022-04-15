package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    public static final By THANK_YOU_MESSAGE = By.cssSelector(".complete-header"),
            ORDER_MESSAGE = By.cssSelector(".complete-text"),
            BACK_HOME_BUTTON = By.id ("back-to-products"),
            CHECKOUT_COMPLETE_PAGE_TITLE = By.cssSelector(".title");

    public CheckoutCompletePage (WebDriver driver) {
        super (driver);
    }

    @Step("Opening CheckoutCompletePage")
    public void open() {
        driver.get(baseUrl + "/checkout-complete.html");
    }

    @Step("Getting the THANK YOU message to confirm the successful order")
    public String getTheThankYouMessage() {
        return driver.findElement(THANK_YOU_MESSAGE).getText();
    }

    @Step("Getting the ORDER message")
    public String getTheOrderMessage() {
        return driver.findElement(ORDER_MESSAGE).getText();
    }

    @Step("Click on the BACK HOME button")
    public void clickOnTheBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    @Step("Getting the CHECKOUT COMPLETE page title")
    public String getTheCheckoutCompletePageTitle () {
        return driver.findElement(CHECKOUT_COMPLETE_PAGE_TITLE).getText();
    }
}
