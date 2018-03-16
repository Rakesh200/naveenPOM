package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;

public class ContactsPage extends Base{
	
	
	@FindBy(xpath="//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement VerifyContactname;
	
	@FindBy(xpath="//select[@name='title'and @class='select']")
	WebElement Title;
	
	@FindBy(id="first_name")
	WebElement Firstname;
	
	@FindBy(id="surname")
	WebElement Lastname;
	
	@FindBy(name="client_lookup")
	WebElement Company;
	
	@FindBy(id="mobile")
	WebElement Mobile;
	
	@FindBy(xpath="//input[@class='button']")
	WebElement Savebutton;
	
	
     public ContactsPage(){
    	 PageFactory.initElements(driver, this);
    	 
     }
     
     
     public boolean verifycontact(){
    	return  VerifyContactname.isDisplayed();
     }
     
     public void Enterdetails(String title,String firestname,String lastname,String company,String mobile){
    	 
    	 	Title.sendKeys(title);
    	 	Firstname.sendKeys(firestname);
    	 	Lastname.sendKeys(lastname);
    	 	Company.sendKeys(company);
    	 	Mobile.sendKeys(mobile);
    	 	Savebutton.click();
     }
     
     
     
     
     
     
     
     
}
