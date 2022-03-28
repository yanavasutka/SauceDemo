package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SortTest extends BaseTest {

    @Test (description = "Checking the sorting function")
    public void sortingShouldBePossible(){
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        assertTrue(productsPage.isSortPossible(), "The product sorting function is not possible");
    }

    @Test (description = "Checking the sorting of products names from A to Z")
    public void productsShouldBeSortedFromAToZ () {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.sort("Name (A to Z)");
        assertEquals(productsPage.getProductName(0), "Sauce Labs Backpack", "An error occurred while sorting product names from A to Z, the first element is not correct");
        assertEquals(productsPage.getProductName(5), "Test.allTheThings() T-Shirt (Red)", "An error occurred while sorting product names from A to Z, the last element is not correct");
    }

    @Test (description = "Checking the sorting of products names from Z to A")
    public void productsShouldBeSortedFromZToA () {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.sort("Name (Z to A)");
        assertEquals(productsPage.getProductName(0), "Test.allTheThings() T-Shirt (Red)", "An error occurred while sorting product names from Z to A, the last element is not correct");
        assertEquals(productsPage.getProductName(5), "Sauce Labs Backpack", "An error occurred while sorting product names from Z to A, the last element is not correct");
    }

    @Test (description = "Checking the sorting of products by price (low to high)")
    public void productsShouldBeSortedByPriceFromLowToHigh () {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.sort("Price (low to high)");
        assertEquals(productsPage.getProductPrice(0), "$7.99", "An error occurred while sorting products by price from low to high, the first element is not correct");
        assertEquals(productsPage.getProductPrice(5), "$49.99", "An error occurred while sorting products by price from low to high, the last element is not correct");
    }

    @Test (description = "Checking the sorting of products by price (high to low)")
    public void productsShouldBeSortedByPriceFromHighToLow () {
        loginPage.open();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.sort("Price (high to low)");
        assertEquals(productsPage.getProductPrice(0), "$49.99", "An error occurred while sorting products by price from high to low, the first element is not correct");
        assertEquals(productsPage.getProductPrice(5), "$7.99", "An error occurred while sorting products by price from high to low, the last element is not correct");
    }
}
