package testNG;

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
	
	public void onStart(ITestContext context) {
	    System.out.println("Execution Started....");
	    sparkReporter =  new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/ExtentReport.html");
	    
	    sparkReporter.config().setDocumentTitle("Test Execution Report");
	    sparkReporter.config().setReportName("Regression Testing");
	    sparkReporter.config().setTheme(Theme.STANDARD);
	    
	    extent = new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    
	    // system info takes two key value pairs just like hash map we can add the static data as per requirement.
	    extent.setSystemInfo("Tester Name", "prashanth");
	    extent.setSystemInfo("Environment", "SIT1");
	  }
	
	public void onTestSuccess(ITestResult result) {
		  System.out.println("TestCase Passed....");
		  test = extent.createTest(result.getName()); // create new entry in the report
		  test.log(Status.PASS, result.getName()+" : Test is Passed");
		  
	}
	
	public void onFinish(ITestContext context) {
		  System.out.println("Execution Finished....");
		  extent.flush();
		  }
}
