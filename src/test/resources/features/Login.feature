Feature: Login
Background:
	Given User is in Login page after clicking signin in home page
	
	  Scenario Outline: User receives an alert while clicks on Login button with "<Username>" and "<Password>"
    When User clicks Login button with "<Username>" and "<Password>"
    Then User User gets an alert "<Message>" appears below Password textbox

    Examples:
      | Username   | Password   		| Message                       |
      |            |            		| Please fill out this field   	|
      | asxcvb     |            		| Please fill out this field    |
      |            | greenHorn@2024 | Please fill out this field    |
      | 14dece     | greenHorn@2024 | Invalid username and password |
      | asxcvb     | numpyninja     | Invalid username and password |
      | 14dece     | numpyninja     | Invalid username and password |

		Scenario: User redirected to Home page while click on Login button with valid credentials
		When User clicks login button with valid User name "asxcvb" and valid password "greenHorn@2024"
		Then User redirected to Data Structure Home Page with message You are logged in
		
		Scenario: User able to see user id after successful login
		When User clicks on login button with valid credentials
		Then User can see the logged in user name
		
		Scenario: User able to see sign out link after successful login
		When User clicks on login button with valid credentials
		Then User can see Sign out link