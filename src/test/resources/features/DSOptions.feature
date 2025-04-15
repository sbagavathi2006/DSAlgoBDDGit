
@afterSignIn
Feature: DSOptions

Background:
	Given User is on the home page
	  
   Scenario Outline: User redirected to "<pages>" page while selecting "<dropdownOptions>" from the data structure dropdown list
    When User selects "<dropdownOptions>" from Data Structures dropdown
    Then User is redirected to "<pages>" page
    
    Examples:
      | dropdownOptions	| pages       |
      | Arrays       		| arrays      |
      | Linked List  		| linked list |
      | Stack   			  | stack      	|
      | Queue      	 		| queue       |
      | Tree      		  | tree        |
      | Graph     	 		| graph       |

   Scenario Outline: User redirected to "<pages>" page from "<panelOptions>" panel
    When User clicks on Getting Started button in "<panelOptions>" panel
    Then User is redirected to "<pages>" page
    
    Examples:
      | panelOptions								| pages       								|
      | Data Structures Introduction| data structures introduction|
      | Arrays       								| arrays      								|
      | Linked List  								| linked list 								|
      | Stack   			  						| stack      									|
      | Queue      	 								| queue       								|
      | Tree      		  						| tree        								|
      | Graph     	 								| graph       								|
