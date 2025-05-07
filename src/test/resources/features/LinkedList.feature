
@afterSignIn
Feature: LinkedList

Background:
Given User is on LinkedList page after clicks on Get Started button on LinkedList flex

   Scenario Outline: User lands on "<pages>" page
   	When User clicks on "<links>" link of LinkedList 
    Then User redirected to "<pages>" page of LinkedList
    Examples:
    | links                                         | pages                            |
    | Introduction                                  | introduction                     |
    | Creating Linked LIst                          | creating-linked-list             |
    |	Types of Linked List                          | types-of-linked-list             |
    | Implement Linked List in Python               | implement-linked-list-in-python  |
    | Traversal                                     | traversal                        |
    | Insertion                                     | insertion-in-linked-list         |
    | Deletion                                      | deletion-in-linked-list          |