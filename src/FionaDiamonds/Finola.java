package FionaDiamonds;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Finola {
	@Test
	public void fin() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.fionadiamonds.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='header-icons cart-link']//a[@title='Log in']//*[name()='svg']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Create Account']")).click();
		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Rohan");
		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Kale");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kalerohan343@yahoo.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123rohan");
		driver.findElement(By.xpath("//input[@value='Create']")).click();
		String expected = "fionadiamonds";
		String actual = driver.getTitle();
		if(expected.equalsIgnoreCase(actual))
		{
			System.out.println("Title is matching::" +expected+"  "+actual);
		}
		else
		{
			System.out.println("Title is not matching::" +expected+" "+actual);
		}
		driver.findElement(By.xpath("//div[@class='header-icons cart-link']//a[@title='Log in']")).click();
		driver.findElement(By.xpath("//input[@id='customer_email']")).sendKeys("skalerohan343@yahoo.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='customer_password']")).sendKeys("123rohan");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"Sign In\"]")).click();
		driver.findElement(By.xpath("//div[@class='header-icons cart-link']//a[@title='My Account']//*[name()='svg']")).click();
		String expectedname = "Vishal Biradar";
		String actualname = driver.findElement(By.xpath("(//p[@class='type-subheading type-subheading--1 mb-2'])[1]")).getText();
		if(expectedname.equalsIgnoreCase(actualname))
		{
			System.out.println("Username is matching::"+expectedname+"  "+actualname);
		}
		else
		{
			System.out.println("Username is not matching::"+expectedname+"  "+actualname);
		}
        String expectedcountry = "India";
        String actualcountry = driver.findElement(By.xpath("//p[normalize-space()=', India']")).getText();
        if(expectedcountry.equalsIgnoreCase(actualcountry))
        {
        	System.out.println("Country is matching::"+expectedcountry+"  "+actualcountry);
        }
        else
        {
        	System.out.println("Country is not matching::"+expectedcountry+"  "+actualcountry);
        }
        Select element = new Select(driver.findElement(By.xpath("//a[@class='dropdown-envy-toggle alt-focus header-link'])[25]")));
        java.util.List <WebElement> rings = element.getOptions();
        Actions ac = new Actions(driver);
        element.selectByVisibleText("Women");
        element.selectByVisibleText("Wedding Rings");
        driver.findElement(By.xpath("//span[normalize-space()='Ariel Diamond Ring']")).click();
        driver.findElement(By.xpath("(//input[@id='template--15902615634083__main-swatch-0-White'])[1]")).click();
        driver.findElement(By.xpath("(//input[@id='template--15902615634083__main-swatch-1-18 KT'])[1]")).click();
        Select ringsize = new Select(driver.findElement(By.xpath("(//select[@id='Ring Size-0-0'])[1]")));
        ringsize.selectByIndex(9);
        driver.findElement(By.xpath("//div[@class='sp-validate-overlay']"));
        driver.findElement(By.xpath("//button[normalize-space()='+']"));
        driver.findElement(By.xpath("//button[normalize-space()='-']"));
        driver.findElement(By.xpath("//button[normalize-space()='-']"));
        driver.close();
        
        
        
	}
	}


