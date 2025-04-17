
@afterSignIn
Feature: ArrayPraticeQns
Background:
	Given User is on pratice page after clicks on Pratice Questions link from Applications of Array page
     
  Scenario Outline: User navigates to question pages correctly
    When User clicks on "<linkText>" Link
    Then User is redirected to "<questionPage>" Page

    Examples:
      | linkText                                | questionPage     |
      | Search the array                        | question one     |
      | Max Consecutive Ones                    | question two     |
      | Find Numbers with Even Number of Digits | question three   |
      | Squares of a Sorted Array               | question four    |

  Scenario Outline: User is able to see Run button on each question page
    When User clicks on "<linkText>" Link
    Then User is able to see Run button

    Examples:
      | linkText                                |
      | Search the array                        |
      | Max Consecutive Ones                    |
      | Find Numbers with Even Number of Digits |
      | Squares of a Sorted Array               |

  Scenario Outline: User is able to see Submit button on each question page
    When User clicks on "<linkText>" Link
    Then User is able to see Submit button

    Examples:
      | linkText                                |
      | Search the array                        |
      | Max Consecutive Ones                    |
      | Find Numbers with Even Number of Digits |
      | Squares of a Sorted Array               |   
     
 	Scenario Outline: User gets an message when clicks on Run button with "<codeValidations>" code snippet for "<questions>"
 		Given User is on "<questions>" page after clicks on "<questions>" Link
    When User click on run button with "<codeValidations>" code snippet
    Then User gets an message "<message>"

    Examples:
      |  questions   														 |codeValidations   		| message                      		  |
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
    
  
  Scenario Outline: User gets an  message "<Message>" when clicks on Submit button with "<codeValidations>" code snippet for "<questions>"
 		Given User is on "<questions>" after clicks on "<questions>" Link
    When User click on submit button with "<codeValidations>" code snippet
    Then User gets "<message>" message

    Examples:
      | questions   														 |codeValidations   		| message                      		  |
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
    