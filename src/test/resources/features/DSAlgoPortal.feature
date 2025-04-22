
@DSAlgoPortal
Feature: DSAlgoPortal

Background:
	Given User is on the DS Algo Portal
	When User clicks the Get Started button
	
  Scenario: User lands on home page 
    Then User is redirected to home page
         
  Scenario Outline: Validate "<links>" links
  	Then User should see "<links>" links

		Examples:
		  | links          |
		  | NumpyNinja 	   |
		  | Register       |
		  | Sign in        |
		  | Data Structures|