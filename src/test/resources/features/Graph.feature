
@afterSignIn
Feature: Graph

  Background:
   Given  User is on graph page after clicks on Get Started button on Graph 
   
  Scenario Outline: Verify the user navigate to "<pages>" page
   Given User is in Graph 
   When User clicks on "<links>" link for Graph
   Then User should navigate to "<pages>" page Graph
     Examples: 
   | links                | pages               |
   | Graph                | graph               |
   | Graph Representation | graph representation|

 
 
    
   
  



