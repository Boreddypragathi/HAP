package com.qa.hap.pages;

import java.util.ArrayList;

import java.util.List;

import org.omg.CORBA.DomainManagerOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.hap.Constants.Constants;
import com.qa.hap.utils.ElementUtil;

public class HomePage {
	
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By Homepageheader=By.xpath("//*[@class=\"heading ng-binding\"]");
	private By HomepagehapVideo=By.xpath("//*[contains(text(), ' HAP Videos')]");
	private By HomepageMousehover=By.xpath("//a[contains(text(),'Offer/Employee Master')]");
private By CreateofferLink=By.linkText("Create Offer");
	private By SectionsHeader=By.xpath("(//div[@class='row'])[2]//div/h4");
	private By SectionsHeader_Hapvideos=By.xpath("(//table[@class=\"table table-hover\"])[1]//tbody//tr//td[1]");
	
	private By logoutlink=By.linkText("Log out");
	private By logoutConfirmationText=By.xpath("//div[contains(text(),'Successfully logged out')]");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		eleutil=new ElementUtil(driver);
	}
	
	public boolean HomepageHeaderVisible() {
		return eleutil.doIsDisplayed(Homepageheader);
	}
	
	public List<String> getHomepageHeaderList() {
		List<WebElement> HeadList= eleutil.getElements(SectionsHeader);
		List<String> headValList = new ArrayList<String>();
		for(WebElement e : HeadList) {
			String text = e.getText();
			headValList.add(text);
		}
		return headValList;
	}
	
	public List<String> getHomepageHeaderList_Hapvideos() {
		List<WebElement> HeadList= eleutil.getElements(SectionsHeader_Hapvideos);
		List<String> headValList = new ArrayList<String>();
		for(WebElement e : HeadList) {
			String text = e.getText();
			headValList.add(text);
		}
		return headValList;
	}
	
	public boolean isLogoutExist() throws InterruptedException {
		Thread.sleep(5000);
		eleutil.doMousehover();
		
		return eleutil.waitForElementVisible(logoutlink, Constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed();
		
	}
	
	
	
//	public boolean clickonLogout() throws InterruptedException {
//		if(isLogoutExist()) {
//			Thread.sleep(5000);
//			eleutil.doClick(logoutlink);
//			}
//		return eleutil.waitForElementVisible(logoutConfirmationText, Constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed();
		
	//}
	public CreateOffer clickoncreateoffer() throws InterruptedException {
		
		Thread.sleep(5000);
		eleutil.doMousehover();
		Thread.sleep(5000);
		//eleutil.doClick(CreateofferLink);
		
	return new CreateOffer(driver);
	}
	
}


