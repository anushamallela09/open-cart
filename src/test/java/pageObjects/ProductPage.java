package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Elements

    @FindBy(xpath = "//div[@id='content']/div/div/ul/li[1]/a/img[1]")
    WebElement ProductImage;

    @FindBy(xpath = "//button[@title='Next (Right arrow key)']")
    WebElement ProductRightArrow;

    @FindBy(xpath = "//button[@title='Close (Esc)']")
    WebElement ProductClose;

    @FindBy(xpath = "//input[@id='input-quantity']")
    WebElement InputQuantity;

    @FindBy(xpath = "//a[@href='#tab-review']")
    WebElement Reviews;

    @FindBy(xpath = "//input[@id='input-name']")
    WebElement Name;

    @FindBy(xpath = "//textarea[@id='input-review']")
    WebElement Textarea;

    @FindBy(xpath = "//input[@value='5']")
    WebElement Rating;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement Continue;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
        WebElement SuccessMsg;

    @FindBy(xpath = "//button[@data-original-title='Compare this Product']")
    WebElement CompareProduct;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement SuccessMsgProductCompare;

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement AddToCart;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement AddToCartSuccessmsg;

    @FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
    WebElement AddToWishList;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement AddToWishListSuccessMsg;

    @FindBy(xpath="//a[contains(text(),'wish list')]")
    WebElement WishList;

    @FindBy(xpath="//span[@id='cart-total']")
    WebElement cardTotal;

    @FindBy(xpath="//strong[contains(text(),'View Cart')]")
    WebElement viewCart;

    public void setViewCart () {
        cardTotal.click();
        System.out.println("click on Add to cart");
        viewCart.click();
        System.out.println("click on view cart");
    }

    public void setWishList() {
        WishList.click();
    }

    public String setAddToWishList() {
        AddToWishList.click();
        return AddToWishListSuccessMsg.getText();
    }

    public void setProductImage(){
        ProductImage.click();
        ProductRightArrow.click();
        ProductRightArrow.click();
        ProductClose.click();
    }

    public String getInputQuantity() {
        return InputQuantity.getAttribute("value");
    }

    public void setReviews(String textarea) {
        Reviews.click();
        //Name.sendKeys(name);
        Textarea.sendKeys(textarea);
        Rating.click();
        Continue.click();
    }

    public String setSuccessMsg() {

        return SuccessMsg.getText();
    }

    public void setCompareProduct() {
        CompareProduct.click();
    }

    public String getSuccessMessage()
    {
        return SuccessMsgProductCompare.getText();
    }

    public void setAddToCart() {
        AddToCart.click();
    }

    public String setAddToCartSuccessMsg() {

        return AddToCartSuccessmsg.getText();
    }
}
