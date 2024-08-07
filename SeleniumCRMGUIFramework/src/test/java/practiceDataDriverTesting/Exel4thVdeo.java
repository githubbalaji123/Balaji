package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Exel4thVdeo {

	public static void main(String[] args) throws IOException {
		/* sign in, navigate to organisation, create new organisation enter organisation
		 * name, click on submit, then signout and close application*/
		
		//read the commonData from propertiesFiles
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/cmdata.properties.txt");
		Properties pObj=new Properties();
		pObj.load(fis);
		 
		//intha pObj ref ahh vachi yellathaiyum diff diff container la data va store panna pora
		String BROWSER =pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		//Now do open the browser and sign in
		  WebDriver driver=null;
		  if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to orgainsation
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		//create organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		/*Create the Organisation name using exel data......
		 * But 1st u have to get the organisation name in seperate container
		 * so u have to read on workbook*/
		
		FileInputStream fxel=new FileInputStream("./src/test/resources/data.xlsx");
		Workbook wb=WorkbookFactory.create(fxel);
		Sheet sh=wb.getSheet("org");
		Row r=sh.getRow(4);
		Cell orgName=r.getCell(2);
		String orgname=orgName.toString();
		
		//now go and enter the org name then subit and sign in
		  driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgname);
		  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//sing out and quit the aplication
		  Actions act=new Actions(driver);
		  act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		  driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		  
		  wb.close();
		  driver.quit();
	}
}
