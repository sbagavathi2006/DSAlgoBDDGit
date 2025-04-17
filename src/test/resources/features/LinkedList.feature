
@afterSignIn
Feature: LinkedList

Background:
Given User is on LinkedList page after clicks on Get Started button on LinkedList flex

   Scenario Outline: User lands on "<pages>" page
   	When User clicks on "<links>" link of LinkedList 
    Then User redirected to "<pages>" page of LinkedList
    Examples:
    | links                                         | pages                            |
    | Creating Linked LIst                          | Creating Linked LIst             |
    |	Types of Linked List                          | Types of Linked List             |
    | Implement Linked List in Python               | Implement Linked List in Python  |
    | Traversal                                     | Traversal                        |
    | Insertion                                     | Insertion                        |
    | Deletion                                      | Deletion                         |