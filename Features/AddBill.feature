Feature: Bill

Background: Common steps for all scenarios
		Given User Lauch chrome browser
		When User opens URL "https://test.csccloud.in:8443/csc-invoice/login"
		And User enters Email as "admin@gmail.com" and Password as "Test@123"
		And Click on Login
		Then User can view Dashboard
		And Click on Bills


@regression
Scenario: Add Bill
		
		And Click on Add Bills
		Then User can view Fill Details page under Add Bills as "Fill Details"
		When User enter bill info
		And Click on Next button
		Then User can view pop-up window form as "Review Details"
		And User click on Submit button
		And User click on Edit button
		Then User can view confirmation Success message1 as "Details Submitted Successfully !"
		#Then User can view confirmation not Success message2 as "e-office Receipt Number Already Added!!!"
		And Close browser

@Sanity
Scenario: Search Bill by Receipt Number
		
		And Click on View & Update Bills
		And Enter Receipt Number
		When Click on Search button
		Then User should found Receipt Number in the Search table
		And Close browser

@Sanity		
Scenario: Search Bill by Department Name
		
		And Click on View & Update Bills
		And Select department name from dropdown menu
		And Select status of bill from dropdown menu as "In-Process"
		When Click on Search button
		Then User should found Name in the search table
		And Close browser
		

