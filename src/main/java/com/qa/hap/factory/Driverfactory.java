package com.qa.hap.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;

import com.qa.hap.Exceptions.FrameworkException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
WebDriver driver;
Properties prop;		


public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
public WebDriver init_driver(Properties prop )
{
	String browserName = System.getProperty("browser");
	//String browserName = "chrome";
	System.out.println("Browser name is:"+browserName);
	
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.chromedriver.setup();
		//driver=new ChromeDriver();
		tlDriver.set(new ChromeDriver());
	}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();
		tlDriver.set(new FirefoxDriver());
	}
	else if(browserName.equalsIgnoreCase("safari"))
	{
		WebDriverManager.safaridriver().setup();
		//driver=new SafariDriver();
		tlDriver.set(new SafariDriver());
	}
	else if(browserName.equalsIgnoreCase("edge"))
	{
		WebDriverManager.edgedriver().setup();
		//driver=new SafariDriver();
		tlDriver.set(new EdgeDriver());
	}
	else
	{
		System.out.println("Please pass the right browser:"+browserName);
	}
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
	getDriver().get(prop.getProperty("url").trim());
	return getDriver();
}


public static WebDriver getDriver() {
	return tlDriver.get();
}



public Properties init_prop()//this method is used to initialise the properies
{
	prop=new Properties();
	FileInputStream ip=null;
	
	//mvn clean install -Denv="qa"
	String envName = System.getProperty("env");
	//String envName = "qa";
	System.out.println("Running test cases on Environment: " +envName);
	
	if (envName == null) {
		System.out.println("No env is given....hence running it on QA enviornment");
		try {
			ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	else {
		try {
			switch (envName.toLowerCase()) {
			case "qa":
				System.out.println("running it on QA env");
				ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
				break;
			case "stage":
				System.out.println("running it on stage env");
				ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
				break;
			case "dev":
				System.out.println("running it on dev env");
				ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
				break;
			case "uat":
				System.out.println("running it on uat env");
				ip = new FileInputStream("./src/test/resources/config/uat.config.properties");
				break;
			case "prod":
				System.out.println("running it on QA env");
				ip = new FileInputStream("./src/test/resources/config/prod.config.properties");
				break;

			default:
				System.out.println("Please pass the right environment...." + envName);
				throw new FrameworkException("No env is found exception....");
				//break;
			}

		} catch (Exception e) {

		}

	}

	try {
		prop.load(ip);
	} catch (IOException e) {
		e.printStackTrace();
	}

	return prop;
}



public String getScreenshot() {
	
	File srcFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
	String path = "./" + "screenshot/" + System.currentTimeMillis() + ".png";
	File destination = new File(path);
	try {
		FileUtils.copyFile(srcFile, destination);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return path;
}


}
