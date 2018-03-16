package com.CRM.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;
import TestUtil.TestUtil;

public class Homepage extends Base{
	TestUtil testutil;
	ContactsPage contactspage;
	DealsPage dealspage;
	
	
	@FindBy(xpath="//td[contains(text(),'User: karthik k ')]")
	WebElement Verifyusername;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/a")
	WebElement ClickOnContacts; 
	

	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement ClickOnNewContacts; 
	
	
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[5]/a")
	WebElement ClickOnDeals; 
	
	
	public Homepage(){
		PageFactory.initElements(driver, this);
		testutil=new TestUtil();
		
	}
	
	public String VerifyPageTitle(){
		return driver.getTitle();
		
	}
	
	public boolean verifyUsername(){
		testutil.Switchtoframe();
		return Verifyusername.isDisplayed();
		
	}
	
	public ContactsPage CilckOnContactsMenu(){
		testutil.Switchtoframe();
		ClickOnContacts.click();
		return new ContactsPage();
	}
	
	public DealsPage CilckOnDealsMenu(){
		ClickOnDeals.click();
		return new DealsPage();
	}
	
	public ContactsPage ClickOnNewContact(){
		//testutil.Switchtoframe();
		Actions action=new Actions(driver);
		action.moveToElement(ClickOnContacts).build().perform();
		ClickOnNewContacts.click();
		return new ContactsPage();
        		
		
		
		
		
		
		
		
		
	}

}
