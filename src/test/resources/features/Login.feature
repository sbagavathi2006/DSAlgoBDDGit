@Login
Feature: Login
Background:
	Given User is in Login page after clicking signin in home page
	
	 Scenario Outline: User Login with multiple invalid test data from excel
    When User clicks Login button for row <rowNum>
    Then User gets an alert or error message for row <rowNum>

   Examples:
      | rowNum |
      | 1      |
      | 2      |
      | 3      |
      | 4      |
      | 5      |

		Scenario: User redirected to Home page while click on Login button with valid credentials
		When User clicks on login button with valid credentials
		Then User redirected to Data Structure Home Page with message You are logged in
		
		Scenario: User able to see user id after successful login
		When User clicks on login button with valid credentials
		Then User can see the logged in user name
		
		Scenario: User able to see sign out link after successful login
		When User clicks on login button with valid credentials
		Then User can see Sign out link