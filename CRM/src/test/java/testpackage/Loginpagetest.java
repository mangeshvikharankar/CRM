package testpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import basepack.Baseclass;
import pompackage.Homepage;
import pompackage.Loginpage;

public class Loginpagetest extends Baseclass
{
	
	Loginpage logintest;
	Homepage homepage;
	public Loginpagetest()
	{
		super();
	}
	
	@BeforeMethod 
	public void intialize()
	{
		driverintialization();
		logintest = new Loginpage();
	}
	
	@Test(priority=1)
	public void Titlverification()
	{
		String title = logintest.verifyloginpage();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	 @Test(priority=2)
	 public void CRMlogoverification()
	 {
		 boolean logo = logintest.CRMlogo();
		 Assert.assertTrue(logo);
	 }
	 
	 @Test
	 public void logintestfunction() throws IOException
	 {
		 homepage =logintest.loginfunctionality(prop.getProperty("username"), prop.getProperty("password"));
	 }
	 
	  @AfterMethod 
	  public void close()
	  {
		  driver.close();
	  }
	  
	

}
