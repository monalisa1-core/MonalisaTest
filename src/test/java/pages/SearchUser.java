package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import test.BaseTest;

public class SearchUser {
WebDriver driver;
public SearchUser(WebDriver driver) {
	this.driver=driver;
}
@FindBy(xpath="//*[@id='menu_admin_viewAdminModule']/b")WebElement menuAdmin;
@FindBy(xpath="//input[@id='searchSystemUser_userName']")WebElement admin;
@FindBy(xpath="//input[@id='searchBtn']")WebElement searchClick;
@FindBy(xpath="//td[@class='left']//a[contains(text(),'Admin')]")
public WebElement usernamelink;

public void searchUser(String User) {
	

	menuAdmin.click();
	admin.sendKeys(User);
	
	searchClick.click();
	
String UserName= usernamelink.getText();
	
		/*
		 * if(UserName.equalsIgnoreCase("Admin")) { BaseTest.test.log(LogStatus.PASS,
		 * "Test case Passed"); } else { BaseTest.test.log(LogStatus.FAIL,
		 * "Test case Failed"); Assert.assertTrue(false);
		 * 
		 * }
		 */	
	Assert.assertEquals(UserName, "Admin");
}
}