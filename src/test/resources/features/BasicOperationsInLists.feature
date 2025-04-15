Feature: BasicOperationsInLists
Background:
	Given User is in BasicOperationsInLists page after clicking BasicOperationsInLists link in array page
	
  Scenario: User able to view Try here button for BasicOperationsInLists
  	When User scroll to end of the page for BasicOperationsInLists
    Then User able to view Try here button for BasicOperationsInLists
       
  Scenario: User lands on tryEditor page for BasicOperationsInLists
  	When User clicks on Try here button for BasicOperationsInLists
    Then User redirected to tryEditor page for BasicOperationsInLists
    
  Scenario: User able to view Run button for BasicOperationsInLists
  	Given User is on the tryEditor page for viewRunBtn for BasicOperationsInLists
  	When User clicks on Try here button for view RunBtn for BasicOperationsInLists
    Then User able to view Run button for BasicOperationsInLists
       
  Scenario: User gets error while clicks on Run button without code for BasicOperationsInLists
  	Given User is on the tryEditor page for withoutCodeRun for BasicOperationsInLists
  	When User clicks on Run button without code for BasicOperationsInLists
    Then User gets an appropriate error message in an alert window for BasicOperationsInLists
    
  Scenario: User gets invalid error while clicks on Run button with invalid code for BasicOperationsInLists
		Given User is on the tryEditor page for invalidCodeRun for BasicOperationsInLists
  	When User clicks on Run button with invalid code for BasicOperationsInLists
    Then User gets an error message NameError: name is not defined on line one in an alert window for BasicOperationsInLists
    
  Scenario: User gets output while clicks on Run button with valid code for BasicOperationsInLists
  	Given User is on the tryEditor page for validCodeRun for BasicOperationsInLists
  	When User clicks on Run button with valid code for BasicOperationsInLists
    Then User able to see output in the console for BasicOperationsInLists