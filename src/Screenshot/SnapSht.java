package Screenshot;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class SnapSht {

	public static void main(String[] args) throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		 Date date=new Date();
		 DateFormat df=new SimpleDateFormat("dd/mm/yyyy hh-mm-ss");
		 String datef=df.format(date);
		 
		
		
		String ex="gmail";
	String ac=driver.getCurrentUrl();
	if (ac.contains(ex)) {
		Reporter.log(ac+ex, true );
	}
		else {
			File sc= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sc, new File("C:\\Users\\Ak\\eclipse-workspace\\Testng_Pro\\Screenshots\\"+datef+"login.png"));
			Reporter.log("mismatch title"+"   "+ac+ex, true);
		
				
			}
		
	driver.close();
	}

}
