package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage {

    String removeButton = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//button",
            productPrice = "//div[text()='%s']/ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']";

    public static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name"),
            CART_PRODUCT = By.cssSelector(".cart_item"),
            CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping"),
            CHECKOUT_BUTTON = By.id("checkout"),
            CART_PAGE_TITLE = By.cssSelector(".title");

    public CartPage(WebDriver driver) {
        super (driver);
    }

    @Step("Opening CartPage")
    public void open() {
        driver.get(baseUrl + "/cart.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
    }

    @Step("Checking the product name")
    public String checkTheProductInTheCart(String product) {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    @Step("Checking the product price")
    public String checkTheProductPriceInTheCart(String product) {
        return driver.findElement(By.xpath(String.format(productPrice, product))).getText();
    }


    @Step("Removing the product from the cart")
    public void clickOnTheRemoveButton(String product) {
        driver.findElement(By.xpath(String.format(removeButton,product))).click();
    }

    @Step("Getting the number of products in the cart")
    public int getTheNumberOfProductsInTheCart() {
        List<WebElement> product = driver.findElements(CART_PRODUCT);
        return product.size();
    }

    @Step("Click on the CONTINUE SHOPPING button")
    public void clickOnTheContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Click on the CHECKOUT button")
    public void clickOnTheCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("Getting the CART page title")
    public String getTheCartPageTitle () {
        return driver.findElement(CART_PAGE_TITLE).getText();
    }
}
