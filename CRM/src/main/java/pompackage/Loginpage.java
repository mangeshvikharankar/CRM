package pompackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepack.Baseclass;
import utilities.PomUtils;

public class Loginpage extends Baseclass
{
	@FindBy (xpath="//input[@placeholder='E-mail address']")
	private WebElement email;
	
	@FindBy (xpath="//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy (xpath="//div[@class='ui fluid large blue submit button']")
	private WebElement loginbutton;
	
	@FindBy (xpath="//div[@role='listbox']")
	private WebElement logoutdropdown;
	
	@FindBy (xpath="//span[normalize-space()='Log Out']")
	private WebElement logoutbuton;
	
	@FindBy (xpath="//a[normalize-space()='Sign Up']")
	private WebElement signup;
	
	public Loginpage()
	{	
		PageFactory.initElements(driver, this);
	}
	
	public String verifyloginpagetitle()
	{
		return driver.getTitle();
	}
	
	public Homepage loginfunctionality(String user, String pass) throws IOException
	{
		email.sendKeys(user);
		password.sendKeys(pass);
		loginbutton.click();
		return new Homepage();
	}
	
	public void logout()
	{
		logoutdropdown.click();
		logoutbuton.click();
	}
}
