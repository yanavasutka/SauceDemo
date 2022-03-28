package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutInformationTest extends BaseTest {

    @Test(description = "If the fields on the CHECKOUT: YOUR INFORMATION page are not filled in, the error message should appear")
    public void allFieldsShouldBeRequired () {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.open();
        cartPage.clickOnTheCheckoutButton();
        checkoutInformationPage.fillTheCheckoutFields("", "", "");
        checkoutInformationPage.clickOnTheContinueButton();
        assertEquals(checkoutInformationPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test (description = "Checking the CONTINUE button on the CHECKOUT: YOUR INFORMATION page")
    public void continueButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.open();
        cartPage.clickOnTheCheckoutButton();
        checkoutInformationPage.fillTheCheckoutFields("Yana", "Vasyutich", "23560");
        checkoutInformationPage.clickOnTheContinueButton();
        assertEquals(checkoutOverviewPage.getTheCheckoutOverviewPageTitle(), "CHECKOUT: OVERVIEW");
    }

    @Test (description = "Checking the CANCEL button on the CHECKOUT: YOUR INFORMATION page")
    public void cancelButton() {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        cartPage.open();
        cartPage.clickOnTheCheckoutButton();
        checkoutInformationPage.fillTheCheckoutFields("Yana", "Vasyutich", "23560");
        checkoutInformationPage.clickOnTheCancelButton();
        assertEquals(cartPage.getTheCartPageTitle(), "YOUR CART");
    }
}
