
@Home
Feature: Home
Background:
	Given User is in home Page after clicking get started button in DS Algo page
	
  Scenario: Home page refreshed  when click on NumpyNinja link
  	When User clicks NumpyNinja link
    Then Home page is refreshed
  
  Scenario Outline: User able to navigate to Register, Sign in page
  	When User clicks "<links>" link 
    Then User is redirected to the "<pages>" page
    
		Examples:
		  | links     | pages    |
		  | Register  | register |
		  | Sign in   | login    |
    
  Scenario: User views all Data Structures dropdown options without signing in
	  When User clicks the Data Structures dropdown
	  Then User sees the following options in the dropdown:
	    | Arrays      |
	    | Linked List |
	    | Stack       |
	    | Queue       |
	    | Tree        |
	    | Graph       |
    
  Scenario Outline: User sees alert while selecting "<dsDropdownOptions>" from the drop down without signing in
    When User selects "<dsDropdownOptions>" from the drop down
    Then User views an alert "<message>"

    Examples: 
      | dsDropdownOptions | message 							 |
      | arrays						|  You are not logged in |
      | linked list 			|  You are not logged in |
      | stack 						|  You are not logged in |
      | queue				 			|  You are not logged in |
      | tree  						|  You are not logged in |
      | graph 						|  You are not logged in |
  
   Scenario Outline: User sees alert while clicks Get Started button on "<flexOptions>" flex without signing in
    When User clicks Get Started button on "<flexOptions>" flex
    Then User views an alert "<messages>"

    Examples: 
      | flexOptions						 			 | messages 							|
      | data-structures-introduction |	You are not logged in |
      | array 											 |  You are not logged in |
      | linked-list 								 |  You are not logged in |
      | stack 											 |  You are not logged in |
      | queue				 								 |  You are not logged in |
      | tree  											 |  You are not logged in |
      | graph 											 |  You are not logged in |