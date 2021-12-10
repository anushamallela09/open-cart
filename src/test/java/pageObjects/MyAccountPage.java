package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement SuccessMessage;

	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;

	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	WebElement lnkEditInfo;

	@FindBy (xpath="//div[@id='logo']//a")
	WebElement lnkLogo;

	public void clickLogo() {
		lnkLogo.click();
	}

	public void clickEditInfo() {
		lnkEditInfo.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}

	public String verifySuccessMessage() {
	String Message = SuccessMessage.getText();
		return Message;
	}
		
}
