package seleniumHelper;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import factory.DriverFactory;
import utils.ConfigReader;

/**
 * 
 * @author Pritam Singh & Prashant Baurai
 *
 */

public class SeleniumHelper {

	/**
	 * Methods Finds and returns a web element based on the specified locator.
	 *
	 * @param byLocator : The locator (By object) used to find the web element.
	 * @return The web element if found, or null if not displayed or enabled.
	 */
	public WebElement findElement(final By byLocator) {
		
		WebDriver driver = DriverFactory.getDriver();
		int iterationCount = Integer.parseInt(ConfigReader.getProperty("timeout"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(iterationCount))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement elem = driver.findElement(byLocator);
				if (elem.isDisplayed() && elem.isEnabled()) {
					return elem;
				}
				return null;
			}
		});
		
		return element;
	}
	
	/**
	 * Method to enter text
	 * @param by : The locator (By object) used to find the web element.
	 * @param text
	 */
	public void enterText(By by,String text){
		findElement(by).sendKeys(text);
	}
	
	/**
	 * Method to Click on WebElement
	 * @param by : The locator (By object) used to find the web element.
	 */
	public void click(By by){
		findElement(by).click();
	}
	
	/**
	 * Method to Click on WebElement
	 * @param by : The locator (By object) used to find the web element.
	 */
	public void clickByJs(By by){
		JavascriptExecutor executor=(JavascriptExecutor)(DriverFactory.getDriver());
		executor.executeScript("arguments[0].click();",findElement(by));
	}
	
	/**
	 * Method to scroll up to element
	 * @param by : The locator (By object) used to find the web element.
	 */
	public void scrollToElement(By by){
		JavascriptExecutor executor=(JavascriptExecutor)(DriverFactory.getDriver());
		executor.executeScript("arguments[0].scrollIntoView(true);",findElement(by));
	}
	
	/**
	 * Method to accept alert
	 * @param by : The locator (By object) used to find the web element.
	 */
	public void acceptAlert(By by){
		DriverFactory.getDriver().switchTo().alert().accept();
	}
	
	/**
	 * Method to dismiss alert
	 * @param by : The locator (By object) used to find the web element.
	 */
	public void dismissAlert(By by){
		DriverFactory.getDriver().switchTo().alert().dismiss();
	}
	
	/**
	 * Method to dismiss alert
	 * @param by : The locator (By object) used to find the web element.
	 */
	public void getAlertText(By by){
		DriverFactory.getDriver().switchTo().alert().getText();
	}
	
	/**
	 * Method to switch to frame by index
	 * @param index : frameIndex The index of the frame to switch to
	 */
	public void switchToFrame(int frameIndex){
		DriverFactory.getDriver().switchTo().frame(frameIndex);
	}
	
	/**
	 * Method to switch to frame by name or id
	 * @param nameOrId
	 */
	public void switchToFrame(String nameOrId){
		DriverFactory.getDriver().switchTo().frame(nameOrId);
	}
	
	/**
	 * Method to switch to frame by element
	 * @param by
	 */
	public void switchToFrame(By byLocator){
		DriverFactory.getDriver().switchTo().frame(findElement(byLocator));
	}
	
	/**
	 * Method Gets the visible text of a web element identified by the specified locator.
	 *
	 * @param byLocator The locator (By object) used to find the web element.
	 * @return The visible text of the web element.
	 */
	public String getText(By byLocator) {
		return findElement(byLocator).getText();
	}
	
	/**
	 * Methods select the webElement from dropDown based on specified locator and visible Text.
	 * 
	 * @param byLocatorForDropDown : The locator (By object) used to find the web element.
	 * @param visibleText : The visible text of the option to be selected.
	 */
	public void selectElementFromDropDown(By byLocatorForDropDown,String visibleText) {
     Select sel = new Select(findElement(byLocatorForDropDown));
     sel.selectByVisibleText(visibleText);
	}
	
	/**
	 * Methods select the webElement from dropDown based on specified locator and index value.
	 * 
	 * @param byLocatorForDropDown : The locator (By object) used to find the web element.
	 * @param index : The index value of the webElement according to dropDown Option.
	 */
	public void selectElementFromDropDown(By byLocatorForDropDown,int index) {
	     Select sel = new Select(findElement(byLocatorForDropDown));
	     sel.selectByIndex(index);
	}
	
	/**
	 * Method select the webElement from dropDown based on 'Value Attribute' and specified locator.
	 * 
	 * @param value : The value of the 'Value Attribute'
	 * @param byLocatorForDropDown : The locator (By object) used to find the web element.
	 */
	public void selectElementFromDropDown(String value,By byLocatorForDropDown) {
	     Select sel = new Select(findElement(byLocatorForDropDown));
	     sel.selectByValue(value);
	}
	
	/**
	 * Method perform various Mouseover action based on specified Locator
	 * 
	 * @param byLocator : The locator (By object) used to find the web element.
	 */
	public Actions moveToElement(By byLocator) {
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement element = findElement(byLocator);
		Actions action = (Actions)act.moveToElement(element).build();
		action.perform();
		return action;
	}
	
	/**
	 * Method perform drag and drop action based on specified 'byLocator' of source and Target element
	 * 
	 * @param byLocatorForSource : The locator (By object) used to find the 'Source web element'.
	 * @param byLocatorForTarget : The locator (By object) used to find the 'Target web element'.
	 */
	public void dragAndDrop(By byLocatorForSource,By byLocatorForTarget) {
		Actions act = new Actions(DriverFactory.getDriver());
		WebElement source = findElement(byLocatorForSource);
		WebElement target = findElement(byLocatorForTarget);
		act.dragAndDrop(source, target).build().perform();
	}
	
	
}