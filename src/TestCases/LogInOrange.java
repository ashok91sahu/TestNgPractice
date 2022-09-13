package TestCases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import AppUtils.OrangeHrmWebDriverSetup;

public class LogInOrange extends OrangeHrmWebDriverSetup {

	@Test(priority=1)
	public void login() throws Throwable {
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		Thread.sleep(3000);
		driver.findElement(By.name("txtPassword")).sendKeys("Qedge123!@#");
		Thread.sleep(3000);
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(3000);
	}
	@Test(priority=3, enabled=false)
	public void mVerification() throws Throwable {

		String expected="dashboard";
		String actual=driver.getCurrentUrl();
		if(expected.contains(actual)) {
			Reporter.log("Log in successs::"+actual+"  "+expected ,true);
		}else
		{
			String error=driver.findElement(By.xpath("spanMessage")).getText();
			Reporter.log("Log in failure::"+actual+"  "+expected+error ,true);
		}
	}
	@Test(priority=2)
	public void verify() throws Throwable {
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='searchSystemUser_userName']")).sendKeys("Ashok");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//b[normalize-space()='PIM']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='empsearch_employee_name_empName']")).sendKeys("Ashok");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//b[normalize-space()='Leave']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//li[1]//img[1]")).click();
		Thread.sleep(3000);
			}
	
}
