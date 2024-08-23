package testNG;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

// control click on the ITestListener Interface below implemented to get the methods avble in the interface. 
// Copy methods from the opened ITestListener Class and paste here and change the access modifier to public.
// Run ListenerTestng.xml testng suite for listener to get triggered.
public class TestNGListener implements ITestListener {
	
	 /**
	   * Invoked before running all the test methods belonging to the classes inside the &lt;test&gt;
	   * tag and calling all their Configuration methods.
	   *
	   * @param context The test context
	   */
	  public void onStart(ITestContext context) {
		    System.out.println("Execution Started....");
		  }
	  /**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   * @see ITestResult#STARTED
	   */
	 public void onTestStart(ITestResult result) {
		 System.out.println("TestCase Execution Started....");
	 	 }
	 /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	  public void onTestSuccess(ITestResult result) {
		  System.out.println("TestCase Passed....");
		  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
		  System.out.println("TestCase Failed....");
		  }
	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
		  System.out.println("TestCase Skipped....");
		  }
	  /**
	   * Invoked after all the test methods belonging to the classes inside the &lt;test&gt; tag have
	   * run and all their Configuration methods have been called.
	   *
	   * @param context The test context
	   */
	  public void onFinish(ITestContext context) {
		  System.out.println("Execution Finished....");
		  }
	
}
