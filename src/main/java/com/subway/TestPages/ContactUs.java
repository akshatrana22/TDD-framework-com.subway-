package com.subway.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.subway.base.BaseFunctions;
import com.subway.util.Waits;

public class ContactUs extends BaseFunctions{

	Waits waits=new Waits();
	@FindBy(xpath="//input[@value=\"Restaurant Experience\"]")
	WebElement restaurantExp;
	@FindBy(id="btnSubmit")
	WebElement submitForm;
	@FindBy(id="txtFirstName")
	WebElement firstName;
	@FindBy(id="txtLastName")
	WebElement lastName;
	@FindBy(id="txtEmail")
	WebElement email;
	@FindBy(id="txtConfirmEmail")
	WebElement confirmEmail;
	@FindBy(id="v2main_0_insetcontainer_6cfebaeb54424adc88c25050d0487f87_0_txtPhoneNumber")
	WebElement phoneNum;
	@FindBy(id="storeNumber")
	WebElement storeNum;
	@FindBy(id="satelliteNumber")
	WebElement satNum;
	@FindBy(id="txtDateVisit")
	WebElement dateVisit;
	@FindBy(id="ddlVisitTimeHr")
	WebElement visitHr;
	@FindBy(id="ddlVisitTimeMin")
	WebElement visitMin;
	@FindBy(id="ddlVisit_ampm")
	WebElement visitampm;
	@FindBy(id="cs_comments")
	WebElement comments;
	@FindBy(id="ddlState")
	WebElement state;
	@FindBy(id="ddlCountry")
	WebElement country;
		
	public ContactUs() {
		PageFactory.initElements(driver, this);
	}
	
	public ContactUs clickOnRestaurantExp() {
		waits.visibiltyOf(restaurantExp);
		restaurantExp.click();
		waits.visibiltyOf(submitForm);
		System.out.println("Form loaded successfully");
		return new ContactUs();
		
	}
	
	public ContactUs fillForm(String Fname, String Lname, String emailID, String ConfirmemailID,String Phonen,String Countryname,String Statename, String Restaurantnm,String Satellitenum,String Datevisit, String Hourvisit, String Minvisit,String Zone,String Commentsfeed) throws InterruptedException {
		firstName.sendKeys(Fname);
		lastName.sendKeys(Lname);
		email.sendKeys(emailID);
		confirmEmail.sendKeys(ConfirmemailID);
		phoneNum.sendKeys(Phonen);
		Select select=new Select(country);
		select.selectByVisibleText(Countryname);
		Select select1=new Select(state);
		select1.selectByVisibleText(Statename);
		storeNum.sendKeys(Restaurantnm);
		satNum.sendKeys(Satellitenum);
		dateVisit.sendKeys(Datevisit);
		Select select2= new Select(visitHr);
		select2.selectByVisibleText(Hourvisit);
		Select select3= new Select(visitampm);
		select3.selectByVisibleText(Zone);
		Select select4= new Select(visitMin);
		select4.selectByVisibleText(Minvisit);
		comments.sendKeys(Commentsfeed);
		submitForm.click();
		Thread.sleep(5000);
		return new ContactUs();
	}
	
	
}
