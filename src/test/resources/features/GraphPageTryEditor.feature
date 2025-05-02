
@afterSignIn
Feature: GraphPageTryEditor
Background: 
Given User is on graph page after clicking its link in the Graph Page
	
  Scenario Outline: Verify User able to see graph Try here button for "<graphSubPage>"
  	When  User click the "<graphSubPage>" graph link
    Then User can see graph Try here button 
    
    Examples:
      | graphSubPage         |
   		| graph                | 
   		| graph representations|
    
  Scenario Outline: User lands on tryEditor page for "<graphSubPage>"
  	Given User is on the "<graphSubPage>" graph subpage
  	When User click graph Try here button
    Then User redirected to the tryEditor graph page
    
        Examples:
      | graphSubPage         |
   		| graph                | 
   		| graph representations|
      
  Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<graphSubPage>" graph subpage 
  	When User click graph Try here button
    Then User able to see graph Run button
    
        Examples:
      | graphSubPage         |
   		| graph                | 
   		| graph representations|
      
  Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code snippet for "<graphSubPage>"
    Given User is on tryeditor page for "<graphSubPage>"
    When User click Run button for "<graphSubPage>" graphSubPage with code "<codeValidationsType>"
    Then User view message "<message>" for "<graphSubPage>" graphSubPage with code "<codeValidationsType>"

   Examples:
      |  graphSubPage						|codeValidationsType| message					|
      |  graph         					|EmptyRun   				| Error						|
      |  graph           			  |InvalidCodeRun     | Error						|
     	|  graph           			  |InvalidCodeRun     | Error						|
      |  graph          				|ValidCodeRun   		| OutputDisplayed	|
      |  graph representations  |EmptyRun    				| Error						|
     	|  graph representations  |InvalidCodeRun     |	Error						|
     	|  graph representations  |InvalidCodeRun     | Error						|	
     	|  graph representations  |ValidCodeRun      	|	OutputDisplayed	|
     
  Scenario Outline: User lands on Practice page
    Given User is on the "<graphSubPage>" graph subpage
    When User clicks on graph Practice Questions link
    Then User is redirected to graph practice page
    
        Examples:
      | graphSubPage         |
   		| graph                | 
   		| graph representations|
   		
  Scenario Outline: User able to view graph pratice questions
    Given User is on the "<graphSubPage>" graph subpage
    When User clicks on graph Practice Questions link
    Then User able to view the questions
    
        Examples:
      | graphSubPage         |
   		| graph                | 
   		| graph representations|