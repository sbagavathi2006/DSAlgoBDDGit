
Feature: Register

Background: 
    Given user is in Register page after clicking register in home page  
    
Scenario: verify user is able to navigate to login page	
    When user enters login button on registration page
    Then user should redirected to login page	

 Scenario Outline: User get message when Register with different combination of credentials based on "<validation>"
    When User clicks Register button with username and password and confirm password for validation "<validation>"
    Then User gets corresponding messages for register validation "<validation>"
		Examples:
      |  validation				|
      |  EmptyUsername    |
      |  EmptyPassword    |
      |  EmptyConfirmPassword  |
      |  MismatchPassword |
      |  ShortPassword    |
      |  NumaricPassword  |
      
      
  Scenario Outline: User able to see user id after successful Register
		When User clicks on register button with valid credentials "<validation>"
		Then User can see the register logged in user name for valid credentials "<validation>"
		
		Examples:
      |  validation				|
      |  ValidCredential  |  
      
  Scenario Outline: User able to see home page after successful Register
		When User clicks on register button with valid credentials "<validation>"
		Then user should be redirected to Home Page
		
		Examples:
      |  validation				|
      |  ValidCredential  |  
    