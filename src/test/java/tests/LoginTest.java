package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @DataProvider (name = "Input data for negative login tests")
    public Object[][] negativeLoginData() {
        return new Object[][]{
                {"test", "", "Epic sadface: Password is required"},
                {"", "test", "Epic sadface: Username is required"},
                {"locked_out_user", PASSWORD, "Epic sadface: Sorry, this user has been locked out."},
                {USERNAME , "12345", "Epic sadface: Username and password do not match any user in this service"},
                {"test", PASSWORD, "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "Input data for negative login tests")
    public void loginShouldNotBeSuccessful (String user, String password, String error) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(loginPage.getError(), error, "The error message is not correct");
    }

    @DataProvider(name = "Input data for positive login tests")
    public Object[][] positiveLoginData() {
        return new Object[][]{
                {USERNAME, PASSWORD, "PRODUCTS"},
                {"problem_user", PASSWORD, "PRODUCTS"},
                {"performance_glitch_user", PASSWORD, "PRODUCTS"},
        };
    }

    @Test(dataProvider = "Input data for positive login tests")
    public void loginShouldBeSuccessful (String user, String password, String productsPageTitle) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(productsPage.getTheProductsPageTitle(), productsPageTitle, "Login isn't successful");
    }
}
