package stepDefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		// should provide whole feature file path
		features = "src/main/resources/tryOut.feature",
		// should provide only package where java files were there it automatically scans all the java files in the package
		glue = "stepDefinitions",
		// tags should be mentioned along with the "@"
		tags = "@regression or @sanity"
		
		// plugin = {"pretty", "html:target/cucumber-reports"}, // Optional: for report generation
		
		
		)


public class BddTestNgRunnerClass extends AbstractTestNGCucumberTests{

}
