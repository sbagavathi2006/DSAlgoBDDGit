
@afterSignIn
Feature: QueuePageTryEditor
Background:
	Given User is in Queue Page after clicking its link in the Queue Page
	
   Scenario Outline: Verify User able to see Try here button for "<queueSubPage>"
  	When  User click the "<queueSubPage>" queue link
    Then User can see queue Try here button 
    Examples:
  | queueSubPage                      |
  | Implementation of Queue in Python |
  |  Implementation using collections.deque  |
  | Implementation using array         |
  | Queue Operations            |

Scenario Outline: User lands on tryEditor page for "<queueSubPage>"
  	Given User is on the "<queueSubPage>" queue subpage
  	When User click queue Try here button
    Then User redirected to the QueuetryEditor queue page
    Examples:
  | queueSubPage                      |
  | Implementation of Queue in Python |
  |  Implementation using collections.deque  |
  | Implementation using array         |
  | Queue Operations            |
  
Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<queueSubPage>" queue subpage 
  	When User click queue Try here button
    Then User able to see queue Run button
    Examples:
 | queueSubPage                      |
  | Implementation of Queue in Python |
  |  Implementation using collections.deque  |
  | Implementation using array         |
  | Queue Operations            |
  
   Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code snippet for "<queueSubPage>"
    Given User is on Queuetryeditor page for "<queueSubPage>"
    When User click Run button for "<queueSubPage>" queueSubPage with code "<codeValidationsType>"
    Then User view message "<message>" for "<queueSubPage>" queueSubPage with code "<codeValidationsType>"
     Examples:
      | queueSubPage                                        | codeValidationsType  |message	          |
      | Implementation of Queue in python       				    | EmptyRun   				   | Error		        |
      | Implementation of Queue in python        			      | InvalidCodeRun       | Error			      |
     	| Implementation of Queue in python        		       	| InvalidCodeRun       | Error			      |
      | Implementation of Queue in python       				    | ValidCodeRun   	  	 | OutputDisplayed	|
      | Implementation using collections.deque                   | EmptyRun    				 | Error						|
     	| Implementation using collections.deque                   | InvalidCodeRun       |	Error						|
     	|  Implementation using collections.deque                   |  InvalidCodeRun      | Error						|	
     	|  Implementation using collections.deque                    | ValidCodeRun      	 |	OutputDisplayed	|
      | Implementation using array           					      | EmptyRun   				   | Error						|
      | Implementation using array               			      | InvalidCodeRun       | Error						|
     	| Implementation using array             			        | InvalidCodeRun       | Error						|
      | Implementation using array               			      | ValidCodeRun   		   | OutputDisplayed	|
      |  Queue Operations                             | EmptyRun    			   | Error						|
     	| Queue Operations                              | InvalidCodeRun       |	Error						|
     	| Queue Operations                             | InvalidCodeRun       | Error						|	
     	|  Queue Operations                             | ValidCodeRun       	 |	OutputDisplayed |
     
     
   Scenario Outline: User lands on Practice page
    Given User is on the "<queueSubPage>" queue subpage
    When User clicks on queue Practice Questions link
    Then User is redirected to queue practice page
     Examples:
  | queueSubPage                      |
  | Implementation of Queue in python |
  |  Implementation using collections.deque   |
  | Implementation using array        |
  |Queue Operations             |
   		
  Scenario Outline: User able to view queue pratice questions
    Given User is on the "<queueSubPage>" queue subpage
    When User clicks on queue Practice Questions link
    Then User able to view the questions
        Examples:
 | queueSubPage                      |
  | Implementation of Queue in python |
  |  Implementation using collections.deque   |
  | Implementation using array        |
  | Queue Operations             |
        