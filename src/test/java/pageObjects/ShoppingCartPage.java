package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingCartPage {

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div [@class='table-responsive']//tbody//tr//td[2]")
    WebElement ShoppingCartProduct;

    @FindBy(xpath = "//div[@id='content']/div[1]/div[2]/div/h4/a/i")
    WebElement Shipping;

    @FindBy(xpath = "//select[@name='country_id']")
    WebElement Country;

    @FindBy(xpath = "//select[@id='input-zone']")
    WebElement State;

    @FindBy(xpath = "//input[@id='input-postcode']")
    WebElement PostCode;

    @FindBy(xpath = "//button[@id='button-quote']")
    WebElement GetQuotes;

    @FindBy(xpath = "//input[@name='shipping_method']")
    WebElement FlatShipping;

    @FindBy(xpath = "//input[@id='button-shipping']")
    WebElement ApplyShipping;

    @FindBy(xpath = "//div[@class='buttons clearfix']//div[2]/a")
    WebElement Checkout;

   // @FindBy(xpath = "//div[@id='content']//form//tbody//tr[3]//td[4]//span//button[2]")

    public boolean clickRemoveProduct(String expectedProductName) throws InterruptedException {
        boolean productRemove = false;
        int rowcount = driver.findElements(By.xpath("//div[@id='content']//form/div/table/tbody/tr")).size();
        for (int i = 1; i <= rowcount; i++) {
            String actualProductName = driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[2]/a")).getText();
            if (expectedProductName.equals(actualProductName)) {
                Thread.sleep(5000);
                driver.findElement(By.xpath("//div[@id='content']//form//tbody//tr[" + i + "]//td[4]//span//button[2]")).click();
                productRemove = verifyRemoveProduct(expectedProductName);
            }

        }
        return productRemove;
    }

    public boolean verifyRemoveProduct(String expectedProductName) {
        boolean remove = true;
        int rowcount = driver.findElements(By.xpath("//div[@id='content']//form/div/table/tbody/tr")).size();
        for (int i = 1; i <= rowcount; i++) {
            String actualProductName = driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[2]/a")).getText();
            if (expectedProductName.equals(actualProductName)) {
                remove = false;
            }

        }
        return remove;
    }



    public void shippingEstimations(String countryName, String state, String postCode) {
        Shipping.click();
        Select drpCountry = new Select(Country);
        drpCountry.selectByVisibleText(countryName);
        Select drpState = new Select(State);
        drpState.selectByVisibleText(state);
        PostCode.sendKeys(postCode);
        GetQuotes.click();
    }

    public void setApplyShipping() {
        FlatShipping.click();
        ApplyShipping.click();
    }

    public void setCheckout() {
        Checkout.click();
    }


    public void verifyProductPresentInTable(String expectedProductName) {

        int rowcount = driver.findElements(By.xpath("//div[@id='content']//form/div/table/tbody/tr")).size();
        for (int i = 1; i <= rowcount; i++) {
            String actualProductName = driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[2]/a")).getText();
            if (expectedProductName.equals(actualProductName)) {
                driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[4]/div/input")).clear();
                driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[4]/div/input")).sendKeys("5");
                driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[4]/div/span/button[1]")).click();
                System.out.println("enter quantity 5");
                String Quantity = driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[4]/div/input")).getAttribute("value");
                int QuantityValue = Integer.parseInt(Quantity);
                String UnitPrice = driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[5]")).getText();
                UnitPrice = UnitPrice.replace("$", "");
                UnitPrice = UnitPrice.replace(",", "");
                UnitPrice = UnitPrice.replace(".00", "");
                int UnitPriceValue = Integer.parseInt(UnitPrice);
                int expectedTotal = UnitPriceValue * QuantityValue;
                String Total = driver.findElement(By.xpath("//div[@id='content']//form/div/table/tbody/tr[" + i + "]/td[6]")).getText();
                Total = Total.replace("$", "");
                Total = Total.replace(",", "");
                Total = Total.replace(".00", "");
                int actualTotal = Integer.parseInt(Total);
                if (expectedTotal == actualTotal) {
                    System.out.println("TestPass");
                } else {
                    System.out.println("Test Fail");
                }
            }
        }
    }


    public String shoppingCartProduct() {
        return ShoppingCartProduct.getText();
    }
}
