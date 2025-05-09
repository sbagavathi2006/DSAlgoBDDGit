
@afterSignIn
Feature: DataStructure

  Background:
Given User is on DataStructure page after clicks on Get Started button on DataStructure flex
 
  Scenario Outline: Title of your scenario outline
       When User clicks on "<links>" DataStructure links
       Then User redirected to "<pages>" page of DataStructure

    Examples: 
      | links           | pages | 
      | Time Complexity | time-complexity | 
      
