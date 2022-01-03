package testpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import basepack.Baseclass;
import pompackage.Contactspage;
import pompackage.Homepage;
import pompackage.Loginpage;
import utilities.TestUtils;

public class Contactspagetest extends Baseclass
{
	Homepage homepagetest;
	Loginpage logintest;
	Contactspage contactspagetest;
	int Testid;
	
	@BeforeClass
	public void intialize()
	{
		driverintialization();
		logintest = new Loginpage();
		homepagetest = new Homepage();
		contactspagetest = new Contactspage();
	}
	
	@BeforeMethod
	public void login() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		homepagetest = logintest.loginfunctionality(prop.getProperty("email"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifytitle()
	{
		Testid=1;
		Assert.assertEquals(contactspagetest.Verifytitle(), "Cogmento CRM");
	}
	
	@Test(priority=2)
	public void verifyurl()
	{
		Testid=2;
		homepagetest.Contactspagelink();
		Assert.assertEquals(contactspagetest.Verifyurl(), "https://ui.cogmento.com/contacts");
		Assert.fail();
	}
	
	@Test(priority=3)
	public void verifytext() throws InterruptedException
	{
		Testid=3;
		Assert.assertTrue(contactspagetest.Contactslabel(), "Contacts");
	}
	
	@Test(priority=4)
	public void validatecreatecontact() throws Exception
	{
		Testid=4;
		homepagetest.Contactspagelink();
		contactspagetest.createcontactclick();
		contactspagetest.createcontact();
	}
	
	@AfterMethod
	public void screenshotwithlogout(ITestResult result) throws IOException
	{
		if (ITestResult.FAILURE == result.getStatus())
		{
			TestUtils.takescreenshot(driver, Testid);
		}
		logintest.logout();
		
	}
	
	
	@AfterClass
	public void close()
	{
		driver.close();
	}
}
