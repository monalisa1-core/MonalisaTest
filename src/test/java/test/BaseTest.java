package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseTest {
	static WebDriver driver;
	String browserName;
	static ExtentReports extent; // for creating report file
	public static ExtentTest test; // for invoking test case on report
	static int flag=0;
	
	@Parameters({"browser","url"})
	@BeforeSuite
	public void browserSet(String browser,String url) throws IOException {
		
		//extent=new ExtentReports(System.getProperty("user.dir")+"\\MyReport.html"); //Create report file
		
		if(flag==0)
		{
		FileInputStream obj=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/res/data.properties");
		
		Properties prop=new Properties();
		
		prop.load(obj);
		
		//browserName=prop.getProperty("browser"); // to run  from properties file 
		browserName=browser;
		//String url=prop.getProperty("url");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			ChromeOptions opt=new ChromeOptions();
			opt.setPageLoadStrategy(PageLoadStrategy.NONE);
			
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");

		driver=new ChromeDriver(opt);
		driver.get(url);
		
		
		}
		
		else {
			
			
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");

			driver= new FirefoxDriver();
			driver.get(url);
		}
		
		}
		flag++;
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	//@AfterSuite
	public void tearDown()
	{
	//	extent.flush();
	//	extent.close();
	}
	

}
