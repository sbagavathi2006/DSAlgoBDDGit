@afterSignIn
Feature: DataStructurePageTryEditor
Background: 
Given User is on DataStructure page after clicking its link in the DataStructure Page

  Scenario Outline: Verify User able to see DataStructure Try here button for "<datastructureSubPage>"
  	When  User click the "<datastructureSubPage>" datastructure link
    Then User can see datastructure Try here button 
    
    Examples:
      | datastructureSubPage |
   		| Time Complexity      | 
   		
   		Scenario Outline: User lands on tryEditor page for "<datastructureSubPage>"
  	Given User is on the "<datastructureSubPage>" datastructure subpage
  	When User click datastructure Try here button
    Then User redirected to the tryEditor datastructure page
    
     Examples:
      | datastructureSubPage |
   		| Time Complexity      | 
   		
   		Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<datastructureSubPage>" datastructure subpage 
  	When User click datastructure Try here button
    Then User able to see datastructure Run button
    
      Examples:
      | datastructureSubPage |
   		| Time Complexity      | 
   		
   		 Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code snippet for "<datastructureSubPage>"
    Given User is on datastructure tryeditor page for "<datastructureSubPage>"
    When User click Run button for "<datastructureSubPage>" datastructureSubPage with code "<codeValidationsType>"
    Then User view message "<message>" for "<datastructureSubPage>" datastructureSubPage with code "<codeValidationsType>"
   		
       Examples:
      |  datastructureSubPage						|codeValidationsType| message					|
      | Time Complexity         			  |EmptyRun   				| Error						|
      |  Time Complexity            		|InvalidCodeRun     | Error						|
     	|  Time Complexity            	  |InvalidCodeRun     | Error						|
      |  Time Complexity           			|ValidCodeRun   		| OutputDisplayed	|
      
         
  Scenario Outline: User lands on Practice page
    Given User is on the "<datastructureSubPage>" datastructure subpage
    When User clicks on datastructure Practice Questions link
    Then User is redirected to datastructure practice page
    
     Examples:
      | datastructureSubPage |
   		| Time Complexity      | 
   		
   		  Scenario Outline: User able to view datastructure pratice questions
    Given User is on the "<datastructureSubPage>" datastructure subpage
    When User clicks on datastructure Practice Questions link
    Then User able to view the questions
    
    
     Examples:
      | datastructureSubPage |
   		| Time Complexity      |
    
    

 
