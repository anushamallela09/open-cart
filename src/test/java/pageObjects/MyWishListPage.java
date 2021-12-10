package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyWishListPage {
    WebDriver driver;

    public MyWishListPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr")
    WebElement Rows;

    @FindBy(xpath = "//table[@class='table table-bordered table-hover']/tbody/tr/td[2]")
    WebElement Product;

    public boolean verifyProductPresentInTable(String expectedProductName) {

        boolean status = false;

        int rowcount = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr")).size();
        for(int i=1;i<=rowcount;i++) {
            String actualProductName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']/tbody/tr[" + i + "]/td[2]")).getText();
            if(expectedProductName.equals(actualProductName)){
                status = true;
            }
        }
       return status;

    }

}
