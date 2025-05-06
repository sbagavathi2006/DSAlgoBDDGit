
@afterSignIn
Feature: TreePageTryEditor 

Background: 
   Given User is on TreePage after clicking its link in the Tree Page
   
   Scenario Outline: Verify user able to see Try here button for "<treeSubPage>"
   When user click the "<treeSubPage>" tree link
   Then user can see tree Try here button
   Examples:
   | treeSubPage                        |
   |overview of trees                   |
   | terminologies                      | 
   | types of trees                     | 
   | tree traversals                    | 
   | traversals-illustration            | 
   | binary trees                       | 
   | types of binary trees              | 
   | implementation in python           | 
   | binary tree traversals             |
   | implementation of binary trees     | 
   | applications of binary trees       | 
   | binary search trees                | 
   | implementation of bst              | 
   
   Scenario Outline: User lands on tryEditor page for "<treeSubPage>"
    Given User is on the "<treeSubPage>" tree subpage
    When the user click tree Try here button
    Then the user should redirected to the tryEditor tree page
    Examples:
   | treeSubPage                        |
   |overview of trees                   |
   | terminologies                      | 
   | types of trees                     | 
   | tree traversals                    | 
   | traversals-illustration            | 
   | binary trees                       | 
   | types of binary trees              | 
   | implementation in python           | 
   | binary tree traversals             |
   | implementation of binary trees     | 
   | applications of binary trees       | 
   | binary search trees                | 
   | implementation of bst              | 
   
   Scenario Outline: User able to see Run button after TryHere button click
      Given User is on the "<treeSubPage>" tree subpage
      When the user click tree Try here button
      Then The user should able to see tree Run button 
      Examples:
   | treeSubPage                        |
   |overview of trees                   |
   | terminologies                      | 
   | types of trees                     | 
   | tree traversals                    | 
   | traversals-illustration            | 
   | binary trees                       | 
   | types of binary trees              | 
   | implementation in python           | 
   | binary tree traversals             |
   | implementation of binary trees     | 
   | applications of binary trees       | 
   | binary search trees                | 
   | implementation of bst              | 
   
   Scenario Outline: User gets message when click on Runbtn with "<codeValidationsType>" code  snippet for "<treeSubPage>"  
      Given user is on tryeditor page for "<treeSubPage>"
      When user click Run button for "<treeSubPage>" treeSubPage with code "<codeValidationsType>" 
       Then user view message "<message>" for "<treeSubPage>" treeSubPage with code "<codeValidationsType>"
       
       Examples: 
   |treeSubPage                         | codeValidationsType        |     message      |
   | overview of trees                  |  EmptyRun   				       |     Error				|
   | overview of trees                  |  InvalidCodeRun            |     Error		    |	
   | overview of trees                  |  InvalidCodeRun            |     Error			  |
   | overview of trees                  |  ValidCodeRun   		       | OutputDisplayed  |
   | terminologies                      |  EmptyRun   				       |     Error				|
   | terminologies                      |  InvalidCodeRun            |     Error		    |	
   | terminologies                      |  InvalidCodeRun            |     Error		    |	
   | terminologies                      |   ValidCodeRun   		       | OutputDisplayed  |
   | types of trees                     |   EmptyRun   				       |     Error				|
   | types of trees                     |  InvalidCodeRun            |     Error		    |
   | types of trees                     |  InvalidCodeRun            |     Error		    |
   | types of trees                     |   ValidCodeRun   		       | OutputDisplayed  |
   | tree traversals                    |   EmptyRun   				       |     Error				|
   | tree traversals                    |   InvalidCodeRun           |     Error		    |
   | tree traversals                    |   InvalidCodeRun           |     Error		    |
   | tree traversals                    |   ValidCodeRun   		       | OutputDisplayed  |
   | traversals-illustration            |   EmptyRun   				       |     Error				|
   | traversals-illustration            |  InvalidCodeRun            |     Error		    |
   | traversals-illustration            |   InvalidCodeRun           |     Error		    |
   | traversals-illustration            |   ValidCodeRun   		       | OutputDisplayed  |
   | binary trees                       |   EmptyRun   				       |     Error				|
   | binary trees                       |   InvalidCodeRun           |     Error		    |
   | binary trees                       |   InvalidCodeRun           |     Error		    |
   | binary trees                       |   ValidCodeRun   		       | OutputDisplayed  |
   | types of binary trees              |   EmptyRun   				       |     Error				|
   | types of binary trees              |   InvalidCodeRun           |     Error		    |
   | types of binary trees              |   InvalidCodeRun           |     Error		    |
   | types of binary trees              |   ValidCodeRun   		       | OutputDisplayed  |
   | implementation in python           |   EmptyRun   				       |     Error				|
   | implementation in python           |   InvalidCodeRun           |     Error		    |
   | implementation in python           |   InvalidCodeRun           |     Error		    |
   | implementation in python           |   ValidCodeRun   		       | OutputDisplayed  |
   | binary tree traversals             |   EmptyRun   				       |     Error				|
   | binary tree traversals             |   InvalidCodeRun           |     Error		    |
   | binary tree traversals             |   InvalidCodeRun           |     Error		    |
   | binary tree traversals             |   ValidCodeRun   		       | OutputDisplayed  |
   | implementation of binary trees     |   EmptyRun   				       |     Error				|
   | implementation of binary trees     |   InvalidCodeRun           |     Error		    |
   | implementation of binary trees     |   InvalidCodeRun           |     Error		    |
   | implementation of binary trees     |   ValidCodeRun   		       | OutputDisplayed  |
   | applications of binary trees       |   EmptyRun   				       |     Error				|
   | applications of binary trees       |   InvalidCodeRun           |     Error		    |
   | applications of binary trees       |   InvalidCodeRun           |     Error		    |
   | applications of binary trees       |   ValidCodeRun   		       | OutputDisplayed  |
   | binary search trees                |   EmptyRun   				       |     Error				|
   | binary search trees                |   InvalidCodeRun           |     Error		    |
   | binary search trees                |   InvalidCodeRun           |     Error		    |
   | binary search trees                |   ValidCodeRun   		       | OutputDisplayed  |
   | implementation of bst              |   EmptyRun   				       |     Error				|
   | implementation of bst              |   InvalidCodeRun           |     Error		    |
   | implementation of bst              |   InvalidCodeRun           |     Error		    |
   | implementation of bst              |   ValidCodeRun   		       | OutputDisplayed  |
    
    Scenario Outline: User lands on Practice page
    Given User is on the "<treeSubPage>" tree subpage
    When User clicks on tree Practice Questions link
    Then User is redirected to tree practice page
    Examples:
   |  treeSubPage                       |
   |overview of trees                   |
   | terminologies                      | 
   | types of trees                     | 
   | tree traversals                    | 
   | traversals-illustration            | 
   | binary trees                       | 
   | types of binary trees              | 
   | implementation in python           | 
   | binary tree traversals             |
   | implementation of binary trees     | 
   | applications of binary trees       | 
   | binary search trees                | 
   | implementation of bst              | 
 
      
  Scenario Outline: user able to view tree Practice Questions 
    Given User is on the "<treeSubPage>" tree subpage
    When User clicks on tree Practice Questions link
    Then the user able to view the tree questions page
    Examples:
   |  treeSubPage                       |
   |overview of trees                   |
   | terminologies                      | 
   | types of trees                     | 
   | tree traversals                    | 
   | traversals-illustration            | 
   | binary trees                       | 
   | types of binary trees              | 
   | implementation in python           | 
   | binary tree traversals             |
   | implementation of binary trees     | 
   | applications of binary trees       | 
   | binary search trees                | 
   | implementation of bst              | 