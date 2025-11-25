package utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryListener implements IAnnotationTransformer {
	//https://chatgpt.com/c/69248c0d-842c-8320-b0e9-9790dc3130f7
   // As we pass this globally without adding @Test(retryAnalyzer = utils.RetryAnalyzer.class) at each test method level 
	//so below transform function adds this annotation at each method level internally.
    @Override
    public void transform(ITestAnnotation annotation,
                          Class testClass,
                          Constructor testConstructor,
                          Method testMethod) {
    	annotation.setRetryAnalyzer(utils.RetryAnalyzer.class); 
    	
    	/* To configure retry for specific test methods based on test method name, group name and class name
    	if(testMethod.getName().equalsIgnoreCase("testLogin")) {
    		annotation.setRetryAnalyzer(utils.RetryAnalyzer.class);    		
    	}
    	*/
    }
}
