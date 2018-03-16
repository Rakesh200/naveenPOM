package com.CRM.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.Base;


public class Loginpage extends Base{
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='loginForm']/div/div/input")
	WebElement login;
	
	@FindBy(xpath="/html/body/div[2]/div/div[1]/a/img")
	WebElement Logoverify;
	

	@FindBy(xpath="/html/body/div[2]/div/a[2]/button")
	WebElement SignUp;
	
	//Create a class counsructor
	
	public Loginpage(){
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions on page
	public String ValidLoginPageTitle(){
		return driver.getTitle();
		
	}
	public boolean ValidatelogoCRM(){
		return Logoverify.isDisplayed();
	}
	
	
	public Homepage Login(String uname,String pwd) throws Exception{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		Thread.sleep(3000);
		login.click();
		
		return new Homepage();
		
	}
	
	
	
	

	

}
