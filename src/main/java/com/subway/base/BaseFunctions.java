package com.subway.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.subway.TestData.DataDriven;
import com.subway.util.WebEventListner;
public class BaseFunctions {
	public static long PAGE_LOAD_TIMEOUT = 1;
	public static long IMPLICIT_WAIT = 1;
	@FindBy(xpath="//button[contains(@class,'onetrust-close-btn-ui')]")
	WebElement closeCookie;
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListner eventListener;
	public Logger log=Logger.getLogger(BaseFunctions.class);
	//Constructor to initialize  properties files//
	public BaseFunctions() {
		prop= new Properties();
		try {
			FileInputStream f= new FileInputStream("C:\\Users\\aksrana\\eclipse-workspace\\com.subway\\src\\main\\java\\com\\subway\\config\\config.properties");
			try {
				prop.load(f);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@SuppressWarnings("deprecation")
	public static void initialize() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("test-type");
		options.addArguments("enable-strict-powerful-feature-restrictions");
		options.addArguments("disable-geolocation");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		cap = cap.merge(DesiredCapabilities.chrome());
		String Browser=prop.getProperty("browsername");
		if(Browser.contains("chrome"))
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aksrana\\Downloads\\driver\\chromedriverlatest.exe"); 
		driver = new ChromeDriver(cap);
		//driver= new ChromeDriver();
		/*
		 * e_driver = new EventFiringWebDriver(driver); // Now create object of
		 * EventListerHandler to register it with EventFiringWebDriver eventListener =
		 * new WebEventListner(); e_driver.register(eventListener); driver = e_driver;
		 */
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.MINUTES);
		driver.get(prop.getProperty("URL"));	
}
	public void closeCookieButton() {
		PageFactory.initElements(driver, this);
		if(closeCookie.isDisplayed())
			closeCookie.click();
	}
}