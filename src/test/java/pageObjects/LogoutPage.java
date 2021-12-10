package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

    WebDriver driver;


    public LogoutPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath="//h1[normalize-space()='Account Logout']")
    WebElement Logouttext;

    public boolean isLogOutPageExists()
    {
        try
        {
            return (Logouttext.isDisplayed());
        }
        catch(Exception e)
        {
            return(false);
        }
    }
}
