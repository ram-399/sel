package TestNG;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class addressbook {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("disable_infobars", true);		
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		
		WebDriver driver=new ChromeDriver(cap);
		
		//driver.get("http://www.facebook.com");
		
		By loginButtonLocator = By.xpath("//input[@id='Login']");
		By passwordLocator = By.xpath("//input[@id='password']");
		By usernameLocator = By.xpath("//input[@id='username']");
		By setup=By.xpath("//div[@class='slds-global-header__item']/ul/li[7]"); 
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 
		//driver.get("https://www.freecrm.com");
		driver.get("https://nokia--qcrm3.lightning.force.com/");
		driver.findElement(usernameLocator).sendKeys("ch_qcrm3_sys@nokia.com.qcrm3");
		driver.findElement(passwordLocator).sendKeys("QCRM3@1234");
		driver.findElement(loginButtonLocator).click();
		Thread.sleep(5000);
		driver.findElement(setup).click();	
		Thread.sleep(2000);
		
	Actions act=new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
		
		

	}

}

   
  
