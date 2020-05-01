package pages;

import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {

	 Screen s ;


    @Test 
    public void setup() throws FindFailed {
    	s=new  Screen();
       // System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        String filepath = "C:\\Users\\Hacker\\Desktop\\demo\\SeleniumDemo\\Screen";
        //String inputFilePath = "D:\\Guru99Demo\\Files\\";
        
       // Pattern fileInputTextBox = new Pattern(filepath + "FileTextBox.PNG");
     //   Pattern openButton = new Pattern(filepath + "OpenButton.PNG");
        WebDriver driver;

        // Open Chrome browser    
        driver = new ChromeDriver();
      //  driver.get("http://demo.guru99.com/test/upload/");
        driver.get("http://demo.automationtesting.in/Register.html");
       
driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//driver.findElement(By.id("imagesrc")).click();

        // Click on Browse button and handle windows pop up using Sikuli
       // driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\Hacker\\Desktop\\demo\\SeleniumDemo\\text1.txt");
        s.click(filepath+"\\Choose.png");
        s.wait(filepath+"\\FileInputBox.png", 20);
        s.type(filepath+"\\Choose.png");
        s.click(filepath+"\\OpenButton.png");

        // Close the browser
        driver.close();

    }

}


