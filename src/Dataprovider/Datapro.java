package Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datapro  {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
@Test(dataProvider="data")
public void login(String user, String pass) throws Throwable {
	driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(user);
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(pass);
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	Thread.sleep(3000); 
	String expected="dashboard";
	String actual=driver.getCurrentUrl();

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
public Object[][] data() {
	String login[][]=new String[5][2];
	login[0][0]="Admin";
	login[0][1]="Qedge123!@#";

	login[1][0]="Admin";
	login[1][1]="Qedge1223!@#";
	
	login[2][0]="Admin";
	login[2][1]="Qedge1243!@#";
	
	login[3][0]="Admin";
	login[3][1]="Qedge123!@#";
	
	login[4][0]="Admin";
	login[4][1]="Qedge1523!@#";
	
	return login;
}

@AfterTest
public void tearDown() {
	driver.close();
}

}
