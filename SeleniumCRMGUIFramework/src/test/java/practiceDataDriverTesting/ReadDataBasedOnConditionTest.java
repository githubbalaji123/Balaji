package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditionTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		boolean flag=false;
		String expected_result="tc_02";
		String data1="";
		String data2="";
		String data3="";
		
		FileInputStream fis=new FileInputStream("C:\\Users\\ASUS\\Desktop\\data.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("org");
		int rowCount =sh.getLastRowNum();
		
		for (int j = 0; j<=rowCount; j++) {
			String data ="";
			try {
			data=sh.getRow(j).getCell(0).toString();
			if (data.equals(expected_result)) {
				flag=true;
				data1=sh.getRow(j).getCell(1).toString();
				data2=sh.getRow(j).getCell(2).toString();
				data3=sh.getRow(j).getCell(3).toString();
			}
			}catch(Exception e) {
		   }
	      }
		if (flag==true) {
			System.out.println(data1+" : "+data2+" : "+data3);
		}else {
			System.out.println(expected_result+": "+"data is not available");
        }
		wb.close();
	}
}
