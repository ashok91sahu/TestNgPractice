package FionaDiamonds;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class RegisterFiona {
	static WebDriver driver;
	@Test
	public void LaunchChrome() throws Throwable {
	//LAunching Broweser
	driver=new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.get("https://www.fionadiamonds.com/");
	}
	@Test
	public void UserVerify() throws Throwable {
	driver.findElement(By.xpath("//div[@class='header-icons cart-link']//a[@title='Log in']")).click();
	driver.findElement(By.xpath("//a[@class='btn']")).click();
	driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Prakas");
	driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Behera");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("prakas@gmail.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Prabin@1993");
	driver.findElement(By.xpath("//input[@class='btn']")).click();
	Thread.sleep(3000);

	//fiona title verification
	String expected="Fiona Diamonds ";
	String actual=driver.getTitle();
	if(expected.contains(actual))
	{
		Reporter.log("title not verfied::"+ expected+"   "+ actual);
	}
	else
	{
		Reporter.log("Tite  matched::"+ expected+"   "+ actual);
	}

	//Fiona user verifcation
	String user=driver.findElement(By.xpath("//p[@class='type-subheading type-subheading--1 mb-2']")).getText();
	if(user.contains("prakas behera"))
	{
		Reporter.log("user  not Verified::"+ user);
	}
	else
	{
		Reporter.log("user  verified::"+ user);
	}
	}
	@Test
	public void CountryVerify() throws Throwable {
	
	//Fiona Addresss Update and country verifiacation
	
	driver.findElement(By.xpath("//a[@id='view_address']")).click();
	driver.findElement(By.xpath("//button[normalize-space()='Edit']")).click();
	Thread.sleep(3000);
	Select cont=new Select(driver.findElement(By.xpath("//select[@id='address_country_7473231626403']")));
	cont.selectByVisibleText("United States");
	WebElement e = driver.findElement(By.cssSelector("#address_province_7473231626403"));
	Select s = new Select(e);
	s.selectByVisibleText("Arizona");
	driver.findElement(By.xpath("//input[@id='address_default_address_7473231626403']")).click();
	driver.findElement(By.xpath("//input[@id='update_address_btn']")).click();
	Thread.sleep(3000);
	String ex="united States";
	String ac=driver.findElement(By.cssSelector("div[class='view_address'] p")).getText();
	 if(ex.equalsIgnoreCase(ac))
	    {
		 Reporter.log("Country is   matching::"+ ex);
	    }
	    else
	    {
	    	Reporter.log("Country is not  matching::"+ ex);
	    }
	
	 //Adding Rings to the cart
	}
	@Test
	public void AddingToCart() throws Throwable { 
	 WebDriverWait wait= new WebDriverWait(driver, 30);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[name()='svg'][@class='feather feather-chevron-down'])[31]")));
	 
Actions at= new Actions(driver);
at.moveToElement(driver.findElement(By.xpath("(//div[@class='mega-menu--dropdown-wrapper open']//span[text()='Rings']"))).perform();
Thread.sleep(5000);
at.moveToElement(driver.findElement(By.xpath("//a[@aria-expanded='true'][normalize-space()='Women']"))).perform();
Thread.sleep(2000);
at.moveToElement(driver.findElement(By.xpath("//a[@aria-expanded='false'][normalize-space()='Wedding Rings']"))).click().perform();
at.moveToElement(driver.findElement(By.xpath("//span[normalize-space()='Ariel Diamond Ring']"))).click().perform();
Thread.sleep(2000);
at.moveToElement(driver.findElement(By.cssSelector("#template--15902615634083__main-swatch-0-White"))).click().perform();
Thread.sleep(2000);
at.moveToElement(driver.findElement(By.cssSelector("//input[@id='template--15902615634083__main-swatch-1-14 KT']"))).click().perform();
Thread.sleep(2000);
Select ring= new Select(driver.findElement(By.xpath("(//select[@id='Ring Size-0-0'])[1]")));
ring.deselectByIndex(15);
driver.findElement(By.xpath("//button[@id='purchase']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='header-icons cart-link']//button[@title='Cart']//*[name()='svg']//*[name()='path' and contains(@d,'M6 2L3 6v1')]")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//button[normalize-space()='+']")).click();
driver.findElement(By.xpath("//button[normalize-space()='-']")).click();
driver.findElement(By.xpath("//button[normalize-space()='-']")).click();
}
	
	@AfterTest
	public void Clouser() {
	driver.close();
	}
}

