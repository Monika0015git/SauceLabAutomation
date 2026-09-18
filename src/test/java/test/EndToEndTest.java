package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutOverviewPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.ExcelReader;
import listener.TestListener;

@Listeners(TestListener.class)
public class EndToEndTest  extends BaseTest
{
    @Test
    public void completePurchaseFlow() throws InterruptedException
    {
        // Create ExcelReader object
        ExcelReader excelReader = new ExcelReader();

        // Create Page Objects
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);


        // ---------------- LOGIN ----------------

        // Verify login page logo
        loginPage.verifyLogo();

        // Get username from Excel
        String username = excelReader.getData("Sheet1", 1, 0);

        // Get password from Excel
        String password = excelReader.getData("Sheet1", 1, 1);

        // Enter username
        loginPage.enterUsername(username);

        // Enter password
        loginPage.enterPassword(password);

        // Click Login
        loginPage.clickLogin();


        // ---------------- INVENTORY ----------------

        // Verify Inventory page
        inventoryPage.verifyInventoryPage();

        // Click filter
        inventoryPage.clickFilter();

        // Verify filter options
        inventoryPage.verifySortingDropDown();

        // Apply Price Low to High filter
        inventoryPage.applyFilter();

        // Add required products to cart
        inventoryPage.addProductsToCart();

        // Click shopping cart
        inventoryPage.clickShoppingCart();


        // ---------------- CART ----------------

        // Verify Cart page
        cartPage.verifyCartPage();

        // Verify products in cart
        cartPage.verifyCartItems();

        // Click Checkout
        cartPage.clickCheckoutButton();


        // ---------------- CHECKOUT ----------------

        // Verify Checkout page
        checkoutPage.verifyCheckoutPage();

        // Enter checkout information
        checkoutPage.enterInformation();

        // Click Continue
        checkoutPage.clickContinue();


        // ---------------- CHECKOUT OVERVIEW ----------------

        // Verify Checkout Overview page
        checkoutOverviewPage.verifyCheckoutOverviewPage();

        // Verify product details
        checkoutOverviewPage.verifyProductDetails();

        // Verify product prices
        checkoutOverviewPage.verifyProductPrices();

        // Verify payment information
        checkoutOverviewPage.verifyPaymentInformation();

        // Verify item total
        checkoutOverviewPage.verifyItemTotal();

        // Verify tax
        checkoutOverviewPage.verifyTax();

        // Verify final total
        checkoutOverviewPage.verifyTotal();

        // Click Finish
        checkoutOverviewPage.clickFinish();


        // ---------------- CHECKOUT COMPLETE ----------------

        // Verify Checkout Complete page
        checkoutCompletePage.verifyCheckoutCompletePage();

        // Verify Thank You message
        checkoutCompletePage.verifyThankYouMessage();

        // Verify order confirmation message
        checkoutCompletePage.verifyOrderConfirmationMessage();

        // Verify confirmation image
        checkoutCompletePage.verifyConfirmationImage();

        // Click Back Home
        checkoutCompletePage.clickBackHome();
    }
}