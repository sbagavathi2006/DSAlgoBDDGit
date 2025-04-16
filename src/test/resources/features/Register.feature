Feature: Register

Background: 
    Given  User is in Register page after clicking register in home page  
    

  Scenario: Verify that user is able to navigate to Register Page
   When the user clicks the "Register" link on the Home page
    Then the user should be redirected to the Register form

  Scenario: Verify that user receives error message for all empty fields during registration
    Given the user is on the user registration page
    When the user clicks the Register button with all fields empty
    Then the error message "Please fill out this field." appears below the Username textbox

  Scenario: Verify that user receives error message for empty Password field during registration
    When the user enters a Username but leaves the Password field empty and clicks the Register button
    Then the error message "Please fill out this field." appears below the Password textbox

  Scenario: verify user recieve error message when password mismatch
     When the user enters different values in the Password and Confirm Password fields and clicks the Register button
    Then User should see the error message "password mismatched" is displayed

  Scenario: Verify that user receives error message for invalid password field during registration
     When the user enters a password value with numeric data only and clicks the Register button
    Then the error message "password_mismatch:The two password fields didn’t match." is displayed

  Scenario: Verify that user enter less than 8 character in password field
    When the user enters a password with less than 8 characters and clicks the Register button
    Then the error message "Your password must contain at least 8 characters." is displayed
    
    
  Scenario Outline: Verify that the user receives an error message for invalid username formats during registration
       When  user clicks the Register button after entering a username <username>
       Then  user should see an error message indicating that the username <error_message>
    Examples:
       |   username	             |        error_message                     | 
       |"username with spaces"   |	 "Username cannot contain spaces"       |    
       | "username@!invalid"	   |   "Username contains invalid characters" |
       |"toolongusername1234567" |   "Username exceeds the character limit" |
       |   "username#special"	   |    "Username contains invalid characters"|
    
     
    Scenario: verify Successful registration with valid details
    When     user clicks Register button after entering  with valid username, password and password confirmation in related textboxes 
    Then     user should be redirected to Home Page of DS Algo with message New Account Created You are logged in as username Data Structures
            
    
 Scenario: Verify that user able to Navigate to Sign in page from Register page
   When the user clicks the "Login" link on the Register page
   Then the user should be navigated to the "Sign in" page
