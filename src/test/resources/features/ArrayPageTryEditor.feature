
@afterSignIn
Feature: ArrayPageTryEditor
Background: 
Given User is on array page after clicking its link in the Array Page
	
  Scenario Outline: Verify User able to see array Try here button for "<arraySubPages>"
  	When  User click the "<arraySubPages>" link
    Then User can see view Try here button 
    
    Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |
    
  Scenario Outline: User lands on tryEditor page for "<arraySubPages>"
  	Given User is on the "<arraySubPages>" arraysubpage
  	When User click the Try here button
    Then User redirected to the tryEditor page
    
        Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |
      
  Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<arraySubPages>" arraysubpage 
  	When User click the Try here button
    Then User able to see Run button
    
        Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |

	Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code snippet for "<arraySubPage>"
    Given User is on array tryeditor page for "<arraySubPage>"
    When User click Run button for "<arraySubPage>" arraySubPage with code "<codeValidationsType>"
    Then User view message "<message>" for "<arraySubPage>" arraySubPage with code "<codeValidationsType>"

   Examples:
      |  arraySubPage							|codeValidationsType| message					|
      |  Arrays in python       	|EmptyRun   				| Error						|
      |  Arrays in python       	|InvalidCodeRun     | Error						|
     	|  Arrays in python       	|InvalidCodeRun     | Error						|
      |  Arrays in python       	|ValidCodeRun   		| OutputDisplayed	|
      |  Arrays Using List       	|EmptyRun   				| Error						|
      |  Arrays Using List       	|InvalidCodeRun     | Error						|
     	|  Arrays Using List       	|InvalidCodeRun     | Error						|
      |  Arrays Using List       	|ValidCodeRun   		| OutputDisplayed	|
      |  Basic Operations In Lists|EmptyRun   				| Error						|
      |  Basic Operations In Lists|InvalidCodeRun     | Error						|
     	|  Basic Operations In Lists|InvalidCodeRun     | Error						|
      |  Basic Operations In Lists|ValidCodeRun   		| OutputDisplayed	|
      |  Applications Of Array    |EmptyRun   				| Error						|
      |  Applications Of Array    |InvalidCodeRun     | Error						|
     	|  Applications Of Array    |InvalidCodeRun     | Error						|
      |  Applications Of Array    |ValidCodeRun   		| OutputDisplayed	|
   
  Scenario Outline: User lands on Practice page
    Given User is on the "<arraySubPages>" arraysubpage
    When User clicks on Practice Questions link
    Then User is redirected to practice page
    Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |