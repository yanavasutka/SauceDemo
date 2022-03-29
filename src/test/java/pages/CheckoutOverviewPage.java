package pages;

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

    public void open() {
        driver.get(baseUrl + "/checkout-step-two.html");
    }

    public String getTheItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();
    }

    public String getTheTax() {
        return driver.findElement(TAX).getText();
    }

    public String getTheFinalTotal() {
        return driver.findElement(FINAL_TOTAL).getText();
    }

    public void clickOnTheCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickOnTheFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String getTheCheckoutOverviewPageTitle () {
        return driver.findElement(CHECKOUT_OVERVIEW_PAGE_TITLE).getText();
    }
}
