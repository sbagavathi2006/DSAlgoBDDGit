@afterSignIn
Feature: GraphPageTryEditor

Background:
  Given User is on "<graphSubPage>" page after clicking its link in the Array flex

Scenario: Verify user able to see Try Here button for "<graphSubPage>"
   Given the user is in "<GraphSubPage>" page after clicking its link in graph page
   When the user click the tryhere button
   Then the user should be able to view the TryHere button

  Scenario: User lands on TryEditor page for "<graphSubPage>"
    When the user clicks the Try Here button 
    Then the user should redirected to the TryEditor page
    
    Scenario Outline: User verifies Run button visibility and behavior for different code states of "<graphSubPage>" page
      Given The user is in the TryEditor page for "<testCases>" on graph
      When The user clicks the Run button "<action>" for "<graphSubPage>"
      Then The user should able to see "<expectedResults>" for "<graphSubPage>"
      
      Examples: 
  |graphSubPage          | testCase        | action                | expectedResult                                             |
  | Graph                | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Graph                | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Graph                | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Graph                | validCodeRun    | with valid code       | output displayed in the console                            |
  | Graph Representation | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Graph Representation | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Graph Representation | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Graph Representation | validCodeRun    | with valid code       | output displayed in the console                            |
  
  
     
  Scenario: Navigate to Practice Questions page from Graph Representation page
    Given the user is in Graph Representation page
    When the user clicks the "Practice Questions" link on Graph Representation page
    Then the user should be redirected to the Practice Questions page on graph
     