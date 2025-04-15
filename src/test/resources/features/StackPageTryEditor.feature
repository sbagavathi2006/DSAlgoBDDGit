
@afterSignIn
Feature: StackPageTryEditor

Background:
	Given User is in the "<stackSubPage>" page after clicking its link in the Queue Page
	
  Scenario: Verify User able to see Try here button for "<stackSubPage>"
  	When  The user click the Try here button
    Then The user able to view Try here button
    
  Scenario: User lands on tryEditor page for "<stackSubPage>"
  	When The user clicks Try here button
    Then The user redirected to tryEditor page
    
  Scenario Outline: User verifies Run button visibility and behavior for different code states of  "<stackSubPage>"page
    Given The user is on the Try Editor page for "<testCases>"
    When The user clicks on Run button "<actions>"
    Then The user should see "<expectedResults>"
    
  Examples:
  |	stackSubPage                       | testCases       | actions                   | expectedResults                                            |
  | Operations In Stack                | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Operations In Stack                | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Operations In Stack                | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Operations In Stack                | validCodeRun    | with valid code           | output displayed in the console                            |
  | Implementation                     | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Implementation                     | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Implementation                     | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Implementation                     | validCodeRun    | with valid code           | output displayed in the console                            |
  | Applications                       | viewRunBtn      | with Try here button      | the Run button displayed                                   |
  | Applications                       | withoutCodeRun  | with empty window         | an appropriate error message in an alert window            |
  | Applications                       | invalidCodeRun  | with invalid code         | an error message NameError: name is not defined on line one|
  | Applications                       | validCodeRun    | with valid code           | output displayed in the console                            |
  
    Scenario: User lands on Practice page
    Given User is on the Applications page
    When User clicks on Practice Questions link on the Applications page
    Then User is redirected to the practice page