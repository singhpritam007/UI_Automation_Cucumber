package seleniumHelper;

import java.time.Duration;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import factory.DriverFactory;
import utils.ConfigReader;

/**
 * 
 * @author Pritam Singh
 *
 */

public class SeleniumHelper {

	/**
	 * Method Having Ability to wait until the Element Will be Visible
	 * and Having ability to Handle no such element exception
	 * @param by
	 * @return WebElement
	 */
	public WebElement findElement(By by) {
		WebDriver driver = DriverFactory.getDriver();
		int iterationCount=Integer.parseInt(ConfigReader.getProperty("timeout"));
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(iterationCount))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement elem = driver.findElement(by);
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
	 * @param by
	 * @param text
	 */
	public void enterText(By by,String text){
		findElement(by).sendKeys(text);
	}
	
	/**
	 * Method to Click on WebElement
	 * @param by
	 */
	public void click(By by){
		findElement(by).click();
	}
	
	/**
	 * Method to Click on WebElement
	 * @param by
	 */
	public void clickByJs(By by){
		JavascriptExecutor executor=(JavascriptExecutor)(DriverFactory.getDriver());
		executor.executeScript("arguments[0].click();",findElement(by));
	}
	
	/**
	 * Method to scroll up to element
	 * @param by
	 */
	public void scrollToElement(By by){
		JavascriptExecutor executor=(JavascriptExecutor)(DriverFactory.getDriver());
		executor.executeScript("arguments[0].scrollIntoView(true);",findElement(by));
	}
	
	/**
	 * Method to accept alert
	 * @param by
	 */
	public void acceptAlert(By by){
		DriverFactory.getDriver().switchTo().alert().accept();
	}
	
	/**
	 * Method to dismiss alert
	 * @param by
	 */
	public void dismissAlert(By by){
		DriverFactory.getDriver().switchTo().alert().dismiss();
	}
	
	/**
	 * Method to dismiss alert
	 * @param by
	 */
	public void getAlertText(By by){
		DriverFactory.getDriver().switchTo().alert().getText();
	}
	
	/**
	 * Method to switch to frame by index
	 * @param index
	 */
	public void switchFrameByIndex(int index){
		DriverFactory.getDriver().switchTo().frame(index);
	}
	
	/**
	 * Method to switch to frame by name or id
	 * @param nameOrId
	 */
	public void switchFrameByName(String nameOrId){
		DriverFactory.getDriver().switchTo().frame(nameOrId);
	}
	
	/**
	 * Method to switch to frame by element
	 * @param by
	 */
	public void switchToFrame(By by){
		DriverFactory.getDriver().switchTo().frame(findElement(by));
	}
}
