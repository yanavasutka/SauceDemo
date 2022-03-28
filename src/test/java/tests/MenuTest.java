package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MenuTest extends BaseTest {

    @Test (description = "Checking the ALL ITEMS Button in the Sidebar")
    public void allItemsButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        menuPage.clickOnTheMenuButton();
        menuPage.clickOnTheAllItemsButton();
        assertEquals(productsPage.getTheProductsPageTitle(), "PRODUCTS");
    }

    @Test (description = "Checking the LOGOUT Button in the Sidebar")
    public void logoutButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        menuPage.clickOnTheMenuButton();
        menuPage.clickOnTheLogoutButton();
        assertTrue(loginPage.loginButtonIsDisplayed());
    }

    @Test (description = "Checking the Reset App State Button in the Sidebar")
    public void resetAppSateButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickOnTheAddToCartButton("Sauce Labs Backpack");
        assertEquals(productsPage.getTheNumberOfProductsInTheCart(), "1");
        menuPage.clickOnTheMenuButton();
        menuPage.clickOnTheResetAppState();
        assertFalse (productsPage.isTheNumberOfProductsDisplayedOnTheCartBadge());
    }
}
