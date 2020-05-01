package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewUserPage {
	WebDriver driver;
	
	public NewUserPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(id="btnAdd")WebElement btnAdd;
	@FindBy(id="systemUser_userType")  WebElement s1;
	
	@FindBy(id="systemUser_employeeName_empName")WebElement txtEmplName;
	@FindBy(id="systemUser_userName")WebElement txtUsername;
	@FindBy(id="systemUser_status")WebElement s2;
	@FindBy(id="systemUser_password")WebElement txtPassword;
	@FindBy(id="systemUser_confirmPassword")WebElement txtconfirmPassword;
	@FindBy(id="btnSave")WebElement btnSave;
	
	
	public void AddUser(String s[])
	{
		btnAdd.click();
		new Select(s1).selectByVisibleText(s[0]);
		txtEmplName.sendKeys(s[1]);
		txtUsername.sendKeys(s[2]);
		
		new Select(s2).selectByVisibleText(s[3]);
		txtPassword.sendKeys(s[4]);
		txtconfirmPassword.sendKeys(s[5]);
		btnSave.click();
		
	}
	
	
		
	
}
