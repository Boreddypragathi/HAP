package com.qa.hap.tests;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hap.Constants.Constants;
import com.qa.hap.base.BaseTest;
import com.qa.hap.utils.ElementUtil;
import com.qa.hap.utils.ExcelUtil;

public class CreateOfferTest extends BaseTest {

	@BeforeClass
	public void Createoffersetup() throws InterruptedException {
		homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Thread.sleep(4000);
		createoffer = homepage.clickoncreateoffer();

	}

	@Test(enabled = false)
	public void getCreateOfferPageTitle() {
		String acctitle = createoffer.getCreateOfferPageTitle();
		System.out.println("Actual create offer title is:" + acctitle);
		Assert.assertEquals(acctitle, Constants.CREATE_OFFER_PAGE_TITLE);
	}

	@Test(enabled = false)
	public String getCreteOfferPageUrl() {
		String acturl = createoffer.getCreteOfferPageUrl();
		System.out.println("Actual create offer title is:" + acturl);
		Assert.assertEquals(acturl, Constants.CREATE_OFFER_PAGE_URL);
		return acturl;
	}
	
	@DataProvider
	public Object[][] getCreateOfferTestData() {
		Object createofferdata[][]= ExcelUtil.getTestData(Constants.CREATEOFFER_SHEET_NAME);
	    return createofferdata;
	}
	
	@Test(dataProvider = "getCreateOfferTestData", priority=3)
	public void CreteOfferPageSuccessfully(String candidatename, String gender, String heliusrecruiter,
			String accountmanager, String workcountry,String nationality,String payrollentity,String mobilenumber,
			String personalemail,String relevantitexperienceyears,String relevantitexperiencemonths,
			String totalyearsofexperienceyears,String totalyearsofexperiencemonths,String primaryskills,
			String secondaryskills,String client,String seatlocation)throws InterruptedException {
		 createoffer.createOfferpage(candidatename, gender, heliusrecruiter,accountmanager, workcountry,
				 nationality, payrollentity, mobilenumber, personalemail, relevantitexperienceyears,
				 relevantitexperiencemonths, totalyearsofexperienceyears, totalyearsofexperiencemonths,
				 primaryskills, secondaryskills, client, seatlocation);
		//System.out.println(SuccessMessage);
		
	}	
	
	
	@Test(enabled = false)
	public void serchViewupdateoffers() throws InterruptedException
	{
		viewupdateoffers.searchOffers();
	}
	
	
}
