package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Elements

    @FindBy(xpath ="//span[contains (text(),'My Account')]")
    WebElement MyAccount;

    @FindBy(linkText = "Register")
    WebElement Register;

    @FindBy(xpath = "//li/a[contains (text(),'Login')]")
    WebElement Login;

    //Actions

    public void clickMyAccount() {
        MyAccount.click();
    }

    public void clickRegister() {
        Register.click();
    }

    public void clickLogin() {
        Login.click();
    }
}
