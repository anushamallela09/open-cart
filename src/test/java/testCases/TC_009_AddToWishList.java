package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.concurrent.TimeUnit;

public class TC_009_AddToWishList extends BaseClass {

    @Test
    public void AddToWishList() throws InterruptedException {
        String expectedSuccessAddToWishList = "Success: You have added MacBook to your wish list!";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApp(rb.getString("email"), (rb.getString("password")));
        homePage.searchResults(rb.getString("searchproduct"));
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.setImgLink();
        ProductPage productPage = new ProductPage(driver);
        String actualSuccessAddToWishList = productPage.setAddToWishList();
        Thread.sleep(1000);
        if(actualSuccessAddToWishList.contains(expectedSuccessAddToWishList)){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

        productPage.setWishList();

        String actualTitle = driver.getTitle();
        String expectedTitle = "My Wish List";
        Assert.assertEquals(actualTitle,expectedTitle);

        MyWishListPage myWishListPage = new MyWishListPage(driver);

        boolean status = myWishListPage.verifyProductPresentInTable(rb.getString("searchproduct"));
        if(status){
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue(false);
        }

    }
}