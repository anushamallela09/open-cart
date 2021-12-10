package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_013_AddressBook extends BaseClass {
    @Test
    public void test_AddressBook() {
        String expectedTitle = "Your Store";
        String expectedSuccessMessage = "Your address has been successfully added";
        driver.get(rb.getString("appURL"));
        logger.info("Application is started");
        driver.manage().window().maximize();
        logger.info("Maximize the window");
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("Clicked on My Account ");
        hp.clickLogin();
        logger.info("Clicked on Login ");
        LoginPage lp = new LoginPage(driver);
        lp.loginApp(rb.getString("userid"),rb.getString("passWord"));
        logger.info("entered username and password");
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickLogo();
        HomePage homePage = new HomePage(driver);
        String actualTitle = homePage.setTitle();
        if(actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
        homePage.scrollEndOfPage();
        homePage.setSiteMap();
        SiteMapPage siteMapPage = new SiteMapPage(driver);
        siteMapPage.setLnkAddressBook();
        AddressBookPage addressBookPage = new AddressBookPage(driver);
        addressBookPage.setAddress("John","smith","KingfisherDrive","Mansell","30003","United States","Georgia");
        String actualSuccessMessage = addressBookPage.setSuccessMessage();
        if(actualSuccessMessage.equals(expectedSuccessMessage)) {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

}
