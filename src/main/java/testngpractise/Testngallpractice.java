package testngpractise;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Testngallpractice {
	
	WebDriver driver;
	String browser= "chrome";
@BeforeClass
	public void trycatchtostart () {
		try {
			Properties pro = new Properties ();
			InputStream input = new FileInputStream(".\\src\\main\\java\\config.properties");
			pro.load(input);
			browser= pro.getProperty("browser");
		System.out.println("The browser ="+browser);
	}
	catch (Exception e) {		
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
@BeforeMethod

public void selection () {
	if (browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	} else if (browser.equalsIgnoreCase("firefox"))
			{
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
			}
	
	driver.get("https://techfios.com/billing/?ng=admin/");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	
	

@Test
public void assignment() {
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
	driver.findElement(By.xpath("//button[@name='login']")).click();
}

}