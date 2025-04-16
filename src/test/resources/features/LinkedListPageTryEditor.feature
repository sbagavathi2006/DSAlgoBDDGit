
@afterSignIn
Feature: LinkedListPageTryEditor

Background:
	Given User is on "<linkedListPage>" page after clicking its link in the Queue Page
	
  Scenario: Verify User able to see Try here button for "<linkedListSubPage>"
  	When  User click the Try here button
    Then User can see view Try here button
    
  Scenario: User lands on tryEditor page for "<linkedListSubPage>"
  	When User click Try here button
    Then User redirected to the tryEditor page
    
  Scenario Outline: User verifies Run button visibility and behavior for different code states of  "<linkedListSubPage>"page
    Given User is on the try Editor page for "<testCases>"
    When User click on Run button "<actions>"
    Then User able to see "<expectedResults>"
    
    Examples:
  | linkedListSubPage                   | testCase        | action                    | expectedResult                                             |
  | LinkedList                          | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | LinkedList                          | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | LinkedList                          | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  |	LinkedList                          | validCodeRun    | with valid code           | output displayed in the console                            |
  | Types of Linked List                | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Types of Linked List                | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Types of Linked List                | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Types of Linked List                | validCodeRun    | with valid code           | output displayed in the console                            |
  | Implement Linked List in Python     | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Implement Linked List in Python     | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  |	Implement Linked List in Python     | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Implement Linked List in Python     | validCodeRun    | with valid code           | output displayed in the console                            |
  | Traversal                           | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Traversal                           | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Traversal                           | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Traversal                           | validCodeRun    | with valid code           | output displayed in the console                            |
  |	Insertion                           | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Insertion                           | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Insertion                           | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Insertion                           | validCodeRun    | with valid code           | output displayed in the console                            |
  |	Deletion                            | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Deletion                            | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Deletion                            | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Deletion                            | validCodeRun    | with valid code           | output displayed in the console                            | 
  
  Scenario: User lands on Practice page
    Given User is on the Deletion page
    When User clicks on Practice Questions link 
    Then User is to redirected to practice page