package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LogginPage;
import pages.SearchUser;

public class SearchUserTest extends BaseTest {
	
	SearchUser user;
	
	

	@Test(dataProvider="SearchUser",dataProviderClass=DataProviderClass.class)//(groups= {"smoke"},enabled=false,dependsOnMethods = {"LoginTest"},priority=1)()
	public void searchUser(String User) {
		
		
	//	test=extent.startTest("Search User Test", "This is search user test");

		
		user=PageFactory.initElements(driver, SearchUser.class);
		
		user.searchUser(User);
		
		
	//	extent.endTest(test);
		
		
		
	}

}
