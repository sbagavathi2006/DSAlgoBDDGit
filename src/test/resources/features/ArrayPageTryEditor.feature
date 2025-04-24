
@afterSignIn
Feature: ArrayPageTryEditor
Background: 
Given User is on "<ArrayPage>" page after clicking its link in the Array Page
	
  Scenario Outline: Verify User able to see Try here button for "<arraySubPages>"
  	When  User click the "<arraySubPages>" link
    Then User can see view Try here button 
    
    Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |
    
  Scenario Outline: User lands on tryEditor page for "<arraySubPages>"
  	Given User is on the "<arraySubPages>" arraysubpage
  	When User click the Try here button
    Then User redirected to the tryEditor page
    
        Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |
      
  Scenario Outline: User able to see Run button after TryHere button click
  	Given User is on the "<arraySubPages>" arraysubpage 
  	When User click the Try here button
    Then User able to see Run button
    
        Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |
      
  Scenario Outline: User verifies Run button visibility and behavior for "<arraySubPages>" page
    Given User is on Try Editor page for row <rowNum>
    When User clicks on Run button for row <rowNum>
    Then User should see for row <rowNum>

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
      | 9    |
      | 10   |
      | 11   |
      | 12   |
      | 13   |
      | 14   |
      | 15   |
      | 16   |

  Scenario Outline: User lands on Practice page
    Given User is on the "<arraySubPages>" arraysubpage
    When User clicks on Practice Questions link
    Then User is redirected to practice page
    Examples:
      | arraySubPages               |
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |