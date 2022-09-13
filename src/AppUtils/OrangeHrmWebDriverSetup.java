package AppUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OrangeHrmWebDriverSetup {
	public static WebDriver driver;
	@BeforeTest
	public static void setUp() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ak\\eclipse-workspace\\Testng_Pro\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://orangehrm.qedgetech.com/");
		Thread.sleep(3000);	
		//driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
	//	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
		//driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
//Thread.sleep(3000);
	}
	@AfterTest
	public static void tearDown() throws Throwable {
		driver.close();
		Thread.sleep(3000);}

}
