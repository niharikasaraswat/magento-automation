Feature: Login Functionality for E-Commerce Website

	As a user of the website
	I want to be able to log in with my account
	So that I can access my account related features and manage my orders
	
	Background:
		Given I am on the Magento login page
	 
  Scenario: Login with valid credentials
    Given I am on the Magento login page
    When I enter valid login credentials
    Then I should be logged into the account successfully
    
	Scenario Outline: Unsuccessfull login with invalid or empty credentials
		Given I have entered invalid "<email>" and "<password>"
		When I click on the login button
		Then I should see an error message indicating "The account sign-in was incorrect"
		
		
	Examples:
  | email                          | password         | error_message                             |
  | invalid@email.com              | invalidPassword  | Warning: The account sign-in was incorrect         |
  | aaa                            | validPassword    | Warning: The account sign-in was incorrect |
  | niharikasaraswat442@gmail.com | Niharika@123     |  |
   

	Scenario: Navigating to forgotten password page
		When I click on the "Forgot Your Password?" link
		Then I should be redirected to the password reset page

    
