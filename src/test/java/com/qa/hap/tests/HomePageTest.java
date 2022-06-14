package com.qa.hap.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.hap.Constants.Constants;
import com.qa.hap.base.BaseTest;

public class HomePageTest extends BaseTest {

	
	@BeforeClass
	public void beforesetup() {
		homepage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test
	public void HomepageHeaderTest() throws InterruptedException {

		
		Thread.sleep(5000);
	    Assert.assertTrue(homepage.HomepageHeaderVisible());
		//Assert.assertFalse(homepage.HomepageHeaderVisible());
		
	}
	
	@Test
	public void validateLogoutLink() throws InterruptedException
	{
    	Thread.sleep(5000);
		//Assert.assertTrue(homepage.clickonLogout());
	}
	
	@Test
	public void homepageHeadersTest() throws InterruptedException {
		Thread.sleep(5000);
		List<String> headerlist = homepage.getHomepageHeaderList();
		System.out.println("Home Page header sections list: " +headerlist);
		Assert.assertEquals(headerlist, Constants.EXPECTED_HEADERS_SECTION_LIST);
	}
	
	@Test
	public void homepageHeadersHapVideosTest() throws InterruptedException {
		Thread.sleep(7000);
		List<String> headerlist_Hap = homepage.getHomepageHeaderList_Hapvideos();
		System.out.println("Home Page header sections list: " +headerlist_Hap);
		Assert.assertEquals(headerlist_Hap, Constants.EXPECTED_HEADERS_SECTION_HAPVIDEOS);
	}
	
	
	
	
	
	
	
	

}
