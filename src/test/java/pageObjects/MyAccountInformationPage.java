package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MyAccountInformationPage {
    WebDriver driver;

        public MyAccountInformationPage(WebDriver driver)
        {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(id = "input-firstname")
        WebElement FirstName;

        @FindBy(id = "input-lastname")
        WebElement LastName;

        @FindBy(id = "input-telephone")
        WebElement Telephone;

        @FindBy(xpath = "//input[@value='Continue']")
        WebElement Continue;

        public void editAccountInformation(String firstName, String lastName, String phone) {
            FirstName.clear();
            FirstName.sendKeys(firstName);
            LastName.clear();
            LastName.sendKeys(lastName);
            Telephone.clear();
            Telephone.sendKeys(phone);
            Continue.click();
        }

        public String[] getAccountInformation() {

            String[] result = new String[3];
            result[0] = FirstName.getAttribute("value");
            result[1] = LastName.getAttribute("value");
            result[2] = Telephone.getAttribute("value");
            return result;
        }
    }

