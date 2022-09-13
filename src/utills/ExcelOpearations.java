package utills;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ExcelOpearations {
	@SuppressWarnings("deprecation")
	@Test
	public void excel() throws Throwable {
	
FileInputStream fi=new FileInputStream("C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\TestInput\\LoginData.xlsx");
XSSFWorkbook wb=new XSSFWorkbook(fi);
XSSFSheet ws=wb.getSheet("Login");
XSSFRow r=ws.getRow(0);
int row=ws.getLastRowNum();
Reporter.log("No pf Rows::"+"   "+row+ true);
int cel=r.getLastCellNum();
Reporter.log("No pf Coloumns::"+"   "+cel+ true);
for(int i=1; i<=row;i++)
{
	if(wb.getSheet("Login").getRow(i).getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC) {
		int cel1=(int) wb.getSheet("Login").getRow(i).getCell(0).getNumericCellValue();
		String celldata=String.valueOf(cel1);
if(wb.getSheet("Login").getRow(i).getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC) {
	int cel2=(int) wb.getSheet("Login").getRow(i).getCell(1).getNumericCellValue();
	String celldata1=String.valueOf(cel2);
     ws.getRow(i).createCell(2).setCellValue("Pass");
  //   ws.getRow(i).createCell(2).setCellValue("Fail");
   //  ws.getRow(i).createCell(2).setCellValue("blocked");
     XSSFCellStyle style =wb.createCellStyle();
		XSSFFont font =wb.createFont();
		font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());
		font.setColor(IndexedColors.RED.getIndex());
		font.setColor(IndexedColors.BLUE_GREY.getIndex());
		font.setBold(true);
		font.setBoldweight(XSSFFont.BOLDWEIGHT_BOLD);
		style.setFont(font);
		ws.getRow(i).getCell(2).setCellStyle(style);
}
	
}
	fi.close();
	FileOutputStream fo = new FileOutputStream("C:\\Users\\Ak\\eclipse-workspace\\DataDrivenFrameWork\\TestOutput\\result.xlsx");
	wb.write(fo);
	fo.close();
	wb.close();
	
}
	}

}