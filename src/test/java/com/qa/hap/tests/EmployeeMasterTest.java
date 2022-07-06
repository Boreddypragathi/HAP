package com.qa.hap.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hap.Constants.Constants;
import com.qa.hap.base.BaseTest;
import com.qa.hap.utils.ExcelUtil;

public class EmployeeMasterTest extends BaseTest{

	
		@BeforeClass
		public void Createoffersetup() throws InterruptedException {
			homepage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
			Thread.sleep(4000);
			employeemaster = homepage.clickonEmpMaster();
		}
			
			@Test(enabled = false)
			public void getEmployeeCreationPageTitle() 
			{
				String acctitle = employeemaster.getEmployeeCreationPageTitle();
				System.out.println("Employeecreation title is:" + acctitle);
				Assert.assertEquals(acctitle, Constants.CREATE_EMPLOYEE_PAGE_TITLE);
			}

			@Test(enabled = false)
			public String getEmployeeCreationPageUrl() {
				String acturl = employeemaster.getEmployeeCreationPageUrl();
				System.out.println("Actual Employeecreation  URL is:" + acturl);
				Assert.assertEquals(acturl, Constants.CREATE_EMPLOYEE_PAGE_URL);
				return acturl;
			}
			
			@DataProvider
			public Object[][] getEmployeeCreationTestData() {
				Object createofferdata[][]= ExcelUtil.getTestData(Constants.EMPLOYEEMASTER_SHEET_NAME);
			    return createofferdata;
			}
			
			@Test(dataProvider = "getEmployeeCreationTestData")			
		    public void SuccessfulEmployeeCreation(String Offerstatus,String Address1,String city,
						String uploadphoto,String workpass) throws InterruptedException {
			employeemaster.EmployeeMaster(Offerstatus, Address1, city, uploadphoto, workpass);
				
	}

}
