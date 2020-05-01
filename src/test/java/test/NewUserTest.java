package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.NewUserPage;
import pages.SearchUser;

public class NewUserTest extends BaseTest {
	
	
	// Variable Declaration
	NewUserPage npage;
	
	
	//Method Definition
	@Test(dataProvider="Newuser",dataProviderClass=DataProviderClass.class)
	public void AddUser(String s[])
	{
		npage=PageFactory.initElements(driver, NewUserPage.class);
		//npage.AddUser(s[0],s[1],s[2],s[3],s[4],s[5]);
		npage.AddUser(s);
	}
	
	
	
	
}
