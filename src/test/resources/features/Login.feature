
Feature: Login
Background:
	Given User is in Login page after clicking signin in home page
	
	 Scenario Outline: User get message when login with different combination of credentials based on "<validation>"
    When User clicks Login button with username and password for validation "<validation>"
    Then User gets corresponding messages for validation "<validation>" 

		Examples:
      |  validation				|
      |  ValidCredential  |      
      |  WrongUserName    |
      |  WrongPwd         |
      |  EmptyPwd  				|
      |  EmptyUserName    |
		
	Scenario Outline: User able to see user id after successful login
		When User clicks on login button with valid credentials "<validation>"
		Then User can see the logged in user name for valid credentials "<validation>"
		
		Examples:
      |  validation				|
      |  ValidCredential  |  
		
	Scenario Outline: User able to see sign out link after successful login
		When User clicks on login button with valid credentials "<validation>"
		Then User can see Sign out link
		
		Examples:
      |  validation				|
      |  ValidCredential  |  