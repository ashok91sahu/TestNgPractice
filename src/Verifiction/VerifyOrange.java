package Verifiction;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import AppUtils.OrangeHrmWebDriverSetup;

public class VerifyOrange extends OrangeHrmWebDriverSetup {
	@Test
	public void mVerification() throws Throwable  {
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
Thread.sleep(3000);
		String expected="dashboard";
		String actual=driver.getCurrentUrl();
		if(actual.contains(expected)) {
			Reporter.log("Log in successs::"+actual+"  "+expected ,true);
		}else
		{
			String error=driver.findElement(By.xpath("spanMessage")).getText();
			Reporter.log("Log in failure::"+actual+"  "+expected+error ,true);
		}
	}
}