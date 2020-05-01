package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pages.LogginPage;

//@Listeners(Listener.class)
public class LogginTest extends BaseTest {

	LogginPage lpage;
	
	
	
	
	@Test(dataProvider = "Login",dataProviderClass = DataProviderExcel.class)
	public void loggin(String UserName,String Password) {
		
	///test=extent.startTest("LoginTest", "This is login test");

		//lpage = new LogginPage(driver);
		lpage=PageFactory.initElements(driver, LogginPage.class);
		lpage.loggin(UserName,Password);
		
		
		//test.log(LogStatus.PASS, "Test case Passed");
		
	//	extent.endTest(test);
		System.out.println("Welcome");
		System.out.println("****");
	}
	
	//System.out.println("Welcome");

}
