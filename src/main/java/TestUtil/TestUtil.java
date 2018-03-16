package TestUtil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.Base;

public class TestUtil extends Base {
	
	public static long PAGE_LOAD_TIMEOUTS =20;
	public static long IMPLICIT_WAIT =20;
	
	
	public void Switchtoframe(){
		driver.switchTo().frame("mainpanel");
	}
	
	public static void takeScreenshotAtEndOfTest(){
		File srcfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		//String currentDir=System.getProperty("user.dir");
		
		try {
			FileUtils.copyFile(srcfile, new File(System.getProperty("user.dir")+"/src/main/java/Screenshots"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
