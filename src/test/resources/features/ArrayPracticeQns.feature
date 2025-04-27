
@afterSignIn
Feature: ArrayPraticeQns
Background:
	Given User is on the arrays sublink page
	
	Scenario: User able to view pratice questions
    When User clicks on pratice questions link
    Then User able to view the questions

  Scenario Outline: User navigates to question pages correctly
    Given User clicks on the pratice questions link
    When User clicks on "<linkText>" Link
    Then User is redirected to "<questionPage>" Page

    Examples:
      | linkText                                | questionPage |
      | search the array                        | question/1   |
      | max consecutive ones                    | question/2   |
      | find numbers with even number of digits | question/3   |
      | squares of  a sorted array              | question/4   |

  Scenario Outline: User is able to see Run button on each question page
  	Given User clicks on pratice questions link
    When User clicks on "<linkText>" Link
    Then User is able to see Run button

    Examples:
      | linkText                                |
      | Search the array                        |
      | Max Consecutive Ones                    |
      | Find Numbers with Even Number of Digits |
      | Squares of  a Sorted Array               |

  Scenario Outline: User is able to see Submit button on each question page
    Given User clicks on pratice questions link
    When User clicks on "<linkText>" Link
    Then User is able to see Submit button

    Examples:
      | linkText                                |
      | Search the array                        |
      | Max Consecutive Ones                    |
      | Find Numbers with Even Number of Digits |
      | Squares of  a Sorted Array               |   
     
 	Scenario Outline: User gets an message when clicks on Run button with "<codeValidationsType>" code snippet for "<questionsFea>"
 		Given User is on "<questionsFea>" page after clicks on arraysubpage Link
    When User click on run button with "<codeValidationsType>" code snippet and "<questionsFea>" questions
    Then User gets an message "<message>" for "<questionsFea>" questions for "<codeValidationsType>"

    Examples:
      |  questionsFea														 |codeValidationsType		| message					|
      |  search the array         							 |ExistingCodeSnippet   | SyntaxError			|
      |  search the array          							 |InvalidCodeSnippet    | SyntaxError			|
     	|  search the array          							 |VaildCodeSnippet      | OutputDisplayed	|
      |  Max Consecutive Ones          					 |ExistingCodeSnippet   | SyntaxError			|
      |  Max Consecutive Ones         					 |InvalidCodeSnippet    | SyntaxError			|
     	|  Max Consecutive Ones         					 |VaildCodeSnippet      |	OutputDisplayed	|
      |  Find Numbers with Even Number of Digits |ExistingCodeSnippet   | SyntaxError			|
      |  Find Numbers with Even Number of Digits |InvalidCodeSnippet    | SyntaxError			|
     	|  Find Numbers with Even Number of Digits |VaildCodeSnippet      | OutputDisplayed	|
      |  Squares of  a Sorted Array          		 |ExistingCodeSnippet   | SyntaxError			|
      |  Squares of  a Sorted Array           	 |InvalidCodeSnippet    | SyntaxError			|
     	|  Squares of  a Sorted Array          		 |VaildCodeSnippet     	| OutputDisplayed	|
 
  Scenario Outline: User gets an  message "<message>" when clicks on Submit button with "<codeValidationsType>" code snippet for "<questionsFea>"
 		Given User is on "<questionsFea>" page after clicks on arraysubpage Link
    When User click on submit button with "<codeValidationsType>" code snippet and "<questionsFea>" questions
    Then User gets message "<message>" for "<questionsFea>" questions for "<codeValidationsType>" submit

    Examples:
      | questionsFea   													 |codeValidationsType   | message                      		  |
      |  Search the array         							 |ExistingCodeSnippet   | Error occurred during submission 	|
      |  Search the array          							 |InvalidCodeSnippet    | Error occurred during submission 	|
     	|  Search the array          							 |VaildCodeSnippet      | Submission Successful   					|
      |  Max Consecutive Ones          					 |ExistingCodeSnippet   | Error occurred during submission 	|
      |  Max Consecutive Ones         					 |InvalidCodeSnippet    | Error occurred during submission 	|
     	|  Max Consecutive Ones         					 |VaildCodeSnippet      |	Submission Successful  						|
      |  Find Numbers with Even Number of Digits |ExistingCodeSnippet   | Error occurred during submission	|
      |  Find Numbers with Even Number of Digits |InvalidCodeSnippet    | Error occurred during submission  |
     	|  Find Numbers with Even Number of Digits |VaildCodeSnippet      | Submission Successful		   				|
      |  Squares of  a Sorted Array          		 |ExistingCodeSnippet   | Error occurred during submission	|
      |  Squares of  a Sorted Array          		 |InvalidCodeSnippet    | Error occurred during submission  |
     	|  Squares of  a Sorted Array          		 |VaildCodeSnippet     	| Submission Successful		  				|
    