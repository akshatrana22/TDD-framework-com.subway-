package com.subway.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.subway.base.BaseFunctions;

public class Waits extends BaseFunctions{

WebDriverWait wait = new WebDriverWait(driver,20);
public void visibiltyOf(WebElement element) {
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void invisibilityOf(WebElement element) {
	wait.until(ExpectedConditions.invisibilityOf(element));
}

public void clickablityOf(WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));
}


public void scrollToViewElement(WebElement element) {
	JavascriptExecutor je = (JavascriptExecutor) driver;
	je.executeScript("arguments[0].scrollIntoView(true);",element);
}

public void scrollToBottomOfPage(WebElement element) {
	JavascriptExecutor je=(JavascriptExecutor)driver;
	je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
}

public static void takeSnapShot() throws IOException{
	File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String currentDir = System.getProperty("user.dir");
	FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
}
public static void hightLightExceptionArea(WebElement element) {
	try {
		Waits.takeSnapShot();
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(
            "arguments[0].style.border = '3px solid red'",
            element);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}


