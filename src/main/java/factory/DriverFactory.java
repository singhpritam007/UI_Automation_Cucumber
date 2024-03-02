package factory;

import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Author- Pritam Singh
 */
public final class DriverFactory {

	private DriverFactory(){
		
	}
	static ThreadLocal<WebDriver> threadLocal=new ThreadLocal<WebDriver>();
	
	public static void openBrowser(String url){	
		WebDriverManager.chromedriver().setup();
		if(Objects.nonNull(threadLocal.get())){
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);
			threadLocal.set(driver);
		}
		
	}
	
	public static void closeBrowser(){	
		if(Objects.nonNull(threadLocal.get())){
			threadLocal.get().quit();
		}
	}
	
	public static WebDriver getDriver(){
		return threadLocal.get();
	}
}
