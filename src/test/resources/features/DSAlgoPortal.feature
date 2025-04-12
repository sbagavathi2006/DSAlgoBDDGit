Feature: DSAlgoPortal
Background:
	Given User is on the DS Algo Portal
	When User clicks the Get Started button
	
  Scenario: User lands on home page 
    Then User is redirected to the home page
       
  Scenario: User able to see NumpyNinja link in the home page
    Then User able to see NumpyNinja link
    
  Scenario: User should see Register link in the home page
    Then User able to see Register link
    
  Scenario: User should see Sign in link in the home page
    Then User able to see Sign in link
    
  Scenario: User should see Data structure dropdown in the home page
    Then User should see Data structure dropdown