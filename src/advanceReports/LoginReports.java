package advanceReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginReports {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	Actions ac;
	@BeforeTest
	public void generateReports()
	{
		//define path to generate reports
		report = new ExtentReports("./Reports/Demo.html", true);
		
	}
	@BeforeMethod
	public void setUp()throws Throwable
	{

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		Thread.sleep(5000);
	}
	@Test
	public void loginPass() {
		test=report.startTest("loginPass");
		test.assignAuthor("Ashok");
		test.assignCategory("Functional Test");	
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		ac=new Actions(driver);
		ac.moveToElement(driver.findElement(By.xpath("//a[@class='_1_3w1N']"))).click().perform();
		driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("8618858689");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("8618858689");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();
		ac.moveToElement(driver.findElement(By.xpath("//div[@class='exehdJ'][normalize-space()='Ashok']"))).build().perform();
		ac.moveToElement(driver.findElement(By.xpath("//div[normalize-space()='My Profile']"))).click().perform();
		String expected="Ashok";
		String actual=driver.findElement(By.xpath("//div[@class='_1ruvv2']")).getText();
		if(actual.contains(actual)) {
			test.log(LogStatus.PASS, actual+"   "+expected);
			//Reporter.log(actual+"  "+expected,  true);
		}
			else
			{
				String error=driver.findElement(By.xpath("//span[contains(text(),'Please enter valid Email ID/Mobile number')]")).getText();
				test.log(LogStatus.ERROR, error);
				//Reporter.log(error, true);
			}	
	}
	@Test
	public void loginFail() {
		test=report.startTest("loginFail");
		test =report.startTest("funtional Test");
		test.assignAuthor("Ashok");
		test.assignCategory("Functional testing");
		String expectedtitle ="gmail";
		String actualtitle = driver.getTitle();
		if(expectedtitle.equalsIgnoreCase(actualtitle))
		{
			test.log(LogStatus.PASS, "Title is Matching::"+expectedtitle+"    "+actualtitle);
		}
		else
		{
			test.log(LogStatus.FAIL, "Title is Not Matching::"+expectedtitle+"    "+actualtitle);
		}
	}
	@AfterMethod
	public void tearDown()
	{
		report.endTest(test);
		report.flush();
		driver.close();
	}
}
