package com.qa.hap.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hap.Constants.Constants;
import com.qa.hap.base.BaseTest;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String acctitle=loginpage.getLoginPageTitle();
		System.out.println("login page title:"+acctitle);
		Assert.assertEquals(acctitle,Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void getLoginPageUrl()
	{
		String accurl=loginpage.getloginPageUrl();
		System.out.println("login page URL:"+accurl);
		Assert.assertEquals(accurl,Constants.LOGIN_PAGE_URL_FRACTION);
		
	}
	@Test(priority=3)
	public void isForgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
//	@Test(priority=4)
//	public void loginTest() throws InterruptedException
//	{
//	Assert.assertTrue(loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
//
//	}
}
