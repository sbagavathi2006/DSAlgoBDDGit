
@afterSignIn
Feature: ArrayPageTryEditor
Background: 
Given User is on the arraypage

  Scenario Outline: User views Try here button for "<arraySubPage>"
    Given User is in "<arraySubPage>" page after clicking its link in array page
    When User scrolls to the end of the page
    Then User views Try here button
    
    Examples:
      | arraySubPage              	|
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |
      
  Scenario Outline: User navigates to tryEditor page for "<arraySubPage>"
    Given User is in "<arraySubPage>" page after clicking its link in array page
    When User clicks on Try here button
    Then User is redirected to the tryEditor page

    Examples:
      | arraySubPage              	|
      | arrays in python            |
      | arrays using list           |
      | basic operations in lists   |
      | applications of array       |

  Scenario Outline: User verifies Run button visibility and behavior for "<arraySubPage>" page
    Given User is on Try Editor page for "<testCase>"
    When User clicks on Run button "<action>" for "<arraySubPage>" page
    Then User should see "<expectedResult>" for "<arraySubPage>" page

    Examples:
      | arraySubPage              	| testCase         | action               | expectedResult                                              |
      | Arrays In Python            | viewRunBtn       | with Try here button | the Run button displayed                                    |
      | Arrays In Python            | withoutCodeRun   | with empty window    | an appropriate error message in an alert window             |
      | Arrays In Python            | invalidCodeRun   | with invalid code    | an error message NameError: name is not defined on line one |
      | Arrays In Python            | validCodeRun     | with valid code      | output displayed in the console                             |
      | Arrays Using List           | viewRunBtn       | with Try here button | the Run button displayed                                    |
      | Arrays Using List           | withoutCodeRun   | with empty window    | an appropriate error message in an alert window             |
      | Arrays Using List           | invalidCodeRun   | with invalid code    | an error message NameError: name is not defined on line one |
      | Arrays Using List           | validCodeRun     | with valid code      | output displayed in the console                             |
      | Basic Operations In Lists   | viewRunBtn       | with Try here button | the Run button displayed                                    |
      | Basic Operations In Lists   | withoutCodeRun   | with empty window    | an appropriate error message in an alert window             |
      | Basic Operations In Lists   | invalidCodeRun   | with invalid code    | an error message NameError: name is not defined on line one |
      | Basic Operations In Lists   | validCodeRun     | with valid code      | output displayed in the console                             |
      | Applications Of Array       | viewRunBtn       | with Try here button | the Run button displayed                                    |
      | Applications Of Array       | withoutCodeRun   | with empty window    | an appropriate error message in an alert window             |
      | Applications Of Array       | invalidCodeRun   | with invalid code    | an error message NameError: name is not defined on line one |
      | Applications Of Array       | validCodeRun     | with valid code      | output displayed in the console                             |

  Scenario: User lands on Practice page
    Given User is on the Applications of Array page
    When User clicks on Practice Questions link for Array Page
    Then User is redirected to practice page
