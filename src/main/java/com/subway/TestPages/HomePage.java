package com.subway.TestPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.subway.base.BaseFunctions;
import com.subway.util.Waits;

public class HomePage extends BaseFunctions {
Waits waits = new Waits();
@FindBy(xpath="//div[@class='navbar_menu_items']//descendant::li//a")
List<WebElement>navList;

@FindBy(xpath="//div[@class='navbar_right']//a[contains(@class,'button')]")
List<WebElement>navRightList;

@FindBy(xpath="//li[@class='footer_link']//a")
List<WebElement>footLink;

@FindBy(xpath="//a[@class='button start_order']")
WebElement startOrder;

@FindBy(xpath="//button[@aria-label='Filter']")
WebElement filter;

@FindBy(xpath="//a[@class='account_logged']")
WebElement signIn;

@FindBy(id="next")
WebElement SigninButton;

@FindBy(xpath="//a[@title=\"Contact Us\"]")
WebElement contactUs;

public String chkSelectShop = "//div[@class='footer_main_item']//a[contains(text(),'replaceit')]";


 public void selectFooterItem(String footerItem) throws Exception
 { 
	// return createComponent(WebElement.class, By.xpath(chkSelectShop.replace("replaceit", footerItem)),"chkSelectShop");
	 driver.findElement(By.xpath(chkSelectShop.replace("replaceit", footerItem))).click();
	 Thread.sleep(5000);
	 
}

public HomePage() {
	PageFactory.initElements(driver, this);
}
SoftAssert ass= new SoftAssert();
public  void verifyNavbar_items()  {
	int i;

	for(i=0;i<navList.size();i++)
	{
		if(navList.get(i).getText().contains("MENU"))
		{
			ass.assertTrue(navList.get(i).getText().equalsIgnoreCase("MENU"), null);
			log.info(navList.get(i).getText()+"is present");
		}
		else if(navList.get(i).getText().contains("FIND A SUBWAY"))
		{
			ass.assertTrue(navList.get(i).getText().equalsIgnoreCase("FIND A SUBWAY"), null);
			log.info(navList.get(i).getText()+"is present");
		}
		else if(navList.get(i).getText().contains("REWARDS & DEALS"))
		{
			ass.assertTrue(navList.get(i).getText().equalsIgnoreCase("REWARDS & DEALS"), null);
			log.info(navList.get(i).getText()+"is present");
		}
		else if(navList.get(i).getText().contains("GIFT CARDS"))
		{
		
			ass.assertTrue(navList.get(i).getText().equalsIgnoreCase("GIFT CARDS"), null);
			log.info(navList.get(i).getText()+"is present");
		}
		else if(navList.get(i).getText().contains("CATERING"))
		{
		
			ass.assertTrue(navList.get(i).getText().equalsIgnoreCase("CATERING"), null);
			log.info(navList.get(i).getText()+"is present");
		}
	}
	ass.assertAll();
}

public Locators verifyStartOrder() {
	waits.visibiltyOf(startOrder);
	startOrder.click();
	log.info("Clicked on Start order");
	waits.visibiltyOf(filter);
	Assert.assertTrue(filter.isDisplayed());
	log.info("Filter displayed");
	return new Locators();
	
}

public UserProfile verifySignInisFunctional() {
	waits.visibiltyOf(signIn);
	signIn.click();
	waits.visibiltyOf(SigninButton);
	log.info("User navigated to Signin Page");
	return new UserProfile();
}

public HomePage verifyredirectionToHomePage() {
	driver.get(prop.getProperty("URL"));
	waits.visibiltyOf(startOrder);
	log.info("Redirection to homepage successful");
	return new HomePage();
}

public ContactUs clickOnContactUs() throws InterruptedException {
	waits.scrollToViewElement(contactUs);
	contactUs.click();
	log.info("Clicked successfully");
	return new ContactUs();
}

}

