package com.qa.hap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.hap.Constants.Constants;
import com.qa.hap.utils.ElementUtil;

public class CreateOffer {
	private WebDriver driver;
	private ElementUtil eleutil;

	
	private By OfferMadeOnCalender = By.xpath("//button[@ng-click='isDatepickerOpen = !isDatepickerOpen']");
	private By OfferMadeOnCalenderToday = By.xpath("//button[@class='btn btn-sm btn-info uib-datepicker-current ng-binding']");
	private By DOBCalender = By.xpath("//button[@ng-click='isDatepicker = !isDatepicker']");
	private By DOBCalenderMonthYear = By.xpath("//button[@class='btn btn-default btn-sm uib-title']//strong");
	private By DOBCalenderMonthYearLeftArrow = By.xpath("//button[@class='btn btn-default btn-sm pull-left uib-left']");
	private By viewupdateoffers=By.xpath("//a[contains(text(),'Offer/Employee Master')]");
	
	
	
	private By CandidateName = By.id("employee_name");
	private By Gender = By.id("gender");
	//private By DateofBirth = By.name("dateofbirth");
	private By HeliusRecruiter = By.id("recruiter");
	private By AccountManager = By.name("accountmanager");
	private By WorkCountry = By.name("workcountry");
	private By Currency = By.name("currencyname");
	private By Nationality = By.name("nationality");
	private By PayrollEntity = By.name("payrollentity");
	private By ExpectedDOJ = By.xpath("(//span[@class=\"input-group-btn\"])[3]//button");
	//private By ExpectedDateofJoining = By.name("edoj");
	private By MobileNumber = By.id("mobile");
	private By PersonalEmail = By.id("email1");
	private By RelevantITExperienceYears = By.name("relevantyears");
	private By RelevantITExperienceMonths = By.name("relevantmonths");
	private By TotalYearsofExperienceYears = By.name("totalyears");
	private By TotalYearsofExperienceMonths = By.name("totalmonths");
	private By PrimarySkills = By.id("primaryskills");
	private By SecondarySkills = By.id("secondaryskills");
	private By Client = By.name("client");
	private By Submitoffer = By.id("submit");
	private By SeatLocation = By.id("seatingloc");
	
	private By searchoffer=By.id("query");
	private By createemployee=By.name("createemployee");
	
	private By ViewUpdateofferLink=By.linkText("View/Update Offers");
	
	public CreateOffer(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	public void dummyCreateOfferpage() throws InterruptedException {
		Thread.sleep(5000);
		eleutil.selectDate();
	}
	public void createOfferpage(String name, String gender, String heliusrecruiter,String accountmanager,String	workcountry,String nationality,String payrollentity,String mobilenumber,String personalemail,String relevantitexperienceyears,String relevantitexperiencemonths,String totalyearsofexperienceyears,String totalyearsofexperiencemonths,String	primaryskills,String secondaryskills,String	client,String seatlocation) throws InterruptedException {
		Thread.sleep(5000);
		//eleutil.doSendKeys(OfferMadeon, "06/06/2022");
		eleutil.doClick(OfferMadeOnCalender);
		eleutil.doClick(OfferMadeOnCalenderToday);
		String offercreatedname = eleutil.doSendKeys(CandidateName, name);
		eleutil.selectDropDownByVisible(Gender, gender);
		//eleutil.doSendKeys(DateofBirth, "14/12/1989");
        eleutil.selectDate();
		eleutil.selectDropDownByVisible(HeliusRecruiter, heliusrecruiter);
		eleutil.selectDropDownByVisible(AccountManager, accountmanager);
		eleutil.selectDropDownByVisible(WorkCountry, workcountry);
		// eleutil.doSendKeys(Currency, "India");
		eleutil.selectDropDownByVisible(Nationality, nationality);
		eleutil.selectDropDownByVisible(PayrollEntity, payrollentity);
		//eleutil.doSendKeys(ExpectedDateofJoining, "06/06/1989");
		eleutil.doClick(ExpectedDOJ);
		eleutil.doClick(OfferMadeOnCalenderToday);
		eleutil.doSendKeys(MobileNumber, mobilenumber);
		eleutil.doSendKeys(PersonalEmail, personalemail);
		eleutil.selectDropDownByVisible(RelevantITExperienceYears, relevantitexperienceyears);
		eleutil.selectDropDownByVisible(RelevantITExperienceMonths, relevantitexperiencemonths);
		eleutil.selectDropDownByVisible(TotalYearsofExperienceYears, totalyearsofexperienceyears);
		eleutil.selectDropDownByVisible(TotalYearsofExperienceMonths, totalyearsofexperiencemonths);
		eleutil.doSendKeys(PrimarySkills, primaryskills);
		eleutil.doSendKeys(SecondarySkills, secondaryskills);
		eleutil.selectDropDownByVisible(Client, client);
		eleutil.doSendKeys(SeatLocation, seatlocation);
		eleutil.doClick(Submitoffer);
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
        eleutil.doSendKeys(searchoffer, offercreatedname);
        
        if(eleutil.waitForElementVisible(createemployee, Constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed()) {
        	//return eleutil.waitForElementVisible(createemployee, Constants.DEFAULT_ELEMENT_TIME_OUT).isDisplayed();
        	
        }
        eleutil.doMousehover();
        
        //return alertsuccessmesg;
	}
	
	public void createOfferpageDummy(String candidatename, String gender) {
		eleutil.doClick(OfferMadeOnCalender);
		eleutil.doClick(OfferMadeOnCalenderToday);
		eleutil.doSendKeys(CandidateName, candidatename);
		eleutil.selectDropDownByVisible(Gender, gender);
	}

	public static String[] getMonthyear(String Monthyearval) {
		return Monthyearval.split("");
	}

	
	public String getCreateOfferPageTitle() {
		return eleutil.waitForTitleIs(Constants.CREATE_OFFER_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	public String getCreteOfferPageUrl() {
		return eleutil.waitForUrlIs(Constants.CREATE_OFFER_PAGE_URL, Constants.DEFAULT_TIME_OUT);
	}

}
