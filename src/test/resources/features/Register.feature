
Feature: Register

Background: 
    Given user is in Register page after clicking register in home page  
 
 Scenario: verify user will able to see alert when required fields blank
	When user name and passsword filed will be empty and then click on register
  Then user see the error message "please fill out this field." appears below the Username textbox
    
 Scenario Outline: Verify that user receives error message for empty Password field during registration
  When the user enters a Username "<Username>" leaves the Password "<Password>" and Confirm Password "<ConfirmPassword>" fields empty and clicks the Register button
  Then the error message "<ErrorMessage>" appears below the Password textbox

 Examples:
  | Username  | Password | ConfirmPassword | ErrorMessage                |
  | testuser1 |          |                 | Please fill out this field. |
 
 Scenario: verify user is able to navigate to login page	
    When user enters login button on registration page
    Then user should redirected to login page	

  Scenario Outline: Verify error message when passwords mismatch
    When the user enters username "<Username>", password "<Password>", and confirm password "<ConfirmPassword>" and clicks the Register button
    Then the error message "<ErrorMessage>" should be displayed below the Confirm Password field

    Examples:
      | Username  | Password | ConfirmPassword | ErrorMessage             |
      | testuser1 | Pass123  | Pass321         | Passwords do not match.  |
     
    
  Scenario Outline: User get message when Register with different combination of credentials based on "<validation>"
    When User clicks Register button with username and password and confirm password for validation "<validation>"
    Then User gets corresponding messages for register validation "<validation>"
		Examples:
      |  validation				|
      |  EmptyPassword    |
      |  WrongPassword    |
      |  ShortPassword    |
      |  NumaricPassword  |
      |  ValidCredential  |
    