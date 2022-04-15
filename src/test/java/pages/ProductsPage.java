package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductsPage extends BasePage {

    //div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']

    String addToCartButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    String removeButton = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";
    public static final By SORT_BUTTON = By.cssSelector(".product_sort_container"),
            PRODUCT_PRICE = By.cssSelector(".inventory_item_price"),
            PRODUCT_NAME = By.cssSelector(".inventory_item_name"),
            PRODUCTS_PAGE_TITLE = By.xpath("//span[text()='Products']"),
            PRODUCTS_NUMBER_IN_CART = By.cssSelector(".shopping_cart_badge");
            /* NAME_A_TO_Z_BUTTON = By.xpath("//select[@class='product_sort_container']//option[@value='az']"),
            NAME_Z_TO_A_BUTTON = By.xpath("//select[@class='product_sort_container']//option[@value='za']"),
            PRICE_LOWTOHIGH_BUTTON = By.xpath("//select[@class='product_sort_container']//option[@value='lohi']"),
            PRICE_HIGHTOLOW_BUTTON = By.xpath("//select[@class='product_sort_container']//option[@value='hilo']");
             */

    public ProductsPage (WebDriver driver) {
        super (driver);
    }

    @Step("Opening ProductsPage")
    public void open() {
        driver.get( baseUrl + "/inventory.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated (PRODUCTS_PAGE_TITLE));
    }

    @Step("Getting the PRODUCTS page title")
    public String getTheProductsPageTitle () {
        return driver.findElement( PRODUCTS_PAGE_TITLE).getText();
    }

    @Step("Adding the product to the cart")
    public void clickOnTheAddToCartButton(String product) {
        driver.findElement(By.xpath(String.format(addToCartButton, product))).click();
    }

    @Step("Removing the product from the cart")
    public void clickOnTheRemoveButton (String product) {
        driver.findElement(By.xpath(String.format(removeButton, product))).click();
    }

    @Step("Getting the product name")
    public String getProductName (int productNumber) {
        List<WebElement> product = driver.findElements(PRODUCT_NAME);
        return product.get(productNumber).getText();
    }

    @Step("Getting the product price")
    public String getProductPrice (int productNumber) {
        List<WebElement> product = driver.findElements(PRODUCT_PRICE);
        return product.get(productNumber).getText();
    }

    @Step("Click on the SHOPPING CART button")
    public void clickOnTheShoppingCart(){
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @Step("Checking the number of products in the cart")
    public String getTheNumberOfProductsInTheCart() {
        return driver.findElement(PRODUCTS_NUMBER_IN_CART).getText();
    }

    @Step("Checking if the right number of products is displayed on the cart badge")
    public boolean isTheNumberOfProductsDisplayedOnTheCartBadge() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        int numberOfProducts = driver.findElements(PRODUCTS_NUMBER_IN_CART).size();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        return numberOfProducts != 0;
    }

    @Step("Checking if the SORT button is available")
    public boolean isSortPossible() {
        return driver.findElement(SORT_BUTTON).isDisplayed();
    }

    @Step("Choosing the kind of sorting")
    public void sort (String sorting) {
        new Select(driver.findElement(SORT_BUTTON)).selectByVisibleText(sorting);
    }
}
