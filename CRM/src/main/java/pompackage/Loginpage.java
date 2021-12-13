package pompackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepack.Baseclass;
import utilities.Utility;

public class Loginpage extends Baseclass
{
	
	@FindBy (xpath="//input[@name=\'username\']")
	private WebElement username;
	
	@FindBy (xpath="//input[@name=\'password\']")
	private WebElement password;
	
	@FindBy (xpath="//input[@class='btn btn-small']")
	private WebElement loginbutton;
	
	@FindBy (xpath="//a[text()='Sign Up']")
	private WebElement signup;
	
	@FindBy (xpath="(//img[@class='img-responsive'])[1]")
	private WebElement logo;
	
	public Loginpage()
	{
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyloginpage()
	{
		return driver.getTitle();
	}
	
	public boolean CRMlogo()
	{
		return logo.isDisplayed();
	}
	
	public Homepage loginfunctionality(String user, String pass) throws IOException
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		loginbutton.click();
		return new Homepage();
	}

	
}
