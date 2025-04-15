Feature: Lougout

 Background:	 Verify if user able to login successfully
   Given User is in landing page
   When User clicks on "Get Started" button in landing page and SignIn button in Home Page
   And User enters valid credentials for login and Clicks Submit in Login Page
   Then User should navigate to home Page 
   
   Scenario: Verify that user is able to navigate to Signout button 
    Given the user is on the Graph page
    When the user clicks the "Signout" link
    Then the user should be redirected to the Home page
   