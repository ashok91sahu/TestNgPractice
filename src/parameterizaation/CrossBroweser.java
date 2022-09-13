package parameterizaation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBroweser {
	WebDriver driver;
	@Parameters({"Browser"})
	@BeforeTest
	public void setUp(String brw) {
		switch (brw) {
		case "chrome":
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			break;
		default:
			Reporter.log("Browser Value is Not Matching",true);
			break;
		}
		
	}
	@Test(dataProvider = "supplyData")
	public void verifyLogin(String username,String password) throws Throwable {
		driver.get("http://orangehrm.qedgetech.com/");
		driver.findElement(By.name("txtUsername")).sendKeys(username);
		driver.findElement(By.name("txtPassword")).sendKeys(password);
		driver.findElement(By.name("Submit")).click();
		Thread.sleep(3000);
		String expected ="dashboard";
		String actual = driver.getCurrentUrl();
		if(actual.contains(expected))
		{
			Reporter.log("Login Success::"+expected+"      "+actual,true);
		}
		else
		{
			Reporter.log("Login Fail::"+expected+"      "+actual,true);
		}
	}
	@DataProvider
	public Object[][] supplyData() {
		String login[][]= new String[5][2];
		login[0][0]="Admin";
		login[0][1]="Qedge123!@#";
		login[1][0]="Admin";
		login[1][1]="Qedge12";
		login[2][0]="Admin";
		login[2][1]="Qedge123!@#";
		login[3][0]="Admin";
		login[3][1]="Qedge123";
		login[4][0]="Admin";
		login[4][1]="Qedge123!@#";
		return login;
		}
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
		
	}
