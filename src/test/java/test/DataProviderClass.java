package test;

import org.testng.annotations.DataProvider;

public class DataProviderClass extends BaseTest
{
	
	@DataProvider(name="Login")
	public Object[][] getData()
	{
		return new Object[][] { {"Admin","admin123"}
			
			
		};
	}
	@DataProvider(name="Newuser")
	public Object[][] getdata2(){
		return new Object[][] { {"Admin","John Smith","Admn12345","Enabled","12345A@sdf","12345A@sdf" }
			
			
		};
		
	}
	@DataProvider(name="SearchUser")
	public Object[][] getData1(){
		return new Object [][] {{"amin"}};
		
	}

}
