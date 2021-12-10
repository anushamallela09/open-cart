package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PCPage {

    WebDriver driver;

    public PCPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath="//aside[@id='column-left']//div//a[2]")
    WebElement PC;

    public String verifyPCtext() {
        String pcText = PC.getText();
        String retval = pcText.substring(8,11);
        String retText = retval.replace("(","");
        String retTextVal = retText.replace(")","");
       return retTextVal;
        }

}
