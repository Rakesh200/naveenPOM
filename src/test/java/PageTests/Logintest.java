package PageTests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.CRM.Pages.Homepage;
import com.CRM.Pages.Loginpage;

import Base.Base;

public class Logintest extends Base{
	
	Loginpage lp;
	Homepage homepage;
	
	public Logintest(){
		super();
	}
	
	@BeforeMethod
	public void Setup(){
		OpenBrowser();
		lp=new Loginpage();
		
	}
	
	
	@Test(priority=1)
	public void Titletest(){
		String title=lp.ValidLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
	}
	
	@Test(priority=2)
	public void verifyLogo(){
		boolean flag=lp.ValidatelogoCRM();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void Login(){
		try {
			homepage=lp.Login(OR.getProperty("uname"), OR.getProperty("pwd"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@AfterMethod
	public void Quite(){
		driver.quit();
		
		
	}
	

}
