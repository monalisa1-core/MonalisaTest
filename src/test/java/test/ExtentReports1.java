package test;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;
 
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
 
public class ExtentReports1 implements IReporter {
    
    BaseTest b= new BaseTest();
    
     static ExtentReports extent;
  static  ExtentTest test;
 
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        extent = new ExtentReports(outputDirectory + File.separator + "ExtentReportsTestNG.html", true);
 
        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();
 
            for (ISuiteResult r : result.values()) {
            	
            	 ITestContext context = r.getTestContext();
            	 
                 try {
					buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 try {
					buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                 try {
					buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
 
               
        extent.flush();
        extent.close();
    }
 
   

    private void buildTestNodes(IResultMap tests, LogStatus status) throws IOException {
       
 
        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.startTest(result.getMethod().getMethodName());
 
                /*test.getTest(). = getTime(result.getStartMillis());
                test.getTest().endedTime = getTime(result.getEndMillis());*/
 
                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);
 
                String message = "Test " + status.toString().toLowerCase() + "ed";
 
                if (result.getThrowable() != null)
                {
                   // message = result.getThrowable().getMessage();
                    getScreenshot(result.getName());
                    
                }
 
                test.log(status, message);
                
            
                
         
                
                             extent.endTest(test);
            }
        }
        
        
    }
 
    public void getScreenshot(String screen) throws IOException
    {
         //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot) BaseTest.driver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                String dest=System.getProperty("user.dir")+"\\"+screen+"error.png";
                File DestFile=new File(dest);
                
                String imgpath=dest;
                

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);
                
                String img=test.addScreenCapture(imgpath);
        
       test.log(LogStatus.FAIL, img);
    }

    
    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();        
    }
}
