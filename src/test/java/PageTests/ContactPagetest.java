package PageTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.CRM.Pages.ContactsPage;
import com.CRM.Pages.Homepage;
import com.CRM.Pages.Loginpage;

import Base.Base;
import ExcellReader.excellreader;

public class ContactPagetest extends Base {
	
public static String Filepath=System.getProperty("user.dir")+"/src/main/java/ExcellSheet/CRM.xlsx";
	public static String filename="contacts";
	
	Loginpage lp;
	Homepage homepage;
	ContactsPage contactspage;
	
	public ContactPagetest(){
		super();
	}

	
	@BeforeMethod
	public void Setup(){
		 try {
		OpenBrowser();
		
		lp=new Loginpage();
         homepage=new Homepage();
         contactspage=new ContactsPage();
			lp.Login(OR.getProperty("uname"), OR.getProperty("pwd"));
			homepage.CilckOnContactsMenu();
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
		
	}
	
	
	@Test(priority=1)
	public void verifyContact(){
		boolean verify=contactspage.verifycontact();
		
		Assert.assertTrue(verify);
		
	}
	
	@DataProvider
	
	public Object[][] getCRMdata() throws Exception{
		Object[][] data=excellreader.getExceldata(Filepath, filename);
		return data;
	}
	@Test(priority=2,dataProvider="getCRMdata")
		public void validateCreatnewContact(String title,String firestname,String lastname,String company,String mobile){
			homepage.ClickOnNewContact();
			//contactspage.Enterdetails("Mr", "k", "g", "company", "12345");
			contactspage.Enterdetails(title, firestname, lastname, company, mobile);
			
		
	}
	
	@AfterMethod
	public void Quit(){
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
