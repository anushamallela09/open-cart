package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.util.concurrent.TimeUnit;


public class TC_001_AccountRegistration extends BaseClass {


    @Test(groups = {"regression","master"})
    public void test_account_Registration() {

        logger.info("starting TC_001_AccountRegistration");
        try {
            driver.get(rb.getString("appURL"));
            logger.info("Home Page Displayed ");
            driver.manage().window().maximize();
            HomePage hp = new HomePage(driver);
            hp.clickMyAccount();
            logger.info("Clicked on My Account");
            hp.clickRegister();
            logger.info("Clicked on Register ");
            AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
            regpage.setFirstName("smith");
            logger.info("provided FirstName");
            regpage.setLastName("Roy");
            logger.info("provided LastName");
            regpage.setEmail(randomstring() + "@gmail.com");
            logger.info("Provided Email ");
            regpage.setTelephone("3456789123");
            logger.info("Provided Telephone ");
            regpage.setPassword("abcd7890");
            logger.info("Provided Password ");
            regpage.setConfirmPassword("abcd7890");
            logger.info("Provided Confrmed Password ");
            regpage.setPrivacyPolicy();
            logger.info("Set Privacy Policy ");
            regpage.clickContinue();
            logger.info("Clicked on Continue ");
            String confmsg = regpage.getConfirmationMsg();
            if (confmsg.equals("Your Account Has Been Created!")) {
                logger.info("Account Registration Success ");
                Assert.assertTrue(true);
            } else {
                captureScreen(driver,"test_account_Registration");
                logger.error("Account Registration Failed ");
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            logger.fatal("Account Registration Failed");
            Assert.fail();
        }
        logger.info("Finished TC_001_AccountRegistration");
    }
}
