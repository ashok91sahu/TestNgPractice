package PropertiesFiles;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenkartRegister {
	public WebDriver driver;
	public Properties pro;
	@BeforeTest
	public void setUp() throws Throwable {
		pro=new Properties();
		driver=new ChromeDriver();
		pro.load(new FileInputStream("C:\\Users\\Ak\\eclipse-workspace\\Testng_Pro\\Register.properties"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(pro.getProperty("Url"));
		Thread.sleep(3000);
		}
	@Test
	public void reg() throws Throwable {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		driver.findElement(By.xpath("//*[@class='d-none d-md-inline'][text()='My Account']")).click();
		driver.findElement(By.xpath("//*[text()='Register']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(pro.getProperty("Objfnam"))).sendKeys("mitsu");
		Thread.sleep(3000);
		driver.findElement(By.xpath(pro.getProperty("Objlname"))).sendKeys("mitsu");
		Thread.sleep(3000);
		driver.findElement(By.xpath(pro.getProperty("Objemail"))).sendKeys("asdsfafafa@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath(pro.getProperty("Objpass"))).sendKeys("Asok91sahu");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\"#input-newsletter-yes\").click()");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\"input[value='1'][name='agree']\").click()");
		//ac.moveToElement(driver.findElement(By.id("//input[@id='input-newsletter-yes']"))).click().perform();
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\"button[type='submit']\").click()");
		//ac.moveToElement(driver.findElement(By.xpath("//input[@name='agree']"))).click().perform();
		Thread.sleep(3000);
		//ac.moveToElement(driver.findElement(By.xpath("//button[normalize-space()='Continue']"))).click().perform();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
