Feature: Login

@Sanity 
Scenario: Successful Login with Valid Credentials
		Given User Lauch chrome browser
		When User opens URL "https://test.csccloud.in:8443/csc-invoice/login"
		And User enters Email as "admin@gmail.com" and Password as "Test@123"
		And Click on Login
		Then Page Title should be "Invoice Management System"
		When User click on Log out link
		Then Page Titel should be "IMS Login"
		And Close browser

@regression
Scenario Outline: Successful Login with Valid Credentials in DDT Data Driven Testing		
		Given User Lauch chrome browser
		When User opens URL "https://test.csccloud.in:8443/csc-invoice/login"
		And User enters Email as "<email>" and Password as "<password>"
		And Click on Login
		Then Page Title should be "Invoice Management System"
		When User click on Log out link
		Then Page Titel should be "IMS Login"
		And Close browser
		
Examples:
		|email					|password| 
		|admin@gmail.com|Test@123|
		|test1@gmail.com|123456	 |
		