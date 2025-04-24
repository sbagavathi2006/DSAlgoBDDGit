
@afterSignIn
Feature: Graph

  Background:
   Given  User is on graph page after clicks on Get Started button on Graph panel 
   
  Scenario Outline: Verify the user navigate to "<pages>" graph sub page
   When User clicks on "<links>" graph links
   Then User redirected to "<pages>" page
     Examples: 
   | links                | pages               |
   | graph                | graph               |
   | graph representations| graph-representations|

 
 
    
   
  



