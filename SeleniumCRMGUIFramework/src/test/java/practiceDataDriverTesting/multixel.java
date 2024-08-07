package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class multixel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream f=new FileInputStream("C:\\Users\\ASUS\\Desktop\\data.xlsx");
	    Workbook wb= WorkbookFactory.create(f);
	    Sheet sh= wb.getSheet("Sheet1");
	   int row=sh.getLastRowNum();
	   System.out.println(row);
	   System.out.println("\t");
	    for (int i = 0; i <=row; i++) {
	    	Row r=sh.getRow(i);
		    String firstColumnData =r.getCell(0).toString();
		    String secondColumnData =r.getCell(1).toString();
		    System.out.println(firstColumnData+":"+"  "+secondColumnData);	
		}
	    wb.close();
	}
}
