package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.model.Test;



public class Listener implements ITestListener{
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

		System.out.println(" I am listening to the passed test case");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println(" I am listening to the failed test case");
		
		 //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot) BaseTest.driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                String dest=System.getProperty("user.dir")+"\\error.png";
                File DestFile=new File(dest);
                
                String imgpath=dest;
                

                //Copy file at destination

                try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
                String img=BaseTest.test.addScreenCapture(imgpath);
        
       BaseTest.test.log(LogStatus.FAIL, img);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
			}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
