package TestCases;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import AppUtils.Calculator;

public class CalculatorOpearation extends Calculator {
	 @Test(priority=1, enabled=true, description = "validate addition" )
	public void addition() throws Throwable {
		 
		driver.findElement(By.xpath("//input[@name='display']")).sendKeys("789");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='+']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='display']")).sendKeys("987");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='=']")).click();
		Thread.sleep(3000);
		String result=driver.findElement(By.xpath("//input[@name='display']")).getAttribute("value");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='C']")).click();
		Reporter.log(result,true);
		Thread.sleep(3000);
	}
	 @Test(priority=3,enabled=false, description = "validate multiplication")
	public void multiplication() throws Throwable {
		driver.findElement(By.xpath("//input[@name='display']")).sendKeys("789");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='x']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='display']")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='=']")).click();
		Thread.sleep(3000);
		String result=driver.findElement(By.xpath("//input[@name='display']")).getAttribute("value");
		Reporter.log(result,true);
		driver.findElement(By.xpath("//input[@value='C']")).click();
	}
	@Test(priority=2, enabled=true, description = "validate division")
	public void division() throws Throwable {
		driver.findElement(By.xpath("//input[@name='display']")).sendKeys("789");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='/']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='display']")).sendKeys("987");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='=']")).click();
		Thread.sleep(3000);
		String result=driver.findElement(By.xpath("//input[@name='display']")).getAttribute("value");
		Reporter.log(result,true);
		driver.findElement(By.xpath("//input[@value='C']")).click();
	}
}
