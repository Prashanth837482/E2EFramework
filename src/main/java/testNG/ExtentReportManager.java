package testNG;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import javax.swing.plaf.DesktopIconUI;
import javax.swing.plaf.basic.BasicDesktopIconUI;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	//below 3 classes are required for report generation.
	public ExtentSparkReporter sparkReporter;  // to configure UI of the report
	public ExtentReports extent; //to populate common info on the report
	public ExtentTest test; // creating test case entries in the report and updating the status of the test cases to the report.
	public String ReportName;
	
	public void onStart(ITestContext context) {
	    System.out.println("Execution Started....");
	    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
	    ReportName = System.getProperty("user.dir")+"/Reports/ExtentReport-"+timeStamp+".html";
	    sparkReporter =  new ExtentSparkReporter(ReportName);
	    
	    sparkReporter.config().setDocumentTitle("Test Execution Report");
	    sparkReporter.config().setReportName("Regression Testing");
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    // system info takes two key value pairs just like hash map we can add the static data as per requirement.
	    extent.setSystemInfo("Tester Name", "prashanth");
	    extent.setSystemInfo("Environment", "SIT1");
	    
	    
	  }
	
	public void onTestStart(ITestResult result) {
		 System.out.println("TestCase Execution Started....");
		 
	 }
	
	public void onTestSuccess(ITestResult result) {
		  System.out.println("TestCase Passed....");
		  test = extent.createTest(result.getName()); // create new entry in the report
		  test.log(Status.PASS, result.getName()+" : Test is Passed");
		  
		  
	}
	
	public void onTestFailure(ITestResult result) {
		  System.out.println("TestCase Failed....");
		  test = extent.createTest(result.getName()); // create new entry in the report
		  test.log(Status.FAIL, result.getName()+" : Test is Failed");
		  
		  }
	
	public void onTestSkipped(ITestResult result) {
		  System.out.println("TestCase Skipped....");
		  test = extent.createTest(result.getName()); // create new entry in the report
		  test.log(Status.SKIP, result.getName()+" : Test is Skipped");
		  }
	
	public void onFinish(ITestContext context) {
		  System.out.println("Execution Finished....");
		  extent.flush();
		  
				 
		  }
}
