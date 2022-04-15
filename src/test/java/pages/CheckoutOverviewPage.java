package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    public static final By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label"),
            TAX = By.cssSelector(".summary_tax_label"),
            FINAL_TOTAL = By.cssSelector(".summary_total_label"),
            CANCEL_BUTTON = By.id ("cancel"),
            FINISH_BUTTON = By.id("finish"),
            CHECKOUT_OVERVIEW_PAGE_TITLE = By.cssSelector(".title");

    public CheckoutOverviewPage(WebDriver driver) {
        super (driver);
    }

    @Step("Opening CheckoutOverviewPage")
    public void open() {
        driver.get(baseUrl + "/checkout-step-two.html");
    }

    @Step("Getting the item total at the final stage of placing the order")
    public String getTheItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();
    }

    @Step("Getting the tax value")
    public String getTheTax() {
        return driver.findElement(TAX).getText();
    }

    @Step("Getting the final price of the order")
    public String getTheFinalTotal() {
        return driver.findElement(FINAL_TOTAL).getText();
    }

    @Step("Click on the CANCEL button")
    public void clickOnTheCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Click on the FINISH button")
    public void clickOnTheFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    @Step("Getting the CHECKOUT OVERVIEW page title")
    public String getTheCheckoutOverviewPageTitle () {
        return driver.findElement(CHECKOUT_OVERVIEW_PAGE_TITLE).getText();
    }
}
