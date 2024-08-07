package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {
 public static void main(String[] args) throws IOException {
	 FileInputStream fis= new FileInputStream("./src/test/resources/cm.properties.txt");
	 Properties pObj= new Properties();
	 pObj.load(fis);
	
	  String BROSWER = pObj.getProperty("browser");
	  String URL = pObj.getProperty("url");
	  String USERNAME = pObj.getProperty("username");
	  String PASSWORD = pObj.getProperty("password");
	  
	  WebDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get(URL);
	
	  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	  driver.findElement(By.id("submitButton")).click();
	 
	   driver.findElement(By.linkText("Organizations")).click();
	   driver.quit();
}
}
