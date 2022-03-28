package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final By USER_INPUT = By.id("user-name"),
            PASSWORD_INPUT = By.id("password"),
            LOGIN_BUTTON = By.id("login-button"),
            ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super (driver);
    }

    public void open() {
        driver.get(baseUrl);
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    public void login(String user, String password) {
        driver.findElement (USER_INPUT).sendKeys (user);
        driver.findElement (PASSWORD_INPUT).sendKeys(password);
        driver.findElement (LOGIN_BUTTON).click();
        // MOVE TO PRODUCTS PAGE
    }

    public String getError () {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    public boolean loginButtonIsDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}
