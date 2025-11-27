package PracticeSelenium.BritishArways;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners implements ITestListener {

	ExtentReportNG er=new ExtentReportNG();
	ExtentTest test;
	ExtentReports extent=er.getReportObject();
	WebDriver driver;
	 @Override		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub			
		   test.fail("Failing by iteself");
            extent.flush();
	        		
	    }		

	    @Override		
	    public void onStart(ITestContext arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestFailure(ITestResult result) {					
	        // TODO Auto-generated method stub				
	        	test.fail(result.getThrowable());	
	        	try {
					driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        	String testCaseName= result.getMethod().getMethodName();
	        	String filePath=System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
	        	File destFile=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
	        	try {
					FileUtils.copyFile(srcFile, destFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        	test.addScreenCaptureFromPath(filePath, testCaseName);
	    }		

	    @Override		
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

	    @Override		
	    public void onTestStart(ITestResult result) {					
	        // TODO Auto-generated method stub		
	    	test=extent.createTest(result.getMethod().getMethodName());	        		
	    }		

	    @Override		
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub	
	    	test.log(Status.PASS, "Test Passed");
	    	
	        		
	    }		
}
