Feature: ApplicationsOfArray
Background:
	Given User is in ApplicationsOfArray page after clicking ApplicationsOfArray link in array page
	
  Scenario: User able to view Try here button for ApplicationsOfArray
  	When User scroll to end of the page for ApplicationsOfArray
    Then User able to view Try here button for ApplicationsOfArray
       
  Scenario: User lands on tryEditor page for ApplicationsOfArray
  	When User clicks on Try here button for ApplicationsOfArray
    Then User redirected to tryEditor page for ApplicationsOfArray
    
  Scenario: User able to view Run button for ApplicationsOfArray
  	Given User is on the tryEditor page for viewRunBtn for ApplicationsOfArray
  	When User clicks on Try here button for view RunBtn for ApplicationsOfArray
    Then User able to view Run button for ApplicationsOfArray
       
  Scenario: User gets error while clicks on Run button without code for ApplicationsOfArray
  	Given User is on the tryEditor page for withoutCodeRun for ApplicationsOfArray
  	When User clicks on Run button without code for ApplicationsOfArray
    Then User gets an appropriate error message in an alert window for ApplicationsOfArray
    
  Scenario: User gets invalid error while clicks on Run button with invalid code for ApplicationsOfArray
		Given User is on the tryEditor page for invalidCodeRun for ApplicationsOfArray
  	When User clicks on Run button with invalid code for ApplicationsOfArray
    Then User gets an error message NameError: name is not defined on line one in an alert window for ApplicationsOfArray
    
  Scenario: User gets output while clicks on Run button with valid code for ApplicationsOfArray
  	Given User is on the tryEditor page for validCodeRun for ApplicationsOfArray
  	When User clicks on Run button with valid code for ApplicationsOfArray
    Then User able to see output in the console for ApplicationsOfArray
    
  Scenario: User lands on Practice page
  	When User clicks on Practice Questions link
    Then User redirected to pratice page