/**
 * 
 */
package cucumberRunner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

/**
 * @author kevser
 *
 */


//http://www.softwaretestinghelp.com/cucumber-bdd-tool-selenium-tutorial-30/

@RunWith(Cucumber.class)
@Cucumber.Options(features="Test1"
)
//format={"hmtl:target/cucumber-html-report"})


public class TestRunner {

}
