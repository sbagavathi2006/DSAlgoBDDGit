
@afterSignIn
Feature: QueuePageTryEditor

Background:
	Given User is in "<queueSubPage>" page after clicking its link in the Queue Page
	
  Scenario: Verify User able to see Try here button for "<queueSubPage>"
  	When  the User click the Try here button
    Then User able to view Try here button
    
  Scenario: User lands on tryEditor page for "<queueSubPage>"
  	When User clicks Try here button
    Then User redirected to tryEditor page
    
  Scenario Outline: User verifies Run button visibility and behavior for different code states of  "<queueSubPage>"page
    Given User is on the Try Editor page for "<testCases>"
    When User clicks on Run button "<actions>"
    Then User should see "<expectedResults>"
    
  Examples:
  | queueSubPage                                      | testCase        | action                    | expectedResult                                             |
  | Implementation of  Queue in python                | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Implementation of  Queue in python                | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Implementation of  Queue in python                | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Implementation of  Queue in python                | validCodeRun    | with valid code           | output displayed in the console                            |
  | Implementation using collections.deque            | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Implementation using collections.deque            | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Implementation using collections.deque            | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Implementation using collections.deque            | validCodeRun    | with valid code           | output displayed in the console                            |
  | Implementation using array                        | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Implementation using array                        | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Implementation using array                        | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Implementation using array                        | validCodeRun    | with valid code           | output displayed in the console                            |
  | Queue Operations                                  | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Queue Operations                                  | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Queue Operations                                  | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Queue Operations                                  | validCodeRun    | with valid code           | output displayed in the console                            |
  
   Scenario: User lands on Practice page
    Given User is on the Queue Operations of Queue page
    When User clicks on Practice Questions link on Queue Page
    Then User is redirected to practice page on Queue