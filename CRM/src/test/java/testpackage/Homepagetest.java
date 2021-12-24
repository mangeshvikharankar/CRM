package testpackage;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepack.Baseclass;
import pompackage.Contactspage;
import pompackage.Homepage;
import pompackage.Loginpage;

public class Homepagetest extends Baseclass
{
	Homepage homepagetest;
	Loginpage logintest;
	Contactspage contactspagetest;
	
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
	
	@ Test(priority=1)
	public void verifylogo() throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertTrue(homepagetest.Verfiylogo(), "logo is verified");
	}
	
	@ Test(priority=2)
	public void verifytitle() throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertEquals(homepagetest.Verifyhomepagetitle(), "Cogmento CRM", "Homepage title is not matched");
	}

	@ Test(priority=4)
	public void verifyusername() throws InterruptedException
	{
		Thread.sleep(3000);
		Assert.assertTrue(homepagetest.Verifyusername(), "username is verified");
	}
	
	@ Test(priority=5)
	public void verifycontatcslinktab() throws InterruptedException
	{
		Thread.sleep(3000);
		contactspagetest=homepagetest.Contactspagelink();
	}
	
	@AfterMethod
	public void logout()
	{
		logintest.logout();
	}
	
	@AfterClass
	public void close()
	{
		driver.close();
	}

}
