package ExcelFlileExcess;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AcessMutiDatafromCells {
		public static void main(String[] args) throws Throwable {
			FileInputStream fi= new FileInputStream("F:\\Login.xlsx");
			XSSFWorkbook wb= new XSSFWorkbook(fi);
			XSSFSheet ws= wb.getSheet("Login2");
		int row=ws.getLastRowNum();
		for(int i=1; i<=row; i++)
		{
			String user=ws.getRow(i).getCell(0).getStringCellValue();
			String pass=ws.getRow(i).getCell(1).getStringCellValue();
			System.out.println(user+"   "+pass);
	}
fi.close();
wb.close();
}}
