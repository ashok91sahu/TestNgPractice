package ExcelFlileExcess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MultipleTestCaseAccessFromExcel {
	XSSFWorkbook wb;
	WebDriver driver;
	@BeforeTest
	public void setUp() throws Throwable {

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void verfyTestCase() throws Throwable {
		FileInputStream fi=new FileInputStream("F:/Login.xlsx");
		wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("Login3");		
		int rowcount=ws.getLastRowNum();
		System.out.println("No of rows::"+"    "+ rowcount );
		for (int i=1; i<=rowcount; i++)
		{
			driver.get("https://www.calculator.net/percent-calculator.html");
			Thread.sleep(3000);
			if(wb.getSheet("Login3").getRow(i).getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				int celldata1 =(int)wb.getSheet("Login3").getRow(i).getCell(0).getNumericCellValue();
				String percentage =String.valueOf(celldata1);
				if(wb.getSheet("Login3").getRow(i).getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					int celldata2 =(int) wb.getSheet("Login3").getRow(i).getCell(1).getNumericCellValue();
					String Amount =String.valueOf(celldata2);
					driver.findElement(By.name("cpar1")).sendKeys(percentage);
					driver.findElement(By.name("cpar2")).sendKeys(Amount);
					driver.findElement(By.xpath("(//input[@value='Calculate'])[1]")).click();
					Thread.sleep(3000);
					String result = driver.findElement(By.xpath("//p[@class='verybigtext']")).getText();
					ws.getRow(i).createCell(2).setCellValue(result);
					ws.getRow(i).createCell(3).setCellValue("pass");
					XSSFCellStyle style=wb.createCellStyle();
					XSSFFont font=wb.createFont();
					font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());
					font.setBold(true);
					font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
					style.setFont(font);
					ws.getRow(i).getCell(3).setCellStyle(style);
				
				}
			}
		}
		fi.close();
		FileOutputStream fo= new FileOutputStream("F:\\resuts.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

	@AfterTest
	public void tearDown() {
		driver.close();


	}
}



