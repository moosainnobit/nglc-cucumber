package Steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="//home//moosa//eclipse-workspace//nglc-cucumber//src//test//resources//Features",glue= {"Steps"},
monochrome=true,
plugin = {"pretty","html:target/Reports/Htmlreports.html"})


public class TestRunner {

}