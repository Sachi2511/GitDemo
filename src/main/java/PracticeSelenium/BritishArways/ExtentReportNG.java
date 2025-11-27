package PracticeSelenium.BritishArways;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	
	public ExtentReports getReportObject()
	{
		String path=System.getProperty("user.dir")+"//listenerreports1//listenerindex1.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Listeners Report");
		reporter.config().setDocumentTitle("Test results");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sachi");
		return extent;
	}

	
}
