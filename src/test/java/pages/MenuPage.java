package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuPage extends BasePage {

    public static final By MENU_BUTTON = By.id("react-burger-menu-btn"),
            ALL_ITEMS_BUTTON = By.id ("inventory_sidebar_link"),
            ABOUT_BUTTON = By.id("about_sidebar_link"),
            LOGOUT_BUTTON = By.id("logout_sidebar_link"),
            RESET_APP_STATE_BUTTON = By.id("reset_sidebar_link"),
            PRODUCTS_PAGE_TITLE = By.cssSelector(".title");

    public MenuPage(WebDriver driver) {
        super (driver);
    }

    @Step("Opening ProductsPage")
    public void open() {
        driver.get( baseUrl + "/inventory.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated (PRODUCTS_PAGE_TITLE));
    }

    @Step("Click on the MENU button")
    public void clickOnTheMenuButton() {
        driver.findElement(MENU_BUTTON).click();
    }

    @Step("Click on the ALL ITEMS button")
    public void clickOnTheAllItemsButton() {
        driver.findElement(ALL_ITEMS_BUTTON).click();
    }

    @Step("Click on the ABOUT button")
    public void clickOnTheAboutButton() {
        driver.findElement(ABOUT_BUTTON).click();
    }

    @Step("Click on the LOGOUT button")
    public void clickOnTheLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Click on the RESET APP STATE button")
    public void clickOnTheResetAppState() {
        driver.findElement(RESET_APP_STATE_BUTTON).click();
    }
}
