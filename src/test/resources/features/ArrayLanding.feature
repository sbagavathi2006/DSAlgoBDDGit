Feature: ArrayLanding
Background:
	Given User is on home page after successful login
	
  Scenario: User redirected to array page while selecting Arrays from the data structure dropdown list
  	When User selects Arrays from Data Structures dropdown
    Then User redirected to array page via DSdropdown
       
  Scenario: User redirected to array page while clicks on Get Started button on Array flex
  	When User clicks on Get Started button on Array flex 
    Then User is redirected to the Register page via arrayflex