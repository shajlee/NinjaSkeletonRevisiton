package com.ninja.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninja.testbase.Ninja_Base;

public class Ninja_Landing extends Ninja_Base {
	public Ninja_Landing() throws Exception {
		super();
		
	}

	public static WebDriver driver;
	public static SoftAssert softassert = new SoftAssert();
	
	@BeforeMethod
	public void setUp() {
		driver = initializeAndLaunchBrowser(prop.getProperty("browser1"));
	}
	@Test
	public void presenceOfQAFoxLink() {
		WebElement QAFoxLink = driver.findElement(By.linkText("Qafox.com"));
		softassert.assertTrue(QAFoxLink.isDisplayed());
		
		WebElement FeatureProductDisplay = driver.findElement(By.linkText("MacBook"));
		softassert.assertTrue(FeatureProductDisplay.isDisplayed());
		
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	
		
		
		
	}

}
