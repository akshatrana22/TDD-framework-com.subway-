package com.subway;

import org.testng.annotations.Test;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.subway.TestData.DataDriven;
import com.subway.TestPages.ContactUs;
import com.subway.TestPages.HomePage;
import com.subway.TestPages.Locators;
import com.subway.TestPages.UserProfile;
import com.subway.base.BaseFunctions;
import com.subway.util.RetryAnalyzer;
import com.subway.util.Waits;

public class HomePageTest extends BaseFunctions {
	HomePage HomePage;
	Locators locators;
	UserProfile userprofile;
	ContactUs contactUs;
	String sheetName="Signin";	
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialize();
		closeCookieButton();
		HomePage=new HomePage();
		locators=new Locators();
		userprofile=new UserProfile();
		contactUs=new ContactUs();
	}
	
	@Test(priority=1)
	public void validationsOnHomePage() throws Exception {
		HomePage.verifyNavbar_items();
		locators=HomePage.verifyStartOrder();
		HomePage.verifyredirectionToHomePage();
		userprofile=HomePage.verifySignInisFunctional();
		HomePage.verifyredirectionToHomePage()
		.selectFooterItem("History");
												
	}
	@Test(priority=2)
	public void locatorFunctionalities() throws InterruptedException {
		
		locators=HomePage.verifyStartOrder()
				.validatepickUpDeliveryBtn()
				.validateFilterChckBox()
				.enterAddress("Milford, CT, USA");
		
	}
	
	
	@DataProvider
	public Object[][] getTestData(){
		Object data[][] = DataDriven.getTestData(sheetName);
		return data;
	}
	@Test(priority=3,dataProvider="getTestData")
	public void signin(String Email, String Password) throws InterruptedException {
		userprofile=HomePage.verifySignInisFunctional();
		HomePage=userprofile.verifySignIn(Email, Password);
	}

	@AfterMethod
	public void burndown() {
		driver.quit();
	}
}