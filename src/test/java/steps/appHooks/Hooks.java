package steps.appHooks;


import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ConfigReader;

public class Hooks {

	@Before
	public void setUp(){
		System.out.println("Browser Opened");
		DriverFactory.openBrowser(ConfigReader.getProperty("url"));
	}
	
	@After
	public void tearDown(){
		DriverFactory.closeBrowser();
		System.out.println("Browser Closed");
	}
}
