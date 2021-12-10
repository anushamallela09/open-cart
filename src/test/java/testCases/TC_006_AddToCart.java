package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchResultsPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_006_AddToCart extends BaseClass {

    @Test
    public void test_AddToCart() throws InterruptedException {
        String expectedSuccessMessage = "Success: You have added iMac to your shopping cart!";
        String expectedShoppingCartProduct = rb.getString("searchtext");
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(rb.getString("email"));
        loginPage.setPassword(rb.getString("password"));
        loginPage.clickLogin();
        homePage.searchResults(rb.getString("searchtext"));
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.ClickAddToCart();
        String actualsuccessMessage = searchResultsPage.getSuccessMessage();

        if (actualsuccessMessage.contains(expectedSuccessMessage)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
            Thread.sleep(5000);
        searchResultsPage.ClickShoppingCart();
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        String actualShoppingCartProduct = shoppingCartPage.shoppingCartProduct();

        if (actualShoppingCartProduct.contains(expectedShoppingCartProduct)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }

    }


}

