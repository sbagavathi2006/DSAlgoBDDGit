
@afterSignIn
Feature: Tree

  Background:
   Given  User is on Tree page after clicks on Get Started button on Tree panel 
   
  Scenario Outline: Verify the user navigate to "<pages>" tree sub page
   When User clicks on "<links>" tree links
   Then User redirected to "<pages>" page
     Examples: 
   | links                              | pages                          |
   | overview of trees                  | overview-of-trees              |
   | terminologies                      | terminologies                  |
   | types of trees                     | types-of-trees                 |
   | tree traversals                    | tree-traversals                |
   | traversals-illustration            | traversals-illustration        |
   | binary trees                       | binary-trees                   |
   | types of binary trees              | types-of-binary-trees          |
   | implementation in python           | implementation-in-python       |
   | binary tree traversals             | binary-tree-traversals         |
   | implementation of binary trees     | implementation-of-binary-trees |
   | applications of binary trees       | applications-of-binary-trees   |
   | binary search trees                | binary-search-trees            |
   | implementation of bst              | implementation-of-bst          |
