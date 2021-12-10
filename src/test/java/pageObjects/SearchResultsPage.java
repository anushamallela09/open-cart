package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(linkText = "iMac")
    WebElement SearchResult;

    @FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
    WebElement AddToCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement SuccessMessage;

    @FindBy(linkText = "shopping cart")
    WebElement ShoppingCart;

    @FindBy(xpath = "//button[@data-original-title = 'Compare this Product']")
    WebElement Compare;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement SuccessMsgProductCompare;

    @FindBy(xpath = "//a[contains(text(),'product comparison')]")
    WebElement lnkProductComparision;

    @FindBy(xpath = "//div[@id='content']//div[1]//a//img[@title='MacBook']")
    WebElement imgLink;

    @FindBy(xpath = "//body/div[@id='product-search']/div[@class='row']/div[@id='content']/div[3]/div[1]/div[@class='product-thumb']//h4")
    WebElement SearchResults;

    public void clickSearchResultName(String expectedSearchResult) {
        int noOfProduct = driver.findElements(By.xpath("//div[@id='content']/div[3]/div")).size();
        System.out.println("No of Products : " + noOfProduct);

        for(int i =1;i<=noOfProduct;i++) {
            String actualSearchResult = driver.findElement(By.xpath("//div[@id='content']/div[3]/div[" + i + "]/div/div[2]/div/h4")).getText();
            System.out.println("Product Name : " + actualSearchResult);

            if(actualSearchResult.equals(expectedSearchResult)) {
                System.out.println("Entered to if condition");
                driver.findElement(By.xpath("//div[@id='content']/div[3]/div[" + i + "]/div/div[2]/div/h4/a")).click();
            }
        }
    }

    public void setImgLink() {
        imgLink.click();
    }

    public void moveCursorOver() {
        Actions action = new Actions(driver);
        action.moveToElement(Compare).build().perform();
    }

    public String getTooltTiptext() {
        Compare.click();
        return Compare.getAttribute("data-original-title");
    }

    public String getSuccessMsgProduct() {
       return SuccessMsgProductCompare.getText();
    }

    public void clickProductComparision() {
        lnkProductComparision.click();
    }

    public String getSearchResults() {
        return SearchResult.getText();
    }

    public String getSuccessMessage(){
        return SuccessMessage.getText();
    }


    public void ClickAddToCart() {
        AddToCart.click();
    }

    public void ClickShoppingCart() {
        ShoppingCart.click();
    }
}