package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiteMapPage {

    WebDriver driver;

    public SiteMapPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@id='content']//div[1]//div[2]//ul[1]//li[2]//ul[1]//li[3]//a")
    WebElement lnkAddressBook;

    public void setLnkAddressBook() {
        lnkAddressBook.click();
    }
}
