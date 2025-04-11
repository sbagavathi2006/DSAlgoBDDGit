Feature: Home
Background:
	Given User is in home Page after clicking get started button in DS Algo page
	
  Scenario: Home page refreshed  when click on NumpyNinja link
  	When User clicks NumpyNinja link
    Then Home page is refreshed
       
  Scenario: User able to navigate to Register page
  	When User clicks Register link 
    Then User is redirected to the Register page
    
  Scenario: User able to navigate to Sign in page
  	When User clicks Sign in link 
    Then User is redirected to Login page
    
  Scenario: User able to view Data Structures dropdown options on home page without signing in
  	When User clicks the Data Structures dropdown 
    Then User should sees six options Arrays, Linked List, Stack, Queue, Tree, Graph in dropdown menu
    
  Scenario: User should see Data structure dropdown in the home page
  	When User clicks the Get Started button
    Then User should see Data structure dropdown
    
  Scenario Outline: User sees alert while selecting "<DSDropdownOptions>" from the drop down without signing in
    When User selects "<DSDropdownOptions>" from the drop down
    Then User views an alert "<Message>" for the dropdown

    Examples: 
      | DSDropdownOptions | Message 							 |
      | Arrays						|  You are not logged in |
      | Linked List 			|  You are not logged in |
      | Stack 						|  You are not logged in |
      | Queue				 			|  You are not logged in |
      | Tree  						|  You are not logged in |
      | Graph 						|  You are not logged in |
  
   Scenario Outline: User sees alert while clicks Get Started button on "<FlexOptions>" flex without signing in
    When User clicks Get Started button on "<FlexOptions>" flex
    Then User views an alert "<Message>" for the flex

    Examples: 
      | FlexOptions						 			 | Message 							  |
      | Data Structures-Introduction |	You are not logged in |
      | Array 											 |  You are not logged in |
      | Linked List 								 |  You are not logged in |
      | Stack 											 |  You are not logged in |
      | Queue				 								 |  You are not logged in |
      | Tree  											 |  You are not logged in |
      | Graph 											 |  You are not logged in |