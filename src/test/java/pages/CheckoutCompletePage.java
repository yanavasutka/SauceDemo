package pages;

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

    public void open() {
        driver.get(baseUrl + "/checkout-complete.html");
    }

    public String getTheThankYouMessage() {
        return driver.findElement(THANK_YOU_MESSAGE).getText();
    }

    public String getTheOrderMessage() {
        return driver.findElement(ORDER_MESSAGE).getText();
    }

    public void clickOnTheBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    public String getTheCheckoutCompletePageTitle () {
        return driver.findElement(CHECKOUT_COMPLETE_PAGE_TITLE).getText();
    }
}
