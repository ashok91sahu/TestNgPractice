package AppUtils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Calculator {
	public static WebDriver driver;
	@BeforeSuite
	public void broweserSetup() throws Throwable {
		driver=(WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://calc.qedgetech.com/");
		Thread.sleep(3000);
	}
		@AfterSuite
		public  void tearDown() {
			driver.close();
			
		}
		
		
		
		
	}


