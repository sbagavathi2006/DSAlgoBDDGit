
@afterSignIn
Feature: GraphPageTryEditor
Background: 
Given User is on "<GraphPage>" page after clicking its link in the Graph Page
	
  Scenario Outline: Verify User able to see Try here button for "<graphSubPage>"
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
      
  Scenario Outline: User verifies Run button visibility and behavior for "<graphSubPage>" page
    Given User is on graph Try Editor page for row <rowNum>
    When User clicks on graph Run button for row <rowNum> graph
    Then User should see results for graph for row <rowNum> graph

    Examples:
      |rowNum|             	
      | 1    |
      | 2    |
      | 3    |
      | 4    |
      | 5    |
      | 6    |
      | 7    |
      | 8    |

  Scenario Outline: User lands on Practice page
    Given User is on the "<graphSubPage>" graph subpage
    When User clicks on graph Practice Questions link
    Then User is redirected to graph practice page
    
        Examples:
      | graphSubPage         |
   		| graph                | 
   		| graph representations|