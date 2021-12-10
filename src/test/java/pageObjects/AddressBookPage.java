package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressBookPage {
    WebDriver driver;

    public AddressBookPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//a[normalize-space()='New Address']")
    WebElement NewAddress;

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstName;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement lastName;

    @FindBy(xpath="//input[@id='input-address-1']")
    WebElement Address1;

    @FindBy(xpath="//input[@id='input-city']")
    WebElement City;

    @FindBy(xpath="//input[@id='input-postcode']")
    WebElement PostalCode;

    @FindBy(xpath = "//select[@id='input-country']")
    WebElement selectCountry;

    @FindBy(xpath="//select[@id='input-zone']")
    WebElement selectState;

    @FindBy(xpath="//input[@value='1']")
    WebElement selectAddress;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement Continue;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    WebElement SuccessMessage;

    public void setAddress(String firstname,String lastname,String address,String city,String postalCode,String country,String state) {
        NewAddress.click();
        firstName.sendKeys(firstname);
        lastName.sendKeys(lastname);
        Address1.sendKeys(address);
        City.sendKeys(city);
        PostalCode.sendKeys(postalCode);
        Select select = new Select(selectCountry);
        select.selectByVisibleText(country);
        Select stateSelect = new Select(selectState);
        stateSelect.selectByVisibleText(state);
        Continue.click();
    }


    public String setSuccessMessage() {
        String message = SuccessMessage.getText();
        return message;
    }

}
