Feature: ArrayPraticeQns
Background:
	Given User is on pratice page after clicks on Pratice Questions link from Applications of Array page
	
  Scenario: User lands on question one page when clicks on Search the array link
  	When User clicks on Search the array link
    Then User redirected to question one page
       
  Scenario: User able to see Run button when clicks on Search the array link
  	When User clicks on Search the array link to see Run button
    Then User able to see Run button on Search the array link
    
  Scenario: User able to see Submit button when clicks on Search the array link
  	When User clicks on Search the array link to see Submit
    Then User able to see Submit button on Search the array link
       
  Scenario: User lands on question two page when clicks on Max Consecutive Ones link
  	When User clicks on Max Consecutive Ones link
    Then User redirected to question two page
    
   Scenario: User able to see Run button when clicks on Max Consecutive Ones link
  	When User clicks on  on Max Consecutive Ones to see Run button
    Then User able to see Run button  on Max Consecutive Ones
    
  Scenario: User able to see Submit button when clicks on Max Consecutive Ones link
  	When User clicks on  on Max Consecutive Ones to see Submit
    Then User able to see Submit button  on Max Consecutive Ones
    
  Scenario: User lands on question three page when clicks on Find Numbers with Even Number of Digits link
  	When User clicks on Find Numbers with Even Number of Digits link
    Then User redirected to question three page
    
   Scenario: User able to see Run button when clicks on Find Numbers with Even Number of Digits link
  	When User clicks on Find Numbers with Even Number of Digits link
    Then User able to see Run button Find Numbers with Even Number of Digits link
    
  Scenario: User able to see Submit button when clicks on Find Numbers with Even Number of Digits link
  	When User clicks on Find Numbers with Even Number of Digits link to see Submit
    Then User able to see Submit button on Find Numbers with Even Number of Digits link
    
  Scenario: User lands on question four page when clicks on Squares of a Sorted Array link
  	When User clicks on Squares of a Sorted Array link
    Then User redirected to question four page
    
  Scenario: User able to see Run button when clicks on Squares of a Sorted Array link
  	When User clicks on Squares of a Sorted Array link to see Run button
    Then User able to see Run button on Squares of a Sorted Array link
    
  Scenario: User able to see Submit button when clicks on Squares of a Sorted Array link
  	When User clicks on Squares of a Sorted Array link to see Submit
    Then User able to see Submit button on Squares of a Sorted Array link
    
 	Scenario Outline: User gets an message when clicks on Run button with "<CodeValidations>" code snippet for "<Questions>"
 		Given User is on "<Questions>" page after clicks on "<Questions>" Link
    When User click on run button with "<CodeValidations>" code snippet
    Then User gets an message "<Message>"

    Examples:
      | Questions   														 |CodeValidations   		| Message                      		  |
      |  Search the array         							 |ExistingCodeSnippet   | SyntaxError: bad input on lineTwo |
      |  Search the array          							 |InvalidCodeSnippet    | SyntaxError: bad input   					|
     	|  Search the array          							 |VaildCodeSnippet      | Output below Run button   				|
      |  Max Consecutive Ones          					 |ExistingCodeSnippet   | SyntaxError: bad input on lineTwo |
      |  Max Consecutive Ones         					 |InvalidCodeSnippet    | SyntaxError: bad input   					|
     	|  Max Consecutive Ones         					 |VaildCodeSnippet      | Output below Run button   				|
      |  Find Numbers with Even Number of Digits |ExistingCodeSnippet   | SyntaxError: bad input on lineTwo	|
      |  Find Numbers with Even Number of Digits |InvalidCodeSnippet    | SyntaxError: bad input   					|
     	|  Find Numbers with Even Number of Digits |VaildCodeSnippet      | Output below Run button   				|
      |  Squares of a Sorted Array          		 |ExistingCodeSnippet   | SyntaxError: bad input on lineTwo	|
      |  Squares of a Sorted Array           		 |InvalidCodeSnippet    | SyntaxError: bad input   					|
     	|  Squares of a Sorted Array          		 |VaildCodeSnippet     	| Output below Run button   				|
    
  
  Scenario Outline: User gets an  message "<Message>" when clicks on Submit button with "<CodeValidations>" code snippet for "<Questions>"
 		Given User is on "<Questions>" after clicks on "<Questions>" Link
    When User click on submit button with "<CodeValidations>" code snippet
    Then User gets "<Message>" message

    Examples:
      | Questions   														 |CodeValidations   		| Message                      		  |
      |  Search the array         							 |ExistingCodeSnippet   | Error occurred during submission 	|
      |  Search the array          							 |InvalidCodeSnippet    | Error occurred during submission 	|
     	|  Search the array          							 |VaildCodeSnippet      | Success    												|
      |  Max Consecutive Ones          					 |ExistingCodeSnippet   | Error occurred during submission 	|
      |  Max Consecutive Ones         					 |InvalidCodeSnippet    | Error occurred during submission 	|
     	|  Max Consecutive Ones         					 |VaildCodeSnippet      |	Success   												|
      |  Find Numbers with Even Number of Digits |ExistingCodeSnippet   | Error occurred during submission	|
      |  Find Numbers with Even Number of Digits |InvalidCodeSnippet    | Error occurred during submission  |
     	|  Find Numbers with Even Number of Digits |VaildCodeSnippet      | Success									   				|
      |  Squares of a Sorted Array          		 |ExistingCodeSnippet   | Error occurred during submission	|
      |  Squares of a Sorted Array           		 |InvalidCodeSnippet    | Error occurred during submission  |
     	|  Squares of a Sorted Array          		 |VaildCodeSnippet     	| Success									   				|
    
  
  