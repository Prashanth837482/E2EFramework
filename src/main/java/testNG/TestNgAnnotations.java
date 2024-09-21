package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;





public class TestNgAnnotations{
	
	@Test(groups = "Notest")
	@Parameters({"browser","URL"})
	// the above parameter name should be same that as names in xml file
	public void parameters(String browser, String url) {
		// we should run the test from TestNgSuite that is testng.xml file as the data should be populated from there only.
		System.out.println("The browser given in xml file is: "+browser);
		System.out.println("The URL given in xml file is: "+url);
		
	}
	
	
	@Test(groups = "Notest")
	@Parameters({"browser","URL","path"})
	// if parameter is not mentioned/missing/ mismatched in xml then optional will provide the value given in the optional annotation.
	public void parametersOptional(String browser, String url,@Optional("www.google.com") String path) {
		// we should run the test from TestNgSuite that is testng.xml file as the data should be populated from there only.
		System.out.println("The browser given in xml file is: "+browser);
		System.out.println("The URL given in xml file is: "+url);
		System.out.println("The path given in xml file is: "+path);
	}
	
	@DataProvider(name="TestData")
	public Object[][] dataProvider() {
		
		Object[][] obj= new Object[2][2];
		
		obj[0][0] = "prash";
		obj[0][1] ="password1";
		
		obj[1][0] = "prashanth";
		obj[1][1] ="password2";
		
		return obj;
	}
	//This Test method will run according to the number of sets(rows) of data being passed from dataprovider. if 2 rows or sets passed this test will be executed twice separately.
	@Test(dataProvider = "TestData")
	public void dataProviderTest(String username, String password) {
		
		System.out.println("username is: "+username);
		System.out.println("password is: "+password);
	}
	
	
	//Priority with Dependencies: The priority attribute is used to control the order of test execution only among methods in the same test class when there are no dependencies. If you use dependsOnMethods, TestNG handles execution order based on dependencies rather than priorities.
	@Test(dependsOnMethods = "dataProviderTest", priority = 0, groups = "test")
	public void dependsOnMethods() {
		
		System.out.println("getting executed after dataProviderTest method");
	}
	
	
	@Test(enabled = true, priority = 1)
	public void enabled() {
		System.out.println("Executing priority test method");
	}
	
	
	@Test(invocationCount = 3, threadPoolSize = 3, groups = "test")
	// invocation count runs the test method with specified number of times
	// threadpoolsize is used to assign the threads to the test method it is used in conjunction with invocation count
	// if invocation count is 10 and threadpollsize is 2 then each thread executes 5 methods i.e. each thread executes= invocCount/threadPoolSize  
	public void invocationCount() {
		
		System.out.println("invocation count code");
		
	}
	
	
	

}
