package PageTests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.Pages.ContactsPage;
import com.CRM.Pages.Homepage;
import com.CRM.Pages.Loginpage;

import Base.Base;

public class Homepagetest extends Base {
	Homepage homepage;
	Loginpage lp;
	ContactsPage contactspage;
	
	public Homepagetest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		OpenBrowser();
		try {
		lp=new Loginpage();
		
		homepage =	lp.Login(OR.getProperty("uname"),OR.getProperty("pwd"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=1)
	public void verifyTitle(){
		
		String homepagetitle=homepage.VerifyPageTitle();
		Assert.assertEquals(homepagetitle, "CRMPRO","Title not found in the page");
	}
	
	
	@Test(priority=2)
	public void VerifyUser(){
		
		boolean values=homepage.verifyUsername();
		Assert.assertTrue(values);
	}
	
	@Test(priority=3)
	public void ClickOnContacts(){
		contactspage=homepage.CilckOnContactsMenu();
		
	}
		
	

	
	
@AfterMethod
public void Quit(){
	driver.quit();
	
}
}
