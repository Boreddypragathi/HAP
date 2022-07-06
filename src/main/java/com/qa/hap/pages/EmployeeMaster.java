package com.qa.hap.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WrapsDriver;

import com.qa.hap.Constants.Constants;
import com.qa.hap.utils.ElementUtil;
import org.openqa.selenium.support.ui.Select;

public class EmployeeMaster {
	private WebDriver driver;
	private ElementUtil eleutil;
	
	private By offeremployeedropdownopening=By.xpath("//a[contains(text(),'Offer/Employee Master')]");
	private By ViewUpdateofferLink=By.linkText("View/Update Offers");
	private By offerstatus=By.xpath("//select[@ng-model='offer_status']");
	private By CreateEmployee=By.xpath("//input[@name='createemployee'and @value='Create Employee'])[last()-8]");
	private By Actualdateofjoining=By.xpath("//button[@name=\"actualdateofjoiningbtn\"]//i");
	private By Todaydateadoj=By.xpath("/button[@ng-click=\"select('today', $event)\"]");
	private By generateemployeeid=By.xpath("//button[@ng-click=\"generateemp()\"]");
	private By address1=By.xpath("//input[@id=\"address_line1\" and @name=\"cAddress1\"]");
	private By City=By.xpath("//input[@id=\"city\" and @name=\"cCity\"]");
	private By Uploadphoto=By.xpath("//input[@type=\"file\" and @name=\"uploadphoto\"]");
	private By Personalnext=By.xpath("//input[@type=\"submit\" and @name=\"personalnext\"]");
	private By Workpass=By.xpath("//select[@data-msg-required=\"Please select Work Pass\"][1]");
	private By Workpassnext=By.xpath("//input[@name=\"workpassnext\"]");
	private By Sowstartdate=By.xpath("//button[@name='sowstartbtn']");
	private By Sowstartdatetoday=By.xpath("/button[@type='button' and text()='Today']");
	private By Sowenddate=By.xpath("select sow end date");
	private By Assignnext=By.xpath("//input[@name=\"assignnext\"]");
	private By Clickonclientleavepolicy=By.xpath("//input[@ng-click=\"generateleaves()\"]");
	private By Leavenext=By.xpath("//input[@name=\"leavenext\"]");
	private By Banknext=By.xpath("//input[@name=\"banknext\"]");
	private By Clickonsubmit=By.xpath("//input[@id=\"submit\"]");

	
	public EmployeeMaster(WebDriver driver)
	{
		// TODO Auto-generated constructor stub

		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	
	public void EmployeeMaster(String Offerstatus,String Address1,String city,String uploadphoto,String workpass) throws InterruptedException
	{
		eleutil.selectDropDownByValue(offerstatus, Offerstatus);
		eleutil.doClick(CreateEmployee);
		eleutil.doClick(Actualdateofjoining);
		eleutil.doClick(Todaydateadoj);
		eleutil.doClick(generateemployeeid);
		eleutil.doSendKeys(address1,Address1);
		eleutil.selectDropDownByValue(City,city);
		eleutil.doClick(Uploadphoto);
		eleutil.doClick(Personalnext);
		eleutil.selectDropDownByValue(Workpass,workpass);
		eleutil.doClick(Workpassnext);
		eleutil.doClick(Sowstartdate);
		eleutil.doClick(Sowstartdatetoday);
		eleutil.doClick(Sowenddate);
		eleutil.doClick(Assignnext);
		eleutil.doClick(Clickonclientleavepolicy);
		eleutil.doClick(Leavenext);
		eleutil.doClick(Banknext);
		eleutil.doClick(Clickonsubmit);
		Thread.sleep(5000);
		String alertconfirmmesg = eleutil.doAlertGetText();
		System.out.println(alertconfirmmesg);
		eleutil.doAlertAccept();
		Thread.sleep(4000);
		String alertsuccessmesg = eleutil.doAlertGetText();
		System.out.println(alertsuccessmesg);
		eleutil.doAlertAccept();
     
       Thread.sleep(4000);
       eleutil.doMousehoverviewupdateoffers();
	}
	public String getEmployeeCreationPageTitle() {
		return eleutil.waitForTitleIs(Constants.CREATE_EMPLOYEE_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getEmployeeCreationPageUrl() {
		return eleutil.waitForUrlIs(Constants.CREATE_EMPLOYEE_PAGE_URL, Constants.DEFAULT_TIME_OUT);
	}
		
		
}