package pompackage;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import basepack.Baseclass;
import utilities.PomUtils;

public class Contactspage extends Baseclass
{
	@FindBy (xpath="//div[text()='Contacts']")
	private WebElement contactstext;
	
	@FindBy (xpath="//span[text()='Contacts']")
	private WebElement contactpageclick;
	
	@FindBy (xpath="//button[normalize-space()='Create']")
	private WebElement createcontact;
	
	@FindBy (xpath="//input[@name='first_name']")
	private WebElement firstname;
	
	@FindBy (xpath="//input[@name='last_name']")
	private WebElement lastname;
	
	@FindBy (xpath="//button[normalize-space()='Save']")
	private WebElement savecontact;
	
	public Contactspage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String Verifytitle()
	{
		return driver.getTitle();
	}
	
	public String Verifyurl()
	{
		return driver.getCurrentUrl();
	}
	
	public boolean Contactslabel()
	{
		return contactstext.isDisplayed();
	}
	
	public void createcontactclick()
	{
		createcontact.click();
	}
	
	public void createcontact() throws IOException, InterruptedException
	{
		System.out.println(PomUtils.sheetLength());
		for (int i = 0; i < PomUtils.sheetLength(); i++) 
		{
			String fname = PomUtils.logindata1(i+1, 0); 
			String lname = PomUtils.logindata1(i+1, 1); 
			System.out.println(fname);
			firstname.sendKeys(fname);
			lastname.sendKeys(lname);
			savecontact.click();
			Thread.sleep(3000);
			contactpageclick.click();
			createcontact.click();
		}
	}
}
