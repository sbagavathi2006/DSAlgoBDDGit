
@afterSignIn
Feature: Array

Background:
	Given User is on array page after clicks on Get Started button on Array flex
	   
   Scenario Outline: User lands on "<pages>" page
    When User clicks on "<links>" array links
    Then User redirected to "<pages>" page

    Examples:
      | links                       | pages                          |
      | Arrays in Python            | arrays in python               |
      | Arrays Using List           | arrays using list              |
      | Basic Operations in Lists   | basic operations in lists      |
      | Applications of Array       | applications of array          |