
@afterSignIn
Feature: StackPageTryEditor

Background:
	Given User is in the Stack Page after clicking its link in the Stack Page
	
   Scenario Outline: Verify User able to see Try here button for "<stackSubPage>"
  	When  User click the "<stackSubPage>" stack link
    Then User can see stack Try here button 
    
    Examples:
  |stackSubPage         |                                                   
  | Operations in Stack |               
  | Implementation      |                   
  | Applications        |                  
 
  
  
  Scenario Outline: User lands on tryEditor page for "<stackSubPage>"
  	Given User is on the "<stackSubPage>" stack subpage
  	When User click stack Try here button
    Then User redirected to the StacktryEditor stack page
    
 Examples:
  |stackSubPage         |                                                   
  | Operations in Stack |               
  | Implementation      |                   
  | Applications        |                  
                                  
  
    Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<stackSubPage>" stack subpage 
  	When User click stack Try here button
    Then User able to see stack Run button
    
  Examples:
  |stackSubPage         |                                                   
  | Operations in Stack |               
  | Implementation      |                   
  | Applications        |                  
 
    
    Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code snippet for "<stackSubPage>"
    Given User is on Stacktryeditor page for "<stackSubPage>"
    When User click Run button for "<stackSubPage>" stackSubPage with code "<codeValidationsType>"
    Then User view message "<message>" for "<stackSubPage>" stackSubPage with code "<codeValidationsType>"
    
    Examples:
      |stackSubPage                  | codeValidationsType  |message         	|                                              
  | Operations in Stack         | EmptyRun   				  | Error						|   
  | Operations in Stack          | InvalidCodeRun       | Error						|   
  | Operations in Stack         | InvalidCodeRun       | Error						|   
  | Operations in Stack         | ValidCodeRun   		  | OutputDisplayed	|
  | Implementation               | EmptyRun    				  | Error						|   
  | Implementation               |InvalidCodeRun        |	Error						|  
  | Implementation               |InvalidCodeRun        | Error						|	
  | Implementation               |ValidCodeRun      	  |	OutputDisplayed	|
  | Applications                 |EmptyRun   				    | Error						|
  | Applications                 |InvalidCodeRun        | Error						|
  | Applications                 |InvalidCodeRun        | Error						|
  | Applications                 |ValidCodeRun   	     	| OutputDisplayed	|
  
    Scenario Outline: User lands on Practice page
    Given User is on the "<stackSubPage>" stack subpage
    When User clicks on stack Practice Questions link
    Then User is redirected to stack practice page
    
    Examples:
   |stackSubPage         |                                                   
  | Operations in Stack |               
  | Implementation      |                   
  | Applications        |                  
                          
  
     Scenario Outline: User able to view stack pratice questions
    Given User is on the "<stackSubPage>" stack subpage
    When User clicks on stack Practice Questions link
    Then User able to view the questions
    
    Examples:
       |stackSubPage         |                                                   
  | Operations in Stack |               
  | Implementation      |                   
  | Applications        |                  
                          
  