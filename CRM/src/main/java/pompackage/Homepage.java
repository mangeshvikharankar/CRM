package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepack.Baseclass;

public class Homepage extends Baseclass
{
	@FindBy (xpath="//span[text()='Calendar']")
	private WebElement Calenderpage;
	
	@FindBy (xpath="//span[text()='Contacts']")
	private WebElement Contactspage;

	@FindBy (xpath="//div[@class='header item']")
	private WebElement logo;
	
	@FindBy (xpath="//span[@class='user-display']")
	private WebElement username;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean Verfiylogo()
	{
		return logo.isDisplayed();
	}
	
	public String Verifyhomepagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean Verifyusername()
	{
		return username.isDisplayed();
	}
	
	public Contactspage Contactspagelink()
	{
		Contactspage.click();
		return new Contactspage();
	}
}
