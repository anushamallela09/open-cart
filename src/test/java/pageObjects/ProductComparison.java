package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductComparison {
    WebDriver driver;
    public ProductComparison(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    @FindBy(xpath = "//div[@id='content']/table/tbody[1]/tr[1]/td[2]")
    WebElement Product;

    public String getProduct() {
        return Product.getText();
    }


}
