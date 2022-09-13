package ExtentReports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportOne {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	Actions ac;
	@BeforeTest
	public void extentsReport() {
		report=new ExtentReports("C:\\Users\\Ak\\eclipse-workspace\\Testng_Pro\\AdvanceReports\\FliploginReport.html", true);
		
	}
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");

	}
	@Test
	public void verifyLogin() throws Throwable {
	
			test=report.startTest("loginPass");
			test.assignAuthor("Ashok");
			test.assignCategory("Functional Test");	
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
			ac=new Actions(driver);
			ac.moveToElement(driver.findElement(By.xpath("//a[@class='_1_3w1N']"))).click().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8618858689");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Ashok91sahu");
			driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
			Thread.sleep(5000);
			ac.moveToElement(driver.findElement(By.xpath("//*[text()='Ashok']"))).build().perform();
			Thread.sleep(5000);
			ac.moveToElement(driver.findElement(By.xpath("//div[normalize-space()='My Profile']"))).click().perform();
			Thread.sleep(5000);
			ac.moveToElement(driver.findElement(By.xpath("//*[text()='Ashok']"))).build().perform();
			Thread.sleep(5000);
			ac.moveToElement(driver.findElement(By.xpath("//div[@class='_1ruvv2']"))).click().perform();
			Thread.sleep(5000);
			String act=driver.findElement(By.xpath("//div[@class='_1ruvv2']")).getText();
			Reporter.log(act, true);
			String expect="Ashok";
			if(act.equalsIgnoreCase(expect)) {
				test.log(LogStatus.PASS, "Login verification successfully"+act+"  "+expect);	
			}
				else
				{
					test.log(LogStatus.FAIL, "Login verification Failed"+act+"  "+expect);
					
				}
		}

		@Test
		public void verifyTitle() {
			test =report.startTest("validate title");
			test.assignAuthor("Ashok");
			test.assignCategory("Functional testing");
			String expected ="gmail";
			String actual = driver.getTitle();
			if(actual.contains(expected))
			{
				test.log(LogStatus.PASS, "Title is Matching::"+actual+"    "+expected);
			}
			else
			{
				test.log(LogStatus.FAIL, "Title is Not Matching::"+actual+"    "+expected);
			}
		}
		
		@AfterMethod
		public void endReport() {
			report.endTest(test);
			report.flush();
			driver.close();
		}
		
	}

	


