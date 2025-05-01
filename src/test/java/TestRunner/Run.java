package TestRunner;
//import org.junit.runner.RunWith;

import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.AbstractTestNGCucumberTests;


//@RunWith(Cucumber.class)
@CucumberOptions(
					features = {".//Features/LoginFeature.feature",".//Features/AddBill.feature"},
					glue="StepDefinition",
					dryRun = false,
					monochrome = true,
					tags = "@Sanity ",//scenarios under @sanity tag will be executed
					//plugin = {"pretty","html:target/cucumber-reports/reports2.html"}
					plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:DIR"}
				
				)

//"html:target/cucumber-reports/report1.html"	
//"json:target/cucumber-reports/reportjson.json"
//"junit:target/cucumber-reports/reportxml.xml"

public class Run extends AbstractTestNGCucumberTests{
	/*This class will be empty*/
}