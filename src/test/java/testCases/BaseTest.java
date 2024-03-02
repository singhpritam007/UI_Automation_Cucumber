package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import factory.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

	@BeforeMethod
	public void setUp(){
		DriverFactory.openBrowser(ConfigReader.getProperty("url"));
	}
	
	@AfterMethod
	public void tearDown(){
		DriverFactory.closeBrowser();
	}
}
