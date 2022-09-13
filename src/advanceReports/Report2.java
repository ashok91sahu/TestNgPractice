package advanceReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report2 {

	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	@BeforeTest
	public void generateReports()
	{
		//define path to generate reports
		report = new ExtentReports("./AdvanceReports/Demo.html");
		
	}
	@BeforeMethod
	public void setUp()throws Throwable
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Thread.sleep(5000);
	}
	@Test
	public void passTest()
	{
		//test case starts here
		test =report.startTest("Validate Title");
		test.assignAuthor("Ranga");
		test.assignCategory("Functional testing");
		String expectedtitle ="Google";
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
	@Test
	public void failTest()
	{
		//test case starts here
			test =report.startTest("Validate Title");
			test.assignAuthor("Ranga");
			test.assignCategory("Functional testing");
			String expectedtitle ="Gamil";
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

