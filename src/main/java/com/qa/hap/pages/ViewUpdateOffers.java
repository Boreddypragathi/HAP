package com.qa.hap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.hap.utils.ElementUtil;

public class ViewUpdateOffers {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	private By searchoffer=By.id("query");
	private By createemployee=By.name("createemployee");

	
	public ViewUpdateOffers(WebDriver driver)
	{
		
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	public void searchOffers() throws InterruptedException
	{
		
		eleutil.doMousehoverviewupdateoffers();
		Thread.sleep(10000);
		eleutil.doMousehoverviewupdateoffers();
		
		eleutil.doSendKeys(searchoffer,"jaisri");
		eleutil.doClick(createemployee);
		
		
	}
	
	
}
