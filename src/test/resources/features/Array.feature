
@afterSignIn
Feature: Array

Background:
	Given User is on array page after clicks on Get Started button on Array flex
	   
   Scenario Outline: User lands on "<pages>" page
    When User clicks on "<links>" array links
    Then User redirected to "<pages>" page

    Examples:
      | links                       | pages                          |
      | arrays in python            | arrays-in-python               |
      | arrays using list           | arrays-using-list              |
      | basic operations in lists   | basic-operations-in-lists      |
      | applications of array       | applications-of-array          |