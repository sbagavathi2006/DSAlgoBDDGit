
Feature: DSAlgoPortal
Background:
	Given User is on the DS Algo Portal
	When User clicks the Get Started button
	
  Scenario: User lands on home page 
    Then User is redirected to home page
         
  Scenario Outline: Validate "<links>" on the home page
  	Then User should see "<links>" on the home page

		Examples:
		  | links              			|
		  | NumpyNinja link     	  |
		  | Register link           |
		  | Sign in link            |
		  | Data structure dropdown |