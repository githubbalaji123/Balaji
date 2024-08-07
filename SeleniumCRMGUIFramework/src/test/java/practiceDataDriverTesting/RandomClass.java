package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
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

public class RandomClass {

	public static void main(String[] args) throws Throwable {
		//take common data from properties files
    FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/cmdata.properties.txt");
    Properties p=new Properties();
    p.load(fis);
    String BROWSER =p.getProperty("browser");
    String URL =p.getProperty("url");
    String USER =p.getProperty("username");
    String PASSWORD =p.getProperty("password");
   
    //open the browser using prop datas
    WebDriver d=null;
    if (BROWSER.equals("chrome")) {
		d=new ChromeDriver();
	}else if(BROWSER.equals("firefox")) {
		d=new FirefoxDriver();
	}else if(BROWSER.equals("edge")) {
		d=new EdgeDriver();
	}else {
		d=new ChromeDriver();
	}
	
    //navigate to the site and enter ur credientials by prop
    d.get(URL);
    d.manage().window().maximize();
    d.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    d.findElement(By.xpath("//input[@type='text']")).sendKeys(USER);
    d.findElement(By.xpath("//input[@type='password']")).sendKeys(PASSWORD);
    d.findElement(By.xpath("//input[@type='submit']")).submit();
    
    //now iam going to do some modification in my xel by putting _ in the facebook org
    // hence there are 2 steps readmode and write mode 
                  //read mode
    FileInputStream xfis=new FileInputStream("./src/test/resources/data.xlsx");
    Workbook wb= WorkbookFactory.create(xfis);
    Sheet sh=wb.getSheet("org");
    Row r=sh.getRow(1);
    Cell c=r.createCell(2);
    c.setCellType(CellType.STRING);
    c.setCellValue("facebook_");
                    //write mode
    FileOutputStream fs=new FileOutputStream("./src/test/resources/data.xlsx");
    wb.write(fs);
    wb.close();
    
    //   GENERATE THE RANDOM NUMBERS
      Random ran=new Random();
      int ranInt=ran.nextInt(1000);
      
      //*x*x**x*x READ TESTSCRIPT DATA FROM THE XLSHEET AND GIVE THE RANDOM NUMBER TO IT *x*x*x*x*x*x*
                     String orgName=r.getCell(2).toString() + ranInt;
                     wb.close(); 
                     
             //navigate to orgainsation
      d.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
       		//create organisation
     d.findElement(By.xpath("//img[@title='Create Organization...']")).click();
     
   //now go and enter the org name then subit and sign in
	  d.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys(orgName);
	  d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//sing out and quit the aplication
	  Actions act=new Actions(d);
	  act.moveToElement(d.findElement(By.xpath("(//img[contains(@style,'padding: 0px;padding-left:5px')])[1]"))).perform();
	  d.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	  wb.close();
	  d.quit();
	}
}
