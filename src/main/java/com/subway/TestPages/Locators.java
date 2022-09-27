package com.subway.TestPages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.subway.base.BaseFunctions;
import com.subway.util.Waits;

public class Locators  extends BaseFunctions{
	Waits waits=new Waits();
	Alert alert;

	@FindBy(xpath="//button[@class='deliverySelectButton']")
	WebElement deliveryBtn;
	
	@FindBy(xpath="//button[@aria-label='Pick Up']")
	WebElement pickUp;
	
	@FindBy(xpath="//button[@aria-label='Filter']")
	WebElement filter;
	
	@FindBy(xpath="//div[@class='filterItems liveFilters']//span[@class='checkmark']")
	List<WebElement> filterBox;
	
	@FindBy(xpath="//input[@type='text' and @name='search']")
	WebElement searchText;
	
	@FindBy(xpath="//button[@class='clearInputButton']")
	WebElement addressClear;
	
	public Locators() {
		PageFactory.initElements(driver, this);
	}
	
	
	public Locators validatepickUpDeliveryBtn() {
		waits.visibiltyOf(deliveryBtn);
		deliveryBtn.click();
		waits.visibiltyOf(pickUp);
		pickUp.click();
		return new Locators();
	}
	
	public Locators validateFilterChckBox() throws InterruptedException {
		waits.visibiltyOf(filter);
		filter.click();
		Thread.sleep(2000);
		for(int i=0;i<filterBox.size();i++) {
			if(filterBox.get(i).isSelected())
			{
				continue;
			}
			else {
				filterBox.get(i).click();
			}
		}
		Thread.sleep(5000);
		log.info("Checkboxes checked");
		return new Locators();
	}
	
	public Locators enterAddress(String add) 
	{
		try {
			waits.visibiltyOf(addressClear);
		addressClear.click();
		log.info("Default address cleared");
		searchText.click();
		searchText.sendKeys(add);
		Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Locators();
	}
	
}
