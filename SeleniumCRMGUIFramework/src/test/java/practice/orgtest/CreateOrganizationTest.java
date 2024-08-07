package practice.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
           /*generic utility convert tc into ts 1st video*/
		
		//common data from properties file
		 FileInputStream fis= new FileInputStream("./src/test/resources/cm.properties.txt");
		 Properties pObj= new Properties();
		 pObj.load(fis);
		
		  String BROSWER = pObj.getProperty("browser");
		  String URL = pObj.getProperty("url");
		  String USERNAME = pObj.getProperty("username");
		  String PASSWORD = pObj.getProperty("password");
		  
		  WebDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  driver.get(URL);
		
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitButton")).click();

		 driver.findElement(By.xpath("(//a[contains(@href,'index.php?module')])[4]")).click();
		 driver.findElement(By.xpath("//img[contains(@title,'Create')]")).click();
		 
		 
		 //randomInteger formua
		 Random random=new Random();
		 int randomInt=random.nextInt(1000);
		 //take data from xlx
		 FileInputStream fxel=new FileInputStream("./src/test/resources/data.xlsx");
			Workbook wb=WorkbookFactory.create(fxel);
			Sheet sh=wb.getSheet("org");
			Row r=sh.getRow(1);
			Cell orgName=r.getCell(2);
			String orgname=orgName.toString() + randomInt;
			
			 driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgname);
			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			 
		 //verify header msg expected result
			String headerInfo=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if (headerInfo.contains(orgname)) {
				System.out.println(orgname+": is created====PASS");
			}else {
				System.out.println(orgname+": is Not created====FAIL");
			}
			 
	    //verify header orgname info expected result
		String actOrgName= driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.equals(orgname)) {
			System.out.println(orgname+": is created====PASS");
		}else {
			System.out.println(orgname+": is Not created====FAIL");
		}
	   //log out
		  wb.close();
		  driver.close();
	}

}
