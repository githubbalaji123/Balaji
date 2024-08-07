package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws Throwable, IOException {
		
	/*  1 get the excel path location & java object of the physical exel file
		2 open workbook in read mode
		3 get the control of the org sheet
		4 get the control of the 1st row
		5 get the control of the 2nd cell & read the string data
		6 close the workbook */

	//1	
  		
		//FileInputStream fis= new FileInputStream("‪‪‪D:\\RKSHETTY SE\\data\\apachepoibasics.xlsx");
	     FileInputStream fis=new FileInputStream("D:\\\\RKSHETTY SE\\\\data\\\\apachepoibasics.xlsx");
		//2	
	    Workbook wb=WorkbookFactory.create(fis);
    //3
		Sheet sh= wb.getSheet("org");
	//4
	    Row row=sh.getRow(1);
	//5
	   org.apache.poi.ss.usermodel.Cell cel= row.getCell(2);
	   String data= cel.getStringCellValue();
	   System.out.println(data);
	//6
	   wb.close();
	}
}
