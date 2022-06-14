package com.qa.hap.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.hap.factory.Driverfactory;
import com.qa.hap.pages.CreateOffer;
import com.qa.hap.pages.HomePage;
import com.qa.hap.pages.LoginPage;
import com.qa.hap.pages.ViewUpdateOffers;

public class BaseTest {
public Driverfactory df;
public WebDriver driver;
protected LoginPage loginpage;
protected CreateOffer createoffer;
protected HomePage homepage;
protected ViewUpdateOffers viewupdateoffers;
public Properties prop;

	
	@BeforeTest
	
		public void setup()
		{
			df=new Driverfactory();
		prop=df.init_prop();
			driver= df.init_driver(prop);
			loginpage=new LoginPage(driver);
			homepage = new HomePage(driver);
			createoffer=new CreateOffer(driver);
			viewupdateoffers=new ViewUpdateOffers(driver);
		}
	
@AfterTest
public void tearDown()
	{
		
	//driver.quit();
	}		
	
	
	}

