package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_005_Logout extends BaseClass {

    @Test
    public void test_logout()

    {
        driver.get(rb.getString("appURL"));
        driver.manage().window().maximize();
        HomePage homepage = new HomePage(driver);
        homepage.clickMyAccount();
        homepage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(rb.getString("email"));
        loginPage.setPassword(rb.getString("password"));
        loginPage.clickLogin();

        boolean targetpage = loginPage.isMyAccountPageExists();
        if (targetpage) {
            Assert.assertTrue(true);
        }

        else {
            Assert.assertTrue(false);
        }

        homepage.clickMyAccount();
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        myAccountPage.clickLogout();

        LogoutPage logoutPage = new LogoutPage(driver);

        boolean logOutPageExists = logoutPage.isLogOutPageExists();

        if(logOutPageExists) {
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }
    }
}
