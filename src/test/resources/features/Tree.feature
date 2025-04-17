@afterSignIn
Feature: Tree

  Background:
   Given  User is on Tree page after clicks on Get Started button on Tree 
   
  Scenario Outline: Verify the user navigate to "<pages>" page
   Given User is in Tree 
   When User clicks on "<links>" link
   Then User should navigate to "<pages>" page
   
   Examples: 
   |      links                         |      pages                     |
   | Overview of Trees                  | overview of trees              |
   | Terminologies                      | terminologies                  |
   | Types of Trees                     | types of trees                 |
   | Tree Traversals                    | tree traversals                |
   | Traversals-Illustration            | traversals-illustration        |
   | Binary Trees                       | binary trees                   |
   | Types of Binary Trees              | types of binary trees          |
   | Implementation in Python           | implementation in python       |
   | Binary Tree Traversals             | binary tree traversals         |
   | Implementation of Binary Trees     | implementation of binary trees |
   | Applications of Binary trees       | applications of binary trees   |
   | Binary Search Trees                | binary search trees            |
   | Implementation Of BST              | implementation of bst          |