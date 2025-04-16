
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
		  | Register  | Register |
		  | Sign in   | Login    |
    
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
    Then User views an alert "<message>" for the dropdown

    Examples: 
      | dsDropdownOptions | message 							 |
      | Arrays						|  You are not logged in |
      | Linked List 			|  You are not logged in |
      | Stack 						|  You are not logged in |
      | Queue				 			|  You are not logged in |
      | Tree  						|  You are not logged in |
      | Graph 						|  You are not logged in |
  
   Scenario Outline: User sees alert while clicks Get Started button on "<flexOptions>" flex without signing in
    When User clicks Get Started button on "<flexOptions>" flex
    Then User views an alert "<messages>" for the flex

    Examples: 
      | flexOptions						 			 | messages 							|
      | Data Structures-Introduction |	You are not logged in |
      | Array 											 |  You are not logged in |
      | Linked List 								 |  You are not logged in |
      | Stack 											 |  You are not logged in |
      | Queue				 								 |  You are not logged in |
      | Tree  											 |  You are not logged in |
      | Graph 											 |  You are not logged in |