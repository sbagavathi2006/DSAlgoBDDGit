@afterSignIn
Feature: TreePageTryEditor 

Background: 
   Given User is on "<treeSubPage>" page after clicking its link in the Array flex
   
   Scenario: Verify user able to see Try Here button for "<treeSubPage>"
   Given the user is in "<treeSubPage>" page after clicking its link in tree page
   When the user click the try here button on treesubpages
    Then the user should be able to view the Try Here button on treesubpages

  Scenario: User navigate to TryEditor page for "<treeSubPage>"
    When the user clicks the Try Here"button  on treesubpages
    Then the user should redirected to the TryEditor page on treesubpages
    
    Scenario Outline: User verifies Run button visibility and behavior for different code states of "<treeSubPage>" page
      Given The user is in the TryEditor page  "<testCases>" on treesubpages 
      When The user clicks the Run button "<action>" for "<treeSubPage>"
      Then The user should able to see "<expectedResults>" for "<treeSubPage>" 
      
       Examples: 
  |treeSubPage                      | testCase        | action                | expectedResult                                             |
  | Overview of Trees               | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Overview of Trees               | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Overview of Trees               | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Overview of Trees               | validCodeRun    | with valid code       | output displayed in the console                            |
  | Terminologies                   | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Terminologies                   | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Terminologies                   | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Terminologies                   | validCodeRun    | with valid code       | output displayed in the console                            |
  | Types of Trees                  | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Types of Trees                  | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Types of Trees                  | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Types of Trees                  | validCodeRun    | with valid code       | output displayed in the console                            |
  | Tree Traversals                 | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Tree Traversals                 | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Tree Traversals                 | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Tree Traversals                 | validCodeRun    | with valid code       | output displayed in the console                            |
  | Traversals-Illustration         | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Traversals-Illustration         | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Traversals-Illustration         | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Traversals-Illustration         | validCodeRun    | with valid code       | output displayed in the console                            |
  | Binary Trees                    | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Binary Trees                    | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Binary Trees                    | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Binary Trees                    | validCodeRun    | with valid code       | output displayed in the console                            |
  | Types of Binary Trees           | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Types of Binary Trees           | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Types of Binary Trees           | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Types of Binary Trees           | validCodeRun    | with valid code       | output displayed in the console                            |
  | Implementation in Python        | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Implementation in Python        | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Implementation in Python        | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Implementation in Python        | validCodeRun    | with valid code       | output displayed in the console                            |
  | Binary Tree Traversals          | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Binary Tree Traversals          | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Binary Tree Traversals          | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Binary Tree Traversals          | validCodeRun    | with valid code       | output displayed in the console                            |
  | Implementation of Binary Trees  | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Implementation of Binary Trees  | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Implementation of Binary Trees  | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Implementation of Binary Trees  | validCodeRun    | with valid code       | output displayed in the console                            |
  | Applications of Binary trees    | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Applications of Binary trees    | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Applications of Binary trees    | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Applications of Binary trees    | validCodeRun    | with valid code       | output displayed in the console                            |
  | Binary Search Trees             | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Binary Search Trees             | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Binary Search Trees             | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Binary Search Trees             | validCodeRun    | with valid code       | output displayed in the console                            |
  | Implementation Of BST           | viewRunBtn      | with Try here button  | the Run button displayed                                   |
  | Implementation Of BST           | withoutCodeRun  | with empty window     | an appropriate error message in an alert window            |
  | Implementation Of BST           | invalidCodeRun  | with invalid code     | an error message NameError: name is not defined on line one|
  | Implementation Of BST           | validCodeRun    | with valid code       | output displayed in the console                            |
  
  Scenario: Navigate to Practice Questions page from Implementation of BST page
    Given the user is in Implementation of BST page
    When the user clicks the "Practice Questions" link on Implementation of BST page
    Then the user should be directed to the Practice Questions page on tree
  