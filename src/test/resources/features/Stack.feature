
@afterSignIn
Feature: Stack

Background:
Given User is on Stack page after clicks on Get Started button on Stack flex

   Scenario Outline: User lands on "<pages>" page
   	When User clicks on "<links>" link for Stack
    Then User redirected to "<pages>" page
    
    Examples:
    | links                      | pages                     |
    | Operations In Stack        |  operations-in-stack      |
    | Operations In Stack        |Operations-In-Stack      |
    | Implementation             |Implementation             |
    | Applications               |Applications               |
