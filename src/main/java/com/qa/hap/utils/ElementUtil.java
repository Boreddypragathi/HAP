package com.qa.hap.utils;


import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {
		By locator = null;
		switch (locatorType.toLowerCase()) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "classname":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "css":
			locator = By.cssSelector(locatorValue);
			break;
		case "linktext":
			locator = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;

		default:
			break;
		}

		return locator;

	}

	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public String doAlertGetText() {
		return driver.switchTo().alert().getText();
		
	}
	public void doAlertAccept() {
		driver.switchTo().alert().accept();
				
	}
	public String getCurrency(String Countryname)
	{
		//By locator = null;
	    String Currencyvalue = null;
		   //  String Country=null;
			switch (Countryname) {
			case "India":
				Currencyvalue = driver.findElement(By.name("currencyname")).getText();
				break;
			case "Singapore":
				Currencyvalue = driver.findElement(By.name("currencyname")).getText();
				break;
			case "Thailand":
				Currencyvalue = driver.findElement(By.name("currencyname")).getText();
				break;
			case "Vietnam":
				Currencyvalue = driver.findElement(By.name("currencyname")).getText();
				break;
			case "Philippines":
				Currencyvalue = driver.findElement(By.name("currencyname")).getText();
				break;
			
			default:
				
			}
			return Currencyvalue;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List getElements(By locator) {
		return driver.findElements(locator);
	}

	public String doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
		return value;
	}

	public String waitForTitleIs(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.titleIs(title))) {
			return driver.getTitle();
		}
		return null;
	}

	public String waitForUrlContains(String urlFraction, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
			return driver.getCurrentUrl();
		}
		return null;
	}

	public String waitForUrlIs(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		if (wait.until(ExpectedConditions.urlToBe(url))) {
			return driver.getCurrentUrl();
		}
		return null;

	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	

	public void doMousehover() {
		
		WebElement menumouseover=driver.findElement(By.xpath("//a[contains(text(),'Offer/Employee Master')]"));
		 // Actions act=new Actions(driver);
		// act.moveToElement(menumouseover).click().perform();
		 //getElement(locator).isDisplayed();
		//WebElement menumouseover=driver.findElement(By.xpath("*[@id=\"myDiv\"]/li[6]/a"));
		 Actions act=new Actions(driver);
	     act.moveToElement(menumouseover).click().perform();
	     driver.findElement(By.linkText("Create Offer")).click();
	   
	}
public void doMousehoverviewupdateoffers() throws InterruptedException {
		
		WebElement menumouseover1=driver.findElement(By.xpath("//a[contains(text(),'Offer/Employee Master')]"));
		 // Actions act=new Actions(driver);
		// act.moveToElement(menumouseover).click().perform();
		 //getElement(locator).isDisplayed();
		//WebElement menumouseover=driver.findElement(By.xpath("*[@id=\"myDiv\"]/li[6]/a"));
		 Actions act=new Actions(driver);
	     act.moveToElement(menumouseover1).click().perform();
	     driver.findElement(By.linkText("View/Update Offers")).click();
	     Thread.sleep(30000);
}

	public void selectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void selectDropDownByVisible(By locator, String visibleText) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibleText);
	}

	public void selectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	public int getDropDownValuesCount(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions().size();
	}

	public void dropDownSelectValueWithGetOptions(By locator, String value) {
		Select select = new Select(getElement(locator));
		List<WebElement> optionsList = select.getOptions();

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	

	public void dropDownValueUsingLocator(By locator, String value) {
		List<WebElement> list = getElements(locator);
		for (WebElement e : list) {
			String text = e.getText();
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
	
	public void selectDate() {
		
		//selectDate(String day, String Month, String Year)
		driver.findElement(By.xpath("//button[@ng-click='isDatepicker = !isDatepicker']")).click();;
		String Monthyearval = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm uib-title']//strong")).getText();
		System.out.println(Monthyearval);
		String month = Monthyearval.split(" ")[0].trim();
		String year = Monthyearval.split(" ")[1].trim();
		
		while(!(month.equals("May") && year.equals("2001"))) {
			driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm pull-left uib-left']")).click();
			
			 Monthyearval = driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm uib-title']//strong")).getText();
			//System.out.println(Monthyearval);
			 month = Monthyearval.split(" ")[0].trim();
			 year = Monthyearval.split(" ")[1].trim();			
		}
		
		driver.findElement(By.xpath("(//span[contains(text(),'01')])[1]")).click();
		
		/*while (!(getMonthyear(Monthyearval)[0].equals(Month) && getMonthyear(Monthyearval)[0].equals(Year)))
			;
		{
			driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-chevron-right']")).click();
			Monthyearval = driver.findElement(By.className("offermadeon")).gettext();

		}*/

	}

}
