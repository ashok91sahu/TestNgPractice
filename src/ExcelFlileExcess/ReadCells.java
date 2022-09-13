package ExcelFlileExcess;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCells {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi= new FileInputStream("F:\\login.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("login");
		int crow=ws.getLastRowNum();
		System.out.println("total no of rows::"+ crow );
		String user=ws.getRow(0).getCell(0).getStringCellValue();
		String pass=ws.getRow(0).getCell(1).getStringCellValue();
		System.out.println(user+"   "+pass);
		
		fi.close();
		wb.close();
		

	}

}
