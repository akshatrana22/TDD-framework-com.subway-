package com.subway.TestPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.subway.base.BaseFunctions;
import com.subway.util.Waits;

public class UserProfile extends BaseFunctions{
Waits waits= new Waits();
@FindBy(id="signInName")
WebElement emailField;

@FindBy(id="password")
WebElement password;

@FindBy(id="next")
WebElement signIn;
@FindBy(xpath="//a[@class='button start_order']")
WebElement startOrder;

	public UserProfile() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage verifySignIn(String email, String pass) throws InterruptedException {
		waits.visibiltyOf(emailField);
		emailField.sendKeys(email);
		waits.visibiltyOf(password);
		password.sendKeys(pass);
		signIn.click();
		waits.visibiltyOf(startOrder);
		return new HomePage();
	}
}
