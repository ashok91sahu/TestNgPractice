package utills;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CrossBroweser {
	public  WebDriver driver;
	public  Properties pro;

	@BeforeTest
	public Properties setup() throws Throwable, IOException {
		pro=new Properties();
		FileInputStream fi= new FileInputStream("C:\\Users\\Ak\\eclipse-workspace\\Testng_Pro\\Register.properties");
		pro.load(fi);
	    return pro;
	}	
	@Test
	public void launchBroweser(String brw) {
	driver.get(pro.getProperty(brw));
	if(brw.equalsIgnoreCase("chrome")) {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(pro.getProperty("url"));
		Reporter.log("Broweser Found::"+"chrome"+ true);
	}
	else if(brw.equalsIgnoreCase("firefox")) {
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		Reporter.log("Broweser Found::"+"chrome"+ true);
	}
	else if(brw.equalsIgnoreCase("ie")) {
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\msedgedriver.exe");
		driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(pro.getProperty("url"));
		Reporter.log("Broweser Found::"+"chrome"+ true);
	}
	else {
		Reporter.log("Broweser not Found::", true);
	}
}
	@AfterTest
	public void clouser() {
		driver.close();
	}
}
