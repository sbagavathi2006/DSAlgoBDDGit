Feature: ArraysUsingPython
Background:
	Given User is in arrays using list page after clicking arrays using list link in array page
	
  Scenario: User able to view Try here button for Arrays Using List
  	When User scroll to end of the page
    Then User able to view Try here button for Arrays Using List
       
  Scenario: User lands on tryEditor page with a Run button for Arrays Using List
  	When User clicks on Try here button for Arrays Using List
    Then User redirected to tryEditor page for Arrays Using List
    
  Scenario: User able to view Run button for Arrays Using List
  	Given User is on the tryEditor page for viewRunBtn for Arrays Using List
  	When User clicks on Try here button for view RunBtn for Arrays Using List
    Then User able to view Run button for Arrays Using List
       
  Scenario: User gets error while clicks on Run button without code for Arrays Using List
  	Given User is on the tryEditor page for withoutCodeRun for Arrays Using List
  	When User clicks on Run button without code for Arrays Using List
    Then User gets an appropriate error message in an alert window for Arrays Using List
    
  Scenario: User gets invalid error while clicks on Run button with invalid code for Arrays Using List
		Given User is on the tryEditor page for invalidCodeRun for Arrays Using List
  	When User clicks on Run button with invalid code for Arrays Using List
    Then User gets an error message NameError: name is not defined on line one in an alert window for Arrays Using List
    
  Scenario: User gets output while clicks on Run button with valid code for Arrays Using List
  	Given User is on the tryEditor page for validCodeRun for Arrays Using List
  	When User clicks on Run button with valid code for Arrays Using List
    Then User able to see output in the console for Arrays Using List