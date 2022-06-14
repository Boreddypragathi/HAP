	package com.qa.hap.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hap.Constants.Constants;
import com.qa.hap.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	private By id=By.id("username");
	private By password=By.id("password");
	private By loginBtn=By.xpath("//button[@type='submit']");
	private By forgotpassword=By.linkText("password?");
	private By forgotpassword1=By.linkText("password?");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleutil=new ElementUtil(driver);
	}
	
	public String  getLoginPageTitle()
	{
	return eleutil.waitForTitleIs(Constants.LOGIN_PAGE_TITLE,Constants.DEFAULT_ELEMENT_TIME_OUT);
	}
	public  String getloginPageUrl()
	{
		return eleutil.waitForUrlContains(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIME_OUT);
	}
	public HomePage doLogin(String un, String pwd)
	{
		System.out.println("login credentials are:"+ un +":"+pwd );
		
		eleutil.waitForElementVisible(id,Constants.DEFAULT_TIME_OUT).sendKeys(un);
		
		eleutil.doSendKeys(password,pwd);
		eleutil.doClick(loginBtn);
		return new HomePage(driver);
		
	}
	public boolean isForgotPwdLinkExist() {
		return eleutil.doIsDisplayed(forgotpassword);
	}
}
