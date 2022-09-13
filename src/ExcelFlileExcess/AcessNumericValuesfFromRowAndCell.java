package ExcelFlileExcess;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class AcessNumericValuesfFromRowAndCell {

	
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args) throws Throwable {
		FileInputStream fi= new FileInputStream("F:\\Login.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		XSSFSheet ws= wb.getSheet("Login");
	int row=ws.getLastRowNum();
	for(int i=1; i<=row; i++)
	{
		String user=ws.getRow(i).getCell(0).getStringCellValue();
		if(wb.getSheet("Login").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC)
{
	int celdata=(int)wb.getSheet("Login").getRow(i).getCell(1).getNumericCellValue();
	String pass=String.valueOf(celdata);
	System.out.println(user+"   "+pass);
	
}}
fi.close();


	}
	}
		
	


