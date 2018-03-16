package Base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import TestUtil.TestUtil;
import TestUtil.WebEventListener;

public class Base {
	
	public static WebDriver driver;
	public static Properties OR;
	public static EventFiringWebDriver edriver;
	public static WebEventListener eventlistener;
	
	
	
	public Base(){
		
		try {
		OR=new Properties();
		
		//C:\\Users\\RAKESH\\Desktop\\Testing\\naveen.autolabs.CRM\\src\\main\\java\\properties\\OR.properties
			FileInputStream in=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/properties/OR.properties");
			OR.load(in);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	 
	}
	
	public static void OpenBrowser(){
	String browsername=	OR.getProperty("browser");
			if(browsername.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\RAKESH\\Desktop\\New folder\\Testing\\jars\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
				
				edriver=new EventFiringWebDriver(driver);
				eventlistener=new WebEventListener();
				edriver.register(eventlistener);
				driver=edriver;
				
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				
				driver.get(OR.getProperty("url"));
			}
			}
			
		}
		


