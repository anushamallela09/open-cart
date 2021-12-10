package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountInformationPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_012_MyAccount extends BaseClass {
    @Test
    public void test_MyAccount() {
        String expectedSuccessMessage = "Success: Your account has been successfully updated.";
        String expectedfirstname = rb.getString("editfirstname");
        String expectedlastname = rb.getString("editlastname");
        String expectedtelephone = rb.getString("edittelephone");
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
        myAccountPage.clickEditInfo();
        logger.info("clicked edit info");
        MyAccountInformationPage myAccountInformationPage = new MyAccountInformationPage(driver);
        myAccountInformationPage.editAccountInformation(rb.getString("editfirstname"),rb.getString("editlastname"),rb.getString("edittelephone"));
        logger.info("updated firstname,lastname and telephone");
        String actualSuccessMessage = myAccountPage.verifySuccessMessage();
        if(actualSuccessMessage.equals(expectedSuccessMessage)) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }
        logger.info("verify success message");
        myAccountPage.clickEditInfo();
        String[] actualstring = myAccountInformationPage.getAccountInformation();
        String actualfirstname = actualstring[0];
        String actuallastname = actualstring[1];
        String actualTelephone = actualstring[2];

        if(expectedfirstname.equals(actualfirstname)&&expectedlastname.equals(actuallastname)&&expectedtelephone.equals(actualTelephone)) {
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }


    }
}
