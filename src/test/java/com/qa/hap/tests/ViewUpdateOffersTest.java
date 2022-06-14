package com.qa.hap.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hap.base.BaseTest;

public class ViewUpdateOffersTest extends BaseTest {

	
	
	
	@BeforeClass
	public void Createoffersetup() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(4000);
	}
	
	@Test
	public void serchViewupdateoffers() throws InterruptedException
	{
		
		
	
		viewupdateoffers.searchOffers();
	}
	
	
	
	
	
	
	
}
