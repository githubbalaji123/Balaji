package practiceDataDriverTesting;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class readMultipleDataFromXel {

	public static void main(String[] args) throws Throwable {
		FileInputStream f=new FileInputStream("‪‪./src/test/resources/apachepoibasics.xlsx");
		    Workbook wb= WorkbookFactory.create(f);
		    Sheet sh= wb.getSheet("Sheet2");
		    Row r=sh.getRow(1);
		    String firstColumnData =r.getCell(0).toString();
		    String secondColumnData =r.getCell(1).toString();
		    System.out.println(firstColumnData);
		    System.out.println(secondColumnData);
	}
}
