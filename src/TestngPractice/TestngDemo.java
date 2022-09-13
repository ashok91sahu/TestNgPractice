package TestngPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestngDemo {
	WebDriver driver;
	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver= new FirefoxDriver();
		
		driver.get("http://primusbank.qedgetech.com/");
		Thread.sleep(3000);
		}
	@Test
	public void cBanking() throws Throwable {
		driver.findElement(By.xpath("//input[@id='corporate']")).click();
		Reporter.log("successfully clicked on cbaning ", true);
		Thread.sleep(3000);	
		}
	@Test
	public void pBanking() throws Throwable {
		driver.findElement(By.xpath("//input[@id='personal']")).click();
		Reporter.log("successfully clicked on pbaning ", true);
		Thread.sleep(3000);
	}
		@Test
		public void tBanking() throws Throwable {
			driver.findElement(By.xpath("//input[@id='NRI']")).click();
			Reporter.log("successfully clicked on tbaning ", true);
			Thread.sleep(3000);
		}
		@AfterMethod
		public void tearDown() {
			driver.close();
		}
			
		}
