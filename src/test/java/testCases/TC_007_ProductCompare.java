package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ProductComparison;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC_007_ProductCompare extends BaseClass {
    @Test
    public void ProductCompare() throws InterruptedException {
       String expectedProductCompareToolTip = "Compare this Product";
       String expectedSuccessMsg = "Success: You have added iMac to your product comparison!";
       String expectedPagetitle = "Product Comparison";
       String expectedProduct = rb.getString("searchtext");
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        homePage.searchResults(rb.getString("searchtext"));
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.moveCursorOver();
       String actualProductCompareToolTip = searchResultsPage.getTooltTiptext();

       if(expectedProductCompareToolTip.equals(actualProductCompareToolTip)) {
           Assert.assertTrue(true);
       }
       else {
           Assert.assertTrue(false);
       }

       String actualSuccessMsg = searchResultsPage.getSuccessMsgProduct();
       if(actualSuccessMsg.contains(expectedSuccessMsg)) {
           Assert.assertTrue(true);
       }
        else {
        Assert.assertTrue(false);
       }
        Thread.sleep(4000);
        searchResultsPage.clickProductComparision();
        ProductComparison productComparison = new ProductComparison(driver);
        String actualPageTitle = productComparison.getPageTitle();
        Assert.assertEquals(expectedPagetitle,actualPageTitle);

        String actualProduct = productComparison.getProduct();
        Assert.assertEquals(actualProduct,expectedProduct);

    }
}
