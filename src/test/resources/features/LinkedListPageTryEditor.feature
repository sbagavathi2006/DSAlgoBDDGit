
@afterSignIn
Feature: LinkedListPageTryEditor

Background:
	Given User is in LinkedList page after clicking its link in the LinkedList Page
	
   Scenario Outline: Verify User able to see Try here button for "<linkedListSubPage>"
  	When  User click the "<linkedListSubPage>" linkedlist link
    Then User can see linkedList Try here button
  
    
    Examples:
  | linkedListSubPage                 |               
  | Introduction                      |              
  | Creating Linked LIst              |
  | Types of Linked List              |            
  | Implement Linked List in Python   |    
  | Traversal                         | 
  |	Insertion                         | 
  |	Deletion                          | 
    
  Scenario Outline: User lands on tryEditor page for "<linkedListSubPage>"
  	Given User is on the "<linkedListSubPage>" linkedList subpage
  	When User click linkedList Try here button
    Then User redirected to the linkedListtryEditor linkedlist page
    
      Examples:
   | linkedListSubPage                 |               
  | Introduction                      |              
  | Creating Linked LIst              |
  | Types of Linked List              |            
  | Implement Linked List in Python   |    
  | Traversal                         | 
  |	Insertion                         | 
  |	Deletion                          | 
    
  Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<linkedListSubPage>" linkedList subpage 
  	When User click linkedList Try here button
    Then User able to see linkedlist Run button
    
    Examples:
   | linkedListSubPage                 |               
  | Introduction                      |              
  | Creating Linked LIst              |
  | Types of Linked List              |            
  | Implement Linked List in Python   |    
  | Traversal                         | 
  |	Insertion                         | 
  |	Deletion                          | 
    
  
  Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code snippet for "<linkedListSubPage>"
    Given User is on LinkedListtryeditor page for "<linkedListSubPage>"
    When User click Run button for "<linkedListSubPage>" linkedlistSubPage with code "<codeValidationsType>"
    Then User view message "<message>" for "<linkedListSubPage>" linkedlistSubPage with code "<codeValidationsType>"
    
    Examples:
    | linkedListSubPage                  | codeValidationsType   |message         	|                 
  | Introduction                         | EmptyRun   				   | Error						|               
  | Introduction                         |  InvalidCodeRun       | Error						|              
  | Introduction                         |  InvalidCodeRun       | Error						|           
  |	Introduction                         |   ValidCodeRun   		 | OutputDisplayed	|    
 | Creating Linked LIst                  | EmptyRun              | Error          	|
 | Creating Linked LIst                  | InvalidCodeRun        | Error	          |
 |  Creating Linked LIst                 | InvalidCodeRun        | Error	          |
 | Creating Linked LIst                  | ValidCodeRun          | OutputDisplayed  |
  | Types of Linked List                 |    EmptyRun   		     | Error					  |        
  | Types of Linked List                 |    InvalidCodeRun     | Error						|        
  | Types of Linked List              |    InvalidCodeRun    | Error						|          
  | Types of Linked List              |    ValidCodeRun      | OutputDisplayed	|        
  | Implement Linked List in Python   |    EmptyRun   			 | Error						|
  | Implement Linked List in Python   | InvalidCodeRun       | Error						|  
  |	Implement Linked List in Python   |   InvalidCodeRun     | Error						| 
  | Implement Linked List in Python   |   ValidCodeRun   		 | OutputDisplayed	|   
  | Traversal                         |  EmptyRun   				 | Error						|
  | Traversal                         | InvalidCodeRun       | Error						|
  | Traversal                         |  InvalidCodeRun      | Error						|  
  | Traversal                         | ValidCodeRun   		   | OutputDisplayed	|
  |	Insertion                         | EmptyRun   				   | Error						|
  | Insertion                         | InvalidCodeRun       | Error						|
  | Insertion                         |  InvalidCodeRun      | Error						|
  | Insertion                         | ValidCodeRun   		   | OutputDisplayed	|
  |	Deletion                          |  EmptyRun   				 | Error						|
  | Deletion                          | InvalidCodeRun       | Error						|
  | Deletion                          | InvalidCodeRun       | Error						|
  | Deletion                          |  ValidCodeRun   		 | OutputDisplayed	|
  
   Scenario Outline: User lands on Practice page
    Given User is on the "<linkedListSubPage>" linkedList subpage 
    When User clicks on linkedlist Practice Questions link
    Then User is redirected to linkedlist practice page
     
    Examples:
   | linkedListSubPage                 |               
  | Introduction                      |              
  | Creating Linked LIst              |
  | Types of Linked List              |            
  | Implement Linked List in Python   |    
  | Traversal                         | 
  |	Insertion                         | 
  |	Deletion                          | 
    
  
   Scenario Outline: User able to view queue pratice questions
    Given User is on the "<linkedListSubPage>" linkedList subpage 
    When User clicks on linkedlist Practice Questions link
    Then User able to view the questions
    
      
    Examples:
    | linkedListSubPage                 |               
  | Introduction                      |              
  | Creating Linked LIst              |
  | Types of Linked List              |            
  | Implement Linked List in Python   |    
  | Traversal                         | 
  |	Insertion                         | 
  |	Deletion                          | 
    
    
    
    
    
    
