
@afterSignIn
Feature: DSOptions

Background:
	Given User is on the home page
	  
   Scenario Outline: User redirected to "<pages>" page while selecting "<dropdownOptions>" from the data structure dropdown list
    When User selects "<dropdownOptions>" from Data Structures dropdown
    Then User is redirected to "<pages>" page
    
    Examples:
      | dropdownOptions 	| pages       |
      | arrays       			| array       |
      | linked-list  			| linked-list |
      | stack   			 	  | stack      	|
      | queue      	 		  | queue       |
      | tree      		    | tree        |
      | graph     	 	  	| graph       |

   Scenario Outline: User redirected to "<pages>" page from "<panelOptions>" flex
    When User clicks on Getting Started button in "<panelOptions>" panel
    Then User is redirected to "<pages>" page
    
    Examples:
      | panelOptions								  | pages       								|
      | data-structures-introduction| data-structures-introduction|
      | array       								| array      								  |
      | linked-list  								| linked-list 								|
      | stack   			  						| stack      									|
      | queue      	 								| queue       								|
      | tree      		  						| tree        								|
      | graph     	 								| graph       								|
