package pageObjects;

import com.sun.webkit.dom.DOMWindowImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(name ="search")
    WebElement Search;

    @FindBy(xpath="//button[@class='btn btn-default btn-lg']")
    WebElement SearchButton;

    @FindBy(xpath="//ul[@class ='nav navbar-nav']//li[1]/a[contains (text(),'Desktops')]")
    WebElement DesktopLink;

    @FindBy(xpath = "//nav[@id='menu']//div[2]//ul//li[1]//div[1]//li[1]//a")
    WebElement PCLink;

    @FindBy(xpath = "//div[@id='content']//div[1]//div[3]//div[1]")
    WebElement Rightarrow;

    @FindBy(xpath = "//div[@id='content']//div[1]//div[3]//div[2]")
    WebElement Leftarrow;

    @FindBy(xpath = "//div[@id='content']//div[1]//div[1]//a")
    WebElement Continue;

    @FindBy(xpath ="//div[@class='swiper-pagination carousel0 swiper-pagination-clickable swiper-pagination-bullets']//span[5]")
    WebElement Bullets;

    @FindBy(xpath = "//i[@class='fa fa-caret-down']")
    WebElement Currency;

    @FindBy(xpath = "//button[contains(text(),'€ Euro')]")
    WebElement Euro;

    @FindBy(xpath = "//p[contains(text(),'518.16€')]")
    WebElement Price;

    @FindBy(xpath = "//button[normalize-space()='$ US Dollar']")
    WebElement Dollor;

    @FindBy (xpath = "//div[@id='content']//div[1]//div[1]//div[2]//p[2]")
    WebElement DollorPrice;

    @FindBy(xpath = "//a[normalize-space()='Site Map']")
    WebElement SiteMap;

    //Actions

    public void setSiteMap() {
        SiteMap.click();
    }

    public char setDollor() {
        Currency.click();
        Dollor.click();
       String DollorVal = DollorPrice.getText();
       char DollorChar = DollorVal.charAt(0);
       return DollorChar;
    }
    public void setCurrency() {
        Currency.click();
        Euro.click();
    }



    public char setEuro() {
      String priceVal  = Price.getText();
       char euroVal = priceVal.charAt(priceVal.length()-1);
       return euroVal;
    }
    public void setBullets() {
        Bullets.click();
    }

    public int numberOfProducts() {
        int rowcount = driver.findElements(By.xpath("//div[@id='content']//div[@class='row']//div[@class='product-thumb transition']")).size();
    return rowcount;
    }


    public void scrollDown() {

        ((JavascriptExecutor)
                driver).executeScript("window.scrollBy(200,300)");
    }

    public void scrollEndOfPage() {

        ((JavascriptExecutor)
                driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public String setTitle() {
      /*String title =((JavascriptExecutor)
               driver).executeScript("return.document.title;").toString();
        return title;*/
        String title = driver.getTitle();
        return title;
    }

    public void clickRightArrow() throws InterruptedException {
        Continue.click();
        Thread.sleep(3000);
        Rightarrow.click();
        Leftarrow.click();
    }
    public void setDesktopLink() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(DesktopLink).build().perform();
        Thread.sleep(2000);
        PCLink.click();
    }
    public void clickMyAccount() {
        MyAccount.click();
    }

    public void clickRegister() {
        Register.click();
    }

    public void clickLogin() {
        Login.click();
    }

    public void searchResults(String searched) {
        Search.sendKeys(searched);
        SearchButton.click();

    }
}
