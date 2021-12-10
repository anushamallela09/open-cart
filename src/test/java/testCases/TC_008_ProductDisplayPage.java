package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

import java.util.concurrent.TimeUnit;

public class TC_008_ProductDisplayPage extends BaseClass {

    @Test
    public void productDisplayPage() throws InterruptedException {

        String expectedReviewSuccess = "Thank you for your review. It has been submitted to the webmaster for approval";
        String expectedSuccessMsg = "Success: You have added MacBook to your product comparison!";
        String expectedAddToCartMsg = "Success: You have added MacBook to your shopping cart!";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginApp(rb.getString("email"),(rb.getString("password")));
        homePage.searchResults(rb.getString("searchproduct"));
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        Thread.sleep(1000);
        searchResultsPage.setImgLink();
        ProductPage productPage = new ProductPage(driver);
        productPage.setProductImage();

       String inputQuantity = productPage.getInputQuantity();
       if (inputQuantity.equals("1")) {
           Assert.assertTrue(true);
       }else {
          Assert.assertTrue(false);
       }

       productPage.setReviews("This is Excellent product");

      String actualReviewSuccess = productPage.setSuccessMsg();
      Thread.sleep(1000);
       if(actualReviewSuccess.contains(expectedReviewSuccess)) {
           Assert.assertTrue(true);
       }
       else {
           Assert.assertFalse(false);
       }

       productPage.setCompareProduct();
        Thread.sleep(1000);
        String actualSuccessMsg = productPage.getSuccessMessage();
        Thread.sleep(1000);
        if(actualSuccessMsg.contains(expectedSuccessMsg)) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

        productPage.setAddToCart();
        String actualAddToCartMsg = productPage.setAddToCartSuccessMsg();

        if(actualAddToCartMsg.contains(expectedAddToCartMsg)) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertFalse(false);
        }

    }


}


