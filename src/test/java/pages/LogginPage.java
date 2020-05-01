package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import test.BaseTest;

public class LogginPage {

	// Define page objects and methods

	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='txtUsername']")
	WebElement Username;
	@FindBy(xpath = "//input[@id='txtPassword']")
	WebElement password;
	@FindBy(xpath = "//input[@id='btnLogin']")
	WebElement loggin;

	public LogginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void loggin(String UserName,String Password) {

	//	BaseTest.test.log(LogStatus.INFO, "Enter username");
		Username.sendKeys(UserName);
	//	BaseTest.test.log(LogStatus.INFO, "Enter password");
		
		password.sendKeys(Password);
	//	BaseTest.test.log(LogStatus.INFO, "Click on Login");
		
		loggin.click();

	}

}
