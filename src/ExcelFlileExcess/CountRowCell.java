package ExcelFlileExcess;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CountRowCell {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi= new FileInputStream("F:\\login.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("login");
		XSSFRow row=ws.getRow(0);
		int crow=ws.getLastRowNum();
		int ccell=row.getLastCellNum();
		System.out.println("total no of rows::"+ crow +"  "+ "total no of cells::"+ccell);
		fi.close();
		wb.close();
		

	}

}

