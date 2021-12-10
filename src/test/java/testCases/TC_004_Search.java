package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.SearchResultsPage;
import testBase.BaseClass;

public class TC_004_Search extends BaseClass {

    @Test
    public void SearchResults() {

        try {
            String searchString = rb.getString("searchtext");
            driver.get(rb.getString("appURL"));
            driver.manage().window().maximize();
            HomePage hp = new HomePage(driver);
            hp.searchResults(searchString);

            SearchResultsPage searchResultsPage = new SearchResultsPage(driver);

            String actualSearchResults = searchResultsPage.getSearchResults();


            if (searchString.equals(actualSearchResults)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } catch (Exception e) {

            Assert.fail();
            logger.info("Search Results failed");
        }

        logger.info("Search Results Fininshed");



    }
}
