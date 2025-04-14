Feature: ArraysInPython
Background:
	Given User is in arrays in python page after clicking arrays in python link in array page
	
  Scenario: User able to view Try here button for Arrays in Python
  	When User scroll to the end of the page
    Then User able to view Try here button
       
  Scenario: User lands on tryEditor page for Arrays in Python
  	When User clicks on Try here button
    Then User redirected to tryEditor page
    
  Scenario: User able to view Run button for Arrays in Python
  	Given User is on the tryEditor page for viewRunBtn
  	When User clicks on Try here button for view RunBtn
    Then User able to view Run button
       
  Scenario: User gets error while clicks on Run button without code for Arrays in Python
  	Given User is on the tryEditor page for withoutCodeRun
  	When User clicks on Run button with empty window 
    Then User gets an appropriate error message in an alert window
    
  Scenario: User gets invalid error while clicks on Run button with invalid code for Arrays in Python
		Given User is on the tryEditor page for invalidCodeRun
  	When User clicks on Run button with invalid code
    Then User gets an error message NameError: name is not defined on line one in an alert window
    
  Scenario: User gets output while clicks on Run button with valid code for Arrays in Python
  	Given User is on the tryEditor page for validCodeRun
  	When User clicks on Run button with valid code
    Then User able to see output in the console
