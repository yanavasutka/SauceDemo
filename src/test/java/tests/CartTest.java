package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test (description = "Checking the function of adding a product to the cart")
    public void productShouldBeAddedIntoTheCart() {
        loginPage.open();
        loginPage.login (USERNAME, PASSWORD);
        productsPage.clickOnTheAddToCartButton("Sauce Labs Backpack");
        productsPage.clickOnTheAddToCartButton("Sauce Labs Bike Light");
        cartPage.open();
        assertEquals(cartPage.getTheNumberOfProductsInTheCart(), 2, "The number of products in the cart is not correct");
        assertEquals(cartPage.checkTheProductPriceInTheCart("Sauce Labs Backpack"), "$29.99");
    }

    @Test(description = "Checking the function of removing a product from the cart")
    public void productShouldBeRemovedFromTheCart() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickOnTheAddToCartButton("Sauce Labs Backpack");
        productsPage.clickOnTheAddToCartButton("Sauce Labs Bike Light");
        cartPage.open();
        cartPage.clickOnTheRemoveButton("Sauce Labs Backpack");
        assertEquals(cartPage.getTheNumberOfProductsInTheCart(), 1);
    }

    @Test(description = "Checking the CONTINUE button in the cart")
    public void continueShoppingButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.open();
        cartPage.clickOnTheContinueShoppingButton();
        assertEquals(productsPage.getTheProductsPageTitle(), "PRODUCTS");
    }

    @Test(description = "Checking the CHECKOUT button in the cart")
    public void checkoutButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.open();
        cartPage.clickOnTheCheckoutButton();
        assertEquals(checkoutInformationPage.getTheCheckoutInformationPageTitle(), "CHECKOUT: YOUR INFORMATION");
    }
}
