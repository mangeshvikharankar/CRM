package testpackage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basepack.Baseclass;
import pompackage.Homepage;
import pompackage.Loginpage;

public class Loginpagetest extends Baseclass
{
	Loginpage logintest;
	Homepage homepage;
	
//	public Loginpagetest()
//	{
//		super();
//	}
	
	 @BeforeClass
	 public void intialize()
	 {
		 driverintialization();
	 }
	 
	@BeforeMethod 
	public void CreatePomobject()
	{
		logintest = new Loginpage();
		String title = logintest.verifyloginpagetitle();
		Assert.assertEquals(title, "Cogmento CRM");
	}
	 
	@Test 
	public void logintestfunctionaility() throws IOException
	{
		homepage = logintest.loginfunctionality(prop.getProperty("email"), prop.getProperty("password"));
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
