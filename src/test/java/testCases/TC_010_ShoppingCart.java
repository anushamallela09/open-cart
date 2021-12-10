package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.concurrent.TimeUnit;

public class TC_010_ShoppingCart extends BaseClass {
    @Test
    public void ShoppingCart() throws InterruptedException {
        String expectedSearchResult = "MacBook Pro";
        String expectedTitle = "Shopping Cart";
        String expectedProductName = "MacBook Pro";
        //String expectedTotal = "$10,000";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApp(rb.getString("email"), (rb.getString("password")));
        homePage.searchResults(rb.getString("searchproduct"));
        Thread.sleep(5000);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.clickSearchResultName(expectedSearchResult);
        Thread.sleep(5000);
        ProductPage productPage = new ProductPage(driver);
        productPage.setViewCart();
        Thread.sleep(5000);
        String actualTitle =  driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        Thread.sleep(5000);
        shoppingCartPage.verifyProductPresentInTable(expectedProductName);
        Thread.sleep(5000);
        shoppingCartPage.shippingEstimations("United States","California","90007");
        shoppingCartPage.setApplyShipping();
        Thread.sleep(5000);
        shoppingCartPage.setCheckout();
        boolean productExist = shoppingCartPage.clickRemoveProduct(expectedProductName);
        if(productExist) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
    }
}
