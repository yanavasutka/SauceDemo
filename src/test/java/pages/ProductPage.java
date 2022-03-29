package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {

    String inventoryItemLink = "/inventory-item.html?id=";

    public static final By PRODUCT_NAME = By.xpath("//div[@class='inventory_details_desc_container']/div"),
            PRODUCT_PRICE = By.cssSelector(".inventory_details_price"),
            PRODUCT_DESCRIPTION = By.xpath("//div[@class='inventory_details_desc_container']/div[2]"),
            REMOVE_BUTTON = By.xpath("//button[text()='Remove']"),
            ADD_TO_CART_BUTTON = By.xpath("//button[text()='Add to cart']"),
            BACK_TO_PRODUCTS_BUTTON = By.id ("back-to-products");

    public ProductPage (WebDriver driver ) {
        super (driver);
    }

    public void open (int itemIndex ) {
        driver.get (baseUrl + inventoryItemLink + itemIndex);
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_NAME));
    }

    public String getProductName() {
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getProductPrice() {
        return driver.findElement(PRODUCT_PRICE).getText();
    }

    public String getProductDescription() {
        return driver.findElement(PRODUCT_DESCRIPTION).getText();
    }

    public void clickOnTheRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void clickOnTheAddToCartButton() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public void clickOnTheBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }
}
