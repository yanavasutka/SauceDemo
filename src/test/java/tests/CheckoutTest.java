package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.ProductsPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEqualsDeep;

public class CheckoutTest extends BaseTest {

    @Test(description = "Checking that the order was placed successfully (login, adding products to the cart, filling in personal info, checking the products info and the final total, getting the message about the successful completion of the order))")
    public void orderShouldBeSuccessful() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.clickOnTheAddToCartButton("Sauce Labs Backpack");
        productsPage.clickOnTheAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickOnTheRemoveButton("Sauce Labs Backpack");
        productsPage.clickOnTheShoppingCart();
        //cartPage.checkTheProductInTheCart("Sauce Labs Bike Light");
        assertEquals(cartPage.checkTheProductPriceInTheCart("Sauce Labs Bike Light"), "$9.99");
        cartPage.clickOnTheCheckoutButton();
        checkoutInformationPage.fillTheCheckoutFields("Yana", "Vasyutich", "220306");
        checkoutInformationPage.clickOnTheContinueButton();
        checkoutOverviewPage.open();
        assertEquals(checkoutOverviewPage.getTheItemTotal(), "Item total: $39.98");
        assertEquals(checkoutOverviewPage.getTheTax(), "Tax: $3.20");
        assertEquals(checkoutOverviewPage.getTheFinalTotal(), "Total: $43.18");
        checkoutOverviewPage.clickOnTheFinishButton();
        assertEquals(checkoutCompletePage.getTheThankYouMessage(), "THANK YOU FOR YOUR ORDER");
        checkoutCompletePage.clickOnTheBackHomeButton();
        assertEquals(productsPage.getTheProductsPageTitle(), "PRODUCTS");
    }
}
