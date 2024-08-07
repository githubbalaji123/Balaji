package practiceDataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class prop1stvedo {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream f=new FileInputStream("./src/test/resources/data.properties.txt");
		Properties p=new Properties();
		p.load(f);
		String b= p.getProperty("browser");
		String u=p.getProperty("url");
		String un=p.getProperty("username");
		String pass=p.getProperty("password");
		
		WebDriver driver=new FirefoxDriver();
		driver.get(u);
		driver.manage().window().maximize();
		
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pass);
		driver.findElement(By.id("submitButton")).click(); 
	    Thread.sleep(3000);
	    driver.quit();
	}
}
