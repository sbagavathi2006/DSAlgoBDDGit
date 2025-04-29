
@afterSignIn
Feature: Queue

Background:
Given User is on Queue page after clicks on Get Started button on Queue flex

   Scenario Outline: User lands on "<pages>" page for Queue
   	When User clicks on "<links>" link for Queue
    Then User redirected to "<pages>" page for Queue
    Examples:
    | links                                  | pages                                |
    | Implementation of  Queue in python     |Implementation-of-Queue-in-python    	|
    | Implementation using collections.deque |Implementation-using-collections      |
    | Implementation using array             |Implementation-using-array            |
    | Queue Operations                       |Queue-Operations                      |