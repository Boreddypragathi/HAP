package com.qa.hap.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

	//these are the custom waits to used thrught out HAP
	public static final int DEFAULT_TIME_OUT = 5;
	public static final int DEFAULT_ELEMENT_TIME_OUT = 10;
	
	
	
	public static final int DEFAULT_ELEMENT_TIME_OUT1 = 0;
	public static final String LOGIN_PAGE_URL_FRACTION = "helius_testing_hapteam/login.html";
	public static final String LOGIN_PAGE_TITLE = "HAP";
	public static final String LOGIN_PAGE_TITLE1 = null; 
	public static final String CREATE_OFFER_PAGE_TITLE = "OFFER DETAILS";
	public static final String CREATE_OFFER_PAGE_URL = null;	
	public static final String HOMEPAGE_HEADER = "HAP - HELIUS APP for PEOPLE";
	public static final String ALERTSUCCESSMESG= "Offer Details Saved Successfully !";
	public static final String ALERTCONFIRMMESG= "Click OK To Submit The Offer Details";
	
	public static final List<String> EXPECTED_HEADERS_SECTION_LIST = Arrays.asList("HAP Videos", "List of Holidays", "Policy Documents");
	public static final List<String> EXPECTED_HEADERS_SECTION_HAPVIDEOS = Arrays.asList("Introduction to HAP", "Offer Creation in HAP");
	public static final String CREATEOFFER_SHEET_NAME = "createoffer";
	//Employee
	public static final String CREATE_EMPLOYEE_PAGE_TITLE = "EMPLOYEE PERSONAL DETAILS";
	public static final String CREATE_EMPLOYEE_PAGE_URL = null;	
	public static final String ALERTCONFIRMATIONMSG="Click OK To Submit The Employee Details";
	public static final String  ALERTSUCCCESSMESSAGE="Employee Details Saved Successfully.!";
	public static final String EMPLOYEEMASTER_SHEET_NAME="employeemaster";

}
