package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.PCPage;
import testBase.BaseClass;

public class TC_011_HomePage extends BaseClass {

    @Test
    public void test_HomePage() throws InterruptedException {
        String expectedPCvalue = "0";
        int expectedNoOfProducts = 4;
        char expectedEuroVal = '€';
        char expectedDollorVal = '$';
        driver.get(rb.getString("appURL"));
        logger.info("Application is started");
        driver.manage().window().maximize();
        logger.info("Maximize the window");
        HomePage homePage = new HomePage(driver);
        homePage.setDesktopLink();
        logger.info("PC page is displayed");
        PCPage pcPage = new PCPage(driver);
       String actualPCvalue = pcPage.verifyPCtext();
       if(actualPCvalue.equals(expectedPCvalue)) {
           Assert.assertTrue(true);
       }
       else
       {
           Assert.assertFalse(false);
       }

       homePage.clickRightArrow();
       homePage.scrollDown();
       int actualNumberOfProducts = homePage.numberOfProducts();
       if(actualNumberOfProducts==expectedNoOfProducts) {
           Assert.assertTrue(true);
       }
       else {
           Assert.assertFalse(false);
       }
       homePage.scrollEndOfPage();
       homePage.setBullets();
       homePage.setCurrency();
       char actualEuroVal = homePage.setEuro();
       if(expectedEuroVal==actualEuroVal) {
           Assert.assertTrue(true);
       } else {
           Assert.assertTrue(false);
       }
          char actualDollorVal =  homePage.setDollor();
       if(expectedDollorVal==actualDollorVal) {
           Assert.assertTrue(true);
       }
       else {
           Assert.assertTrue(false);
       }
       }
    }


